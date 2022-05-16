package com.genesys.weatherapp.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SensorRequest {
    private String sensorId;
    private String countryName;
    private String cityName;
}
