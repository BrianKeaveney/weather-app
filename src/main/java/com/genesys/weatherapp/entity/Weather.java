package com.genesys.weatherapp.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Weather {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
}
