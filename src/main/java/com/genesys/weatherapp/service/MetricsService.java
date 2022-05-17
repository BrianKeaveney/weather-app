package com.genesys.weatherapp.service;

import com.genesys.weatherapp.dto.Metrics;
import com.genesys.weatherapp.dto.MetricsRequest;
import com.genesys.weatherapp.dto.SensorQueryRequest;

public interface MetricsService {
    Metrics getMetrics(SensorQueryRequest sensorQueryRequest);

    Metrics addMetrics(MetricsRequest metricsRequest);
}
