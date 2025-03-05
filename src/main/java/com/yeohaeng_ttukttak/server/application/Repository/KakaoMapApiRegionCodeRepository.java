package com.yeohaeng_ttukttak.server.application.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.yeohaeng_ttukttak.server.application.config.KakaoMapApiConfig;
import com.yeohaeng_ttukttak.server.domain.place.RegionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class KakaoMapApiRegionCodeRepository implements RegionCodeRepository {

    private final KakaoMapApiConfig apiConfig;

    private final RestClient restClient = RestClient.builder()
            .baseUrl("https://dapi.kakao.com/v2")
            .defaultHeaders(httpHeaders -> {
                httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
            }).build();

    private static final String URI =  "/local/geo/coord2regioncode.json?x={longitude}&y={latitude}";

    @Override
    public Optional<RegionCode> findByCoords(double longitude, double latitude) {
        final ResponseEntity<JsonNode> response = restClient.get()
                .uri(URI, longitude, latitude)
                .header("Authorization", "KakaoAK %s".formatted(apiConfig.apiKey()))
                .retrieve()
                .toEntity(JsonNode.class);

        return Optional.of(response.getBody())
                .map(body -> body.get("documents"))
                .filter(JsonNode::isArray)
                .flatMap(documentsNode -> {
                    for (JsonNode documentNode : documentsNode) {
                        if (documentNode != null && documentNode.hasNonNull("region_type")
                                && "B".equals(documentNode.get("region_type").asText())) {
                            return Optional.of(documentNode.get("code").asText());
                        }
                    }
                    return Optional.empty();
                })
                .map(RegionCode::fromString);
    }

}
