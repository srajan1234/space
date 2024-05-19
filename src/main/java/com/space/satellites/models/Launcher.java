package com.space.satellites.models;

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
public class Launcher {

    @Id
    private String id;


    private String type;

    @Temporal(TemporalType.DATE)
    private Date registeredOn;

}


