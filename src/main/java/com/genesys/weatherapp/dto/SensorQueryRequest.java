package com.genesys.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorQueryRequest {
    private ArrayList<String> sensorIds;
    private Date startDate;
    private Date endDate;
}
