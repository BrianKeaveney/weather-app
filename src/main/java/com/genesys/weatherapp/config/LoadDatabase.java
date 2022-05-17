package com.genesys.weatherapp.config;

import com.genesys.weatherapp.entity.Sensor;
import com.genesys.weatherapp.entity.Weather;
import com.genesys.weatherapp.repository.SensorRepository;
import com.genesys.weatherapp.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(final SensorRepository repository, final WeatherRepository weatherRepository) {

        return args -> {

            final Sensor sensor = Sensor.builder().sensorId("asdfasdf").cityName("Galway").countryName("Ireland").build();
            repository.save(sensor);

            weatherRepository.save(Weather.builder().humidity(16).temperature(24).sensor(sensor).date(new Date(System.currentTimeMillis())).build());
        };

    }
}
