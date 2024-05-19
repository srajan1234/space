package com.space.satellites.service;

import com.space.satellites.models.CustomerSatellite;
import com.space.satellites.repositories.CustomerSatelliteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CustomerSatelliteService {
    @Autowired
    private CustomerSatelliteRepository customerSatelliteRepository;

    public CustomerSatellite createCustomerSatellite(CustomerSatellite customerSatellite) {
        log.info("Going to create CustomerSatellite");
        return customerSatelliteRepository.save(customerSatellite);
    }

    public CustomerSatellite getCustomerSatelliteById(String id) {
        log.info("Going to get CustomerSatellite");
        return customerSatelliteRepository.findById(id).orElse(null);
    }

    public CustomerSatellite updateCustomerSatellite(String id, CustomerSatellite satelliteDetails) {
        log.info("Going to update CustomerSatellite");
        CustomerSatellite satellite = customerSatelliteRepository.findById(id).orElse(null);
        if (satellite != null) {
            satellite.setCountry(satelliteDetails.getCountry());
            satellite.setLaunchDate(satelliteDetails.getLaunchDate());
            satellite.setMass(satelliteDetails.getMass());
            return customerSatelliteRepository.save(satellite);
        }
        return null;
    }

    public void deleteCustomerSatellite(String id) {
        log.info("Going to delete CustomerSatellite");
        customerSatelliteRepository.deleteById(id);
    }

    public List<CustomerSatellite> getAllCustomerSatellites() {
        log.info("Going to get all CustomerSatellite");
        return customerSatelliteRepository.findAll();
    }

    public List<CustomerSatellite> searchCustomerSatellites(String id, Date launchDate, String country, String launcher, Double mass) {
        log.info("Going to search CustomerSatellite on :-" + id + " " + launchDate + " " + country + " " + launcher +
                " " + mass);
        return customerSatelliteRepository.findByIdOrLaunchDateOrCountryOrLauncherOrMass(id, launchDate, country,
                launcher, mass);
    }

}