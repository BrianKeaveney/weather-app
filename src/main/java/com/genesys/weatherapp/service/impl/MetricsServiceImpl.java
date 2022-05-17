package com.genesys.weatherapp.service.impl;

import com.genesys.weatherapp.dto.Metrics;
import com.genesys.weatherapp.dto.MetricsRequest;
import com.genesys.weatherapp.dto.SensorQueryRequest;
import com.genesys.weatherapp.entity.Sensor;
import com.genesys.weatherapp.entity.Weather;
import com.genesys.weatherapp.repository.WeatherRepository;
import com.genesys.weatherapp.service.MetricsService;
import com.genesys.weatherapp.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MetricsServiceImpl implements MetricsService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private SensorService sensorService;


    @Override
    public Metrics getMetrics(final SensorQueryRequest sensorQueryRequest) {
        final ArrayList<List<Weather>> weatherList = new ArrayList<>();

        for (final var sensorId : sensorQueryRequest.getSensorIds()) {
            final Sensor sensor = getSensorById(sensorId);

            final Set<Weather> weatherForOneSensor = getWeatherForOneSensor(sensorQueryRequest.getStartDate(), sensorQueryRequest.getEndDate(), sensor.getId());
            weatherList.add(new ArrayList<>(weatherForOneSensor));
        }

        final List<Weather> list = weatherList.stream().flatMap(List::stream).collect(Collectors.toList());

        final Metrics metrics = buildMetrics(list);

        return metrics;
    }

    @Override
    public Metrics addMetrics(final MetricsRequest metricsRequest) {
        final Sensor sensor = getSensorById(metricsRequest.getSensorId());

        final Weather weather = weatherRepository.save(Weather.builder()
                .temperature(metricsRequest.getTemperature())
                .sensor(sensor)
                .date(metricsRequest.getDate())
                .humidity(metricsRequest.getHumidity())
                .build());

        return Metrics.builder()
                .humidity(weather.getHumidity())
                .temperature(weather.getTemperature())
                .build();
    }

    private Metrics buildMetrics(final List<Weather> weatherList) {
        final var temperatureAvg = (int) weatherList.stream()
                .map(weather -> weather.getTemperature())
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();

        final var humidityAvg = (int) weatherList.stream()
                .map(weather -> weather.getHumidity())
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();

        final Metrics metrics = Metrics.builder().humidity(humidityAvg).temperature(temperatureAvg).build();

        return metrics;
    }

    private Set<Weather> getWeatherForOneSensor(final Date start, final Date end, final String sensorId) {
        final Set<Weather> weatherSet;
        if (start != null && end != null) {
            weatherSet = weatherRepository.getWeatherBetweenTwoDates(start, end, sensorId);
        } else {
            weatherSet = weatherRepository.getWeatherBySensorId(sensorId);
        }

        return weatherSet;
    }

    private Sensor getSensorById(final String sensorId) {
        return sensorService.getSensor(sensorId);
    }

}
