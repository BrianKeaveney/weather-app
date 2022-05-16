package com.genesys.weatherapp.controller;

import com.genesys.weatherapp.dto.SensorRequest;
import com.genesys.weatherapp.dto.SensorResponse;
import com.genesys.weatherapp.entity.Sensor;
import com.genesys.weatherapp.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SensorController {

    private final SensorService sensorService;

    public SensorController(final SensorService sensorService) {
        this.sensorService = sensorService;
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

}
