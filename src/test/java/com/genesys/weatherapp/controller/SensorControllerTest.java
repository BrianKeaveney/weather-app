package com.genesys.weatherapp.controller;

import com.genesys.weatherapp.dto.SensorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.genesys.weatherapp.dto.SensorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SensorControllerTest {

    SensorController sensorController;

    @BeforeEach
    public void init() {
        sensorController = new SensorController();
    }

    @Test
    public void testRegisterSensorReturnsValidResponse() {
        final SensorRequest sensorRequest = SensorRequest.builder().build();

        final ResponseEntity<SensorResponse> sensorResponseResponseEntity = sensorController.registerSensor(sensorRequest);

        assertEquals(HttpStatus.OK, sensorResponseResponseEntity.getStatusCode());
        assertEquals("Success", sensorResponseResponseEntity.getBody().getMessage());
    }

}
