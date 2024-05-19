package com.space.satellites.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CustomerSatellite {

    @Id
    private String id;

    @Temporal(TemporalType.DATE)
    @JsonProperty("launch_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date launchDate;

    private String country;
    private String launcher;
    private double mass;

}
