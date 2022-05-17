package com.genesys.weatherapp.IT;

import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Arrays;

@Testcontainers
@ActiveProfiles(profiles = "it")
public class BaseIT {

    @Container
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer()
            .withDatabaseName("weather-app")
            .withUsername("postgres")
            .withPassword("secret");

    static {
        postgreSQLContainer.setPortBindings(Arrays.asList("5432"));
        postgreSQLContainer.setNetwork(Network.newNetwork());
        postgreSQLContainer.start();

        System.setProperty("spring.datasource.url", postgreSQLContainer.getJdbcUrl());

    }
}
