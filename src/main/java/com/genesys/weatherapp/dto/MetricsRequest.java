package com.genesys.weatherapp.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
@Builder
public class MetricsRequest {
    private String sensorId;
    private int temperature;
    private int humidity;
    private Date date;
}
