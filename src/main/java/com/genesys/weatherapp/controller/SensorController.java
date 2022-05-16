package com.genesys.weatherapp.controller;

import com.genesys.weatherapp.dto.SensorRequest;
import com.genesys.weatherapp.dto.SensorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorController {

    @PostMapping("/sensor/register")
    public ResponseEntity<SensorResponse> registerSensor(@RequestBody SensorRequest sensorRequest) {
        return ResponseEntity.ok(SensorResponse.builder().message("Success").build());
    }
}
