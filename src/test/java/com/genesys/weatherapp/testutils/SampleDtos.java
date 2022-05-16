package com.genesys.weatherapp.testutils;

import com.genesys.weatherapp.dto.SensorRequest;
import com.genesys.weatherapp.entity.Sensor;

public class SampleDtos {
    private static final String SENSOR_ID = "ajdsfs";
    private static final String CITY_NAME = "Galway";
    private static final String COUNTRY_NAME = "Ireland";


    public static SensorRequest getSampleSensorRequest() {
        return SensorRequest.builder().sensorId(SENSOR_ID).cityName(CITY_NAME).countryName(COUNTRY_NAME).build();
    }

    public static Sensor getSampleSensor() {
        return Sensor.builder().id(SENSOR_ID).cityName(CITY_NAME).countryName(COUNTRY_NAME).build();
    }
}
