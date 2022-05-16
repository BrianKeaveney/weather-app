package com.genesys.weatherapp.service;

import com.genesys.weatherapp.dto.SensorRequest;
import com.genesys.weatherapp.entity.Sensor;
import com.genesys.weatherapp.repository.SensorRepository;
import com.genesys.weatherapp.service.impl.SensorServiceImpl;
import com.genesys.weatherapp.testutils.SampleDtos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SensorServiceImplTest {

    @Mock
    SensorRepository sensorRepository;

    @InjectMocks
    SensorServiceImpl sensorService;

    @Test
    public void test_registerSensor_returns_new_sensor() {
        final SensorRequest sensorRequest = SampleDtos.getSampleSensorRequest();
        final Sensor mock = mock(Sensor.class);

        when(sensorRepository.save(any(Sensor.class))).thenReturn(mock);

        final Sensor sensor = sensorService.registerSensor(sensorRequest);

        assertNotNull(sensor);
    }
}
