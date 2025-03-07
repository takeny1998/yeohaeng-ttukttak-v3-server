CREATE TABLE IF NOT EXISTS region (
    id BIGINT(20),
    name VARCHAR(255) NOT NULL,
    parent_id BIGINT(20),
    level INT(11) NOT NULL,
    level1 INT(11) NOT NULL,
    level2 INT(11) NOT NULL,
    level3 INT(11) NOT NULL,
    level4 INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (parent_id) REFERENCES region(id)
);

ALTER TABLE place DROP COLUMN level1;
ALTER TABLE place DROP COLUMN level2;
ALTER TABLE place DROP COLUMN level3;
ALTER TABLE place DROP COLUMN level4;

ALTER TABLE place ADD COLUMN region_id BIGINT(20);
ALTER TABLE place ADD FOREIGN KEY (region_id) REFERENCES region(id);