package com.space.satellites.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Value("${api.satellite.url}")
    private String satelliteApiUrl;

    @Value("${api.launcher.url}")
    private String launcherApiUrl;

    public String getSatelliteApiUrl() {
        return satelliteApiUrl;
    }

    public String getLauncherApiUrl() {
        return launcherApiUrl;
    }
}

