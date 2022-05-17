package com.genesys.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    @JsonBackReference
    private Sensor sensor;

    private int humidity;

    private int temperature;

    private Date date;
}
