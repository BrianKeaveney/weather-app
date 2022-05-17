package com.genesys.weatherapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SensorQueryResponse {
    private String message;
    private Metrics metrics;
}
