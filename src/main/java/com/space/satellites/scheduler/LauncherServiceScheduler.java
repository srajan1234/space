package com.space.satellites.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.space.satellites.config.ApiConfig;
import com.space.satellites.dto.LauncherResponse;
import com.space.satellites.models.Launcher;
import com.space.satellites.repositories.LauncherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class LauncherServiceScheduler {
    private final LauncherRepository launcherRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ApiConfig apiConfig;

    @Autowired
    public LauncherServiceScheduler(LauncherRepository launcherRepository, ApiConfig apiConfig) {
        this.launcherRepository = launcherRepository;
        this.apiConfig = apiConfig;
    }

    @Scheduled(fixedRate = 5000)
    public void fetchAndSaveLaunchers() throws JsonProcessingException {
        try {
            log.info("Going to fetch launcher data");
            String launcherIds = restTemplate.getForObject(apiConfig.getLauncherApiUrl(), String.class);
            log.info("Fetch launcher data" + launcherIds);
            ObjectMapper objectMapper = new ObjectMapper();
            LauncherResponse launcherResponse = objectMapper.readValue(launcherIds, LauncherResponse.class);

            if (launcherResponse != null) {
                for (Launcher launcher : launcherResponse.getLaunchers()) {
                    launcherRepository.save(launcher);
                }
            }
        } catch (Exception e) {
            log.info("Exception while running LauncherServiceScheduler" + e);
        }
    }
}
