package com.space.satellites.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.space.satellites.config.ApiConfig;
import com.space.satellites.dto.SatelliteResponse;
import com.space.satellites.models.CustomerSatellite;
import com.space.satellites.repositories.CustomerSatelliteRepository;
import com.space.satellites.repositories.LauncherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerSatelliteScheduler {

    private final CustomerSatelliteRepository customerSatelliteRepository;
    private final LauncherRepository launcherRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ApiConfig apiConfig;
    @Autowired
    public CustomerSatelliteScheduler(CustomerSatelliteRepository customerSatelliteRepository,
                                      LauncherRepository launcherRepository, ApiConfig apiConfig) {
        this.customerSatelliteRepository = customerSatelliteRepository;
        this.launcherRepository = launcherRepository;
        this.apiConfig = apiConfig;
    }

    @Scheduled(fixedRate = 10000)
    public void fetchAndSaveSatellites() throws JsonProcessingException {
        try {
            List<String> launcherIds = launcherRepository.findAllIds();

            if (!launcherIds.isEmpty()) {
                log.info("Going to fetch satellite data");
                String jsonResponse = restTemplate.getForObject(apiConfig.getSatelliteApiUrl(), String.class);
                log.info("Fetched satellite data" + jsonResponse);
                ObjectMapper objectMapper = new ObjectMapper();
                SatelliteResponse satelliteResponse = objectMapper.readValue(jsonResponse, SatelliteResponse.class);

                List<CustomerSatellite> filteredSatellites = satelliteResponse.getCustomerSatellites().stream()
                        .filter(satellite -> launcherIds.contains(satellite.getLauncher()))
                        .collect(Collectors.toList());
                if (!filteredSatellites.isEmpty()) {
                    customerSatelliteRepository.saveAll(filteredSatellites);
                }

            }
        } catch (Exception e) {
            log.info("Exception while running CustomerSatelliteScheduler" + e);
        }

    }
}
