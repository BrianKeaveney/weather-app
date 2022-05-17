package com.genesys.weatherapp.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MetricsResponse {
    private Metrics metrics;
    private String message;
}
