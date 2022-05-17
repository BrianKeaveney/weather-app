package com.genesys.weatherapp.testutils;

import com.genesys.weatherapp.dto.Metrics;
import com.genesys.weatherapp.dto.MetricsRequest;
import com.genesys.weatherapp.dto.SensorQueryRequest;
import com.genesys.weatherapp.dto.SensorRequest;
import com.genesys.weatherapp.entity.Sensor;
import com.genesys.weatherapp.entity.Weather;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;

public class SampleDtos {
    private static final String CITY_NAME = "Galway";
    private static final String COUNTRY_NAME = "Ireland";
    private static final int HUMIDITY = 16;
    private static final int TEMPERATURE = 24;
    public static String SENSOR_ID = "asdfasdf";

    public static SensorRequest getSampleSensorRequest() {
        return SensorRequest.builder().sensorId(SENSOR_ID).cityName(CITY_NAME).countryName(COUNTRY_NAME).build();
    }

    public static Sensor getSampleSensor() {
        return Sensor.builder().id(SENSOR_ID).cityName(CITY_NAME).countryName(COUNTRY_NAME).build();
    }

    public static SensorQueryRequest getSampleSensorQueryRequest() {
        final var sensorIds = new ArrayList<String>();
        sensorIds.add(SENSOR_ID);
        return SensorQueryRequest.builder()
                .sensorIds(sensorIds)
                .startDate(new Date(getDate("2022/03/17 18:10:45")))
                .endDate(new Date(getDate("2022/05/17 18:10:45")))
                .build();
    }

    public static MetricsRequest getSampleMetricsRequest() {
        return MetricsRequest.builder()
                .humidity(HUMIDITY)
                .temperature(TEMPERATURE)
                .date(new Date(2022 - 05 - 17))
                .sensorId(SENSOR_ID)
                .build();
    }

    public static Metrics getSampleMetrics() {
        return Metrics.builder()
                .humidity(HUMIDITY)
                .temperature(TEMPERATURE)
                .build();
    }


    public static Set<Weather> getSampleWeatherSet() {
        final Set<Weather> weatherSet = Set.of(
                getSampleWeather(SENSOR_ID, (long) 124321),
                getSampleWeather(SENSOR_ID, (long) 112421)
        );

        return weatherSet;
    }

    public static Weather getSampleWeather(final String sensorId, final Long id) {
        return Weather.builder()
                .date(new Date(getDate("2022/05/17 18:10:45")))
                .id(id)
                .sensor(SampleDtos.getSampleSensor())
                .humidity(HUMIDITY)
                .temperature(TEMPERATURE)
                .build();
    }

    private static long getDate(final String date) {
        final LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));

        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
