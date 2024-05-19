package com.space.satellites.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.space.satellites.models.Launcher;
import lombok.Data;

import java.util.List;

@Data
public class LauncherResponse {

    @JsonProperty("launchers")
    private List<Launcher> Launchers;

}
