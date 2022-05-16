package com.genesys.weatherapp.dto;

import com.genesys.weatherapp.entity.Sensor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensorResponse {
    private String message;
    private Sensor sensor;
}
