CREATE TABLE place(
    id BIGINT(20),
    name VARCHAR(255),
    category ENUM('nature', 'tourism', 'culture', 'commerce', 'transport', 'dining', 'lodging'),
    longitude FLOAT,
    latitude FLOAT,
    level1 INT(11) NOT NULL,
    level2 INT(11) NOT NULL,
    level3 INT(11) NOT NULL,
    level4 INT(11) NOT NULL,
    PRIMARY KEY (id)
);
