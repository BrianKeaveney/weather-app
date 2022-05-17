package com.genesys.weatherapp.controller;

import com.genesys.weatherapp.dto.*;
import com.genesys.weatherapp.entity.Sensor;
import com.genesys.weatherapp.service.MetricsService;
import com.genesys.weatherapp.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SensorController {

    private final SensorService sensorService;
    private final MetricsService metricsService;

    public SensorController(final SensorService sensorService, final MetricsService metricsService) {
        this.sensorService = sensorService;
        this.metricsService = metricsService;
    }

    @PostMapping("/sensor/register")
    public ResponseEntity<SensorResponse> registerSensor(@RequestBody final SensorRequest sensorRequest) {
        final Sensor sensor = sensorService.registerSensor(sensorRequest);

        return ResponseEntity.ok(SensorResponse.builder().sensor(sensor).message("Success").build());
    }

    @GetMapping("/sensor")
    public ResponseEntity<SensorResponse> getSensor(@RequestParam final String id) {
        final Sensor sensor = sensorService.getSensor(id);

        return ResponseEntity.ok(SensorResponse.builder().sensor(sensor).message("Success").build());
    }

    @PostMapping("/sensor/metrics/get")
    public ResponseEntity<SensorQueryResponse> getMetrics(@RequestBody final SensorQueryRequest sensorQueryRequest) {
        final Metrics metrics = metricsService.getMetrics(sensorQueryRequest);

        return ResponseEntity.ok(SensorQueryResponse.builder().metrics(metrics).message("Success").build());
    }

    @PostMapping("/sensor/metrics")
    public ResponseEntity<MetricsResponse> addMetrics(@RequestBody final MetricsRequest metricsRequest) {
        final Metrics metrics = metricsService.addMetrics(metricsRequest);

        return ResponseEntity.ok(MetricsResponse.builder().metrics(metrics).message("Success").build());
    }

}
