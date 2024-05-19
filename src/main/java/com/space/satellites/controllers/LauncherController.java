package com.space.satellites.controllers;

import com.space.satellites.models.Launcher;
import com.space.satellites.service.LauncherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/launchers")
public class LauncherController {
    @Autowired
    private LauncherService launcherService;

    @PostMapping
    public ResponseEntity<Launcher> createLauncher(@RequestBody Launcher launcher) {
        return ResponseEntity.ok(launcherService.createLauncher(launcher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Launcher> getLauncherById(@PathVariable String id) {
        Launcher launcher = launcherService.getLauncherById(id);
        if (launcher != null) {
            return ResponseEntity.ok(launcher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Launcher> updateLauncher(@PathVariable String id, @RequestBody Launcher launcherDetails) {
        Launcher updatedLauncher = launcherService.updateLauncher(id, launcherDetails);
        if (updatedLauncher != null) {
            return ResponseEntity.ok(updatedLauncher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLauncher(@PathVariable String id) {
        launcherService.deleteLauncher(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Launcher>> getAllLaunchers() {
        return ResponseEntity.ok(launcherService.getAllLaunchers());
    }
}