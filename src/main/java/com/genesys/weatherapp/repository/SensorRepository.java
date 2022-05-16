package com.genesys.weatherapp.repository;

import com.genesys.weatherapp.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, String> {
}
