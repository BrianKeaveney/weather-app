package com.genesys.weatherapp.repository;

import com.genesys.weatherapp.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SensorRepository extends JpaRepository<Sensor, String> {

    @Query(value = "SELECT s FROM Sensor s WHERE s.sensorId = ?1")
    Sensor findBySensorId(String sensorId);
}
