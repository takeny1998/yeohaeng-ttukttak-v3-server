package com.yeohaeng_ttukttak.server.application.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Profile("local")
@Configuration
public class FlywayLocalConfig {

    @Autowired
    public FlywayLocalConfig(DataSource dataSource) {
        Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(dataSource)
                .locations("classpath:db/data", "classpath:/db/migration")
                .load().migrate();
    }

}
