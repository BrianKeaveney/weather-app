package com.genesys.weatherapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Metrics {
    private int temperature;
    private int humidity;
}
