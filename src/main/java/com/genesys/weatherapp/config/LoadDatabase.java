package com.genesys.weatherapp.config;

import com.genesys.weatherapp.entity.Sensor;
import com.genesys.weatherapp.repository.SensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(final SensorRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(Sensor.builder().sensorId("asdfasdf").cityName("Galway").countryName("Dublin").build()));
            repository.findAll().forEach(sensor -> log.info(sensor.getSensorId()));
        };

    }
}
