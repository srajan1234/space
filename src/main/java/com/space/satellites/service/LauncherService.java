package com.space.satellites.service;

import com.space.satellites.models.Launcher;
import com.space.satellites.repositories.LauncherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LauncherService {
    @Autowired
    private LauncherRepository launcherRepository;

    public Launcher createLauncher(Launcher launcher) {
        log.info("Going to create launcher");
        return launcherRepository.save(launcher);
    }

    public Launcher getLauncherById(String id) {
        log.info("Going to get launcher");
        return launcherRepository.findById(id).orElse(null);
    }

    public Launcher updateLauncher(String id, Launcher launcherDetails) {
        log.info("Going to update launcher");
        Launcher launcher = launcherRepository.findById(id).orElse(null);
        if (launcher != null) {
            launcher.setType(launcherDetails.getType());
            launcher.setRegisteredOn(launcherDetails.getRegisteredOn());
            return launcherRepository.save(launcher);
        }
        return null;
    }

    public void deleteLauncher(String id) {
        log.info("Going to delete launcher");
        launcherRepository.deleteById(id);
    }

    public List<Launcher> getAllLaunchers() {
        log.info("Going to get all launchers");
        return launcherRepository.findAll();
    }
}

