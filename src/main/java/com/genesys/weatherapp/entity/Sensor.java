package com.genesys.weatherapp.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Getter
@Entity
@Builder
public class Sensor {

    @Id
    @Column(nullable = false)
    private String id;

    private String countryName;

    private String cityName;

    @OneToMany(mappedBy = "sensor")
    private ArrayList<Weather> weatherList;
}
