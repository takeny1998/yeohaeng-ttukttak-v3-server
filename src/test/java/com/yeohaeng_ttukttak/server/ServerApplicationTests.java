package com.yeohaeng_ttukttak.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.jpa.hibernate.ddl-auto=validate", "spring.flyway.enabled=true"})
class ServerApplicationTests {

	@Test
	void contextLoads() {
	}

}
