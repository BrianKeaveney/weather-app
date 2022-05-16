package com.genesys.weatherapp.controller;

import com.genesys.weatherapp.dto.SensorRequest;
import com.genesys.weatherapp.dto.SensorResponse;
import com.genesys.weatherapp.service.SensorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SensorControllerTest {

    @Mock
    SensorService sensorService;
    @InjectMocks
    SensorController sensorController;

    @Test
    public void testRegisterSensorReturnsValidResponse() {
        final SensorRequest sensorRequest = SensorRequest.builder().build();

        final ResponseEntity<SensorResponse> sensorResponseResponseEntity = sensorController.registerSensor(sensorRequest);

        assertEquals(HttpStatus.OK, sensorResponseResponseEntity.getStatusCode());
        assertEquals("Success", sensorResponseResponseEntity.getBody().getMessage());
    }

}
