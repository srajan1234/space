package com.space.satellites.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.space.satellites.models.CustomerSatellite;
import lombok.Data;

import java.util.List;

@Data
public class SatelliteResponse {

    @JsonProperty("customer_satellites")
    private List<CustomerSatellite> customerSatellites;

}
