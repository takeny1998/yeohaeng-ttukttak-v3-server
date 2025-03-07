CREATE TABLE IF NOT EXISTS visit(
    id BIGINT(20),
    visited_on DATE NOT NULL,
    rating FLOAT NOT NULL,
    place_id BIGINT(20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (place_id) REFERENCES place(id)
);