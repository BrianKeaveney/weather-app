package com.genesys.weatherapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensorResponse {
    private String message;
}
