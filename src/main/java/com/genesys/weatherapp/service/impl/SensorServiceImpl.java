package com.genesys.weatherapp.service.impl;

import com.genesys.weatherapp.dto.SensorRequest;
import com.genesys.weatherapp.entity.Sensor;
import com.genesys.weatherapp.repository.SensorRepository;
import com.genesys.weatherapp.service.SensorService;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(final SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Sensor registerSensor(final SensorRequest sensorRequest) {
        final Sensor sensor = mapToSensor(sensorRequest);

        final Sensor entity = sensorRepository.save(sensor);

        return entity;
    }

    @Override
    public Sensor getSensor(final String sensorId) {

        return sensorRepository.findBySensorId(sensorId);
    }

    private Sensor mapToSensor(final SensorRequest sensorRequest) {
        return Sensor.builder()
                .countryName(sensorRequest.getCountryName())
                .sensorId(sensorRequest.getSensorId())
                .cityName(sensorRequest.getCityName())
                .build();
    }
}
