package com.genesys.weatherapp.service;

import com.genesys.weatherapp.dto.Metrics;
import com.genesys.weatherapp.dto.SensorQueryRequest;
import com.genesys.weatherapp.entity.Weather;
import com.genesys.weatherapp.repository.WeatherRepository;
import com.genesys.weatherapp.service.impl.MetricsServiceImpl;
import com.genesys.weatherapp.testutils.SampleDtos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MetricsServiceImplTest {

    @Mock
    WeatherRepository weatherRepository;

    @Mock
    SensorService sensorService;

    @InjectMocks
    MetricsServiceImpl metricsService;

    @Test
    public void testGetMetricsBetweenDatesReturnsValidMetrics() {
        final SensorQueryRequest sampleSensorQueryRequest = SampleDtos.getSampleSensorQueryRequest();
        final Metrics sampleMetrics = SampleDtos.getSampleMetrics();

        when(sensorService.getSensor(any(String.class))).thenReturn(SampleDtos.getSampleSensor());
        when(weatherRepository.getWeatherBetweenTwoDates(any(Date.class), any(Date.class), any(String.class)))
                .thenReturn(SampleDtos.getSampleWeatherSet());

        final Metrics metrics = metricsService.getMetrics(sampleSensorQueryRequest);

        assertEquals(sampleMetrics.getHumidity(), metrics.getHumidity());
        assertEquals(sampleMetrics.getTemperature(), metrics.getTemperature());
    }

    @Test
    public void testAddMetricsReturnsValidMetrics() {
        final Metrics sampleMetrics = SampleDtos.getSampleMetrics();

        when(weatherRepository.save(any(Weather.class))).thenReturn(SampleDtos.getSampleWeather("asdfasdf", (long) 1234));

        final Metrics metrics = metricsService.addMetrics(SampleDtos.getSampleMetricsRequest());

        assertEquals(sampleMetrics.getHumidity(), metrics.getHumidity());
        assertEquals(sampleMetrics.getTemperature(), metrics.getTemperature());
    }
}
