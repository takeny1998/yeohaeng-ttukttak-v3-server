CREATE TABLE image (
    id BIGINT(20),
    url VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE place_image (
    id BIGINT(20),
    place_id BIGINT(20) NOT NULL,
    image_id BIGINT(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (place_id) REFERENCES place(id),
    FOREIGN KEY (image_id) REFERENCES image(id)
);
