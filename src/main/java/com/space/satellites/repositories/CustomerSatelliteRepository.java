package com.space.satellites.repositories;

import com.space.satellites.models.CustomerSatellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerSatelliteRepository extends JpaRepository<CustomerSatellite, String> {
    List<CustomerSatellite> findByIdOrLaunchDateOrCountryOrLauncherOrMass(String id, Date launchDate,
                                                                          String country, String launcher, Double mass);
}
