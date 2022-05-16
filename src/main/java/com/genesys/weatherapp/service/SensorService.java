package com.genesys.weatherapp.service;

import com.genesys.weatherapp.dto.SensorRequest;
import com.genesys.weatherapp.entity.Sensor;

public interface SensorService {
    Sensor registerSensor(SensorRequest sensorRequest);

    Sensor getSensor(String sensorId);
}
