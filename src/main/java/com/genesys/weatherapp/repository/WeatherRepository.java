package com.genesys.weatherapp.repository;

import com.genesys.weatherapp.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.Set;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    @Query(value = "SELECT w FROM Weather w WHERE w.sensor.id = ?3 AND w.date >= ?1 AND w.date <= ?2")
    Set<Weather> getWeatherBetweenTwoDates(Date startDate, Date endDate, String sensorId);

    @Query(value = "SELECT w FROM Weather w WHERE w.sensor.id = ?1")
    Set<Weather> getWeatherBySensorId(String sensorId);
}
