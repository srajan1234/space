package com.space.satellites.controllers;

import com.space.satellites.models.CustomerSatellite;
import com.space.satellites.service.CustomerSatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/customer_satellites")
public class CustomerSatelliteController {
    @Autowired
    private CustomerSatelliteService customerSatelliteService;

    @PostMapping
    public ResponseEntity<CustomerSatellite> createCustomerSatellite(@RequestBody CustomerSatellite customerSatellite) {
        return ResponseEntity.ok(customerSatelliteService.createCustomerSatellite(customerSatellite));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerSatellite> getCustomerSatelliteById(@PathVariable String id) {
        CustomerSatellite satellite = customerSatelliteService.getCustomerSatelliteById(id);
        if (satellite != null) {
            return ResponseEntity.ok(satellite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerSatellite> updateCustomerSatellite(@PathVariable String id, @RequestBody CustomerSatellite satelliteDetails) {
        CustomerSatellite updatedSatellite = customerSatelliteService.updateCustomerSatellite(id, satelliteDetails);
        if (updatedSatellite != null) {
            return ResponseEntity.ok(updatedSatellite);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerSatellite(@PathVariable String id) {
        customerSatelliteService.deleteCustomerSatellite(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerSatellite>> getAllCustomerSatellites() {
        return ResponseEntity.ok(customerSatelliteService.getAllCustomerSatellites());
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerSatellite>> searchCustomerSatellites(@RequestParam(required = false) String id,
                                                                            @RequestParam(required = false)
                                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") Date launchDate,
                                                                            @RequestParam(required = false) String country,
                                                                            @RequestParam(required = false) String launcherId,
                                                                            @RequestParam(required = false) Double mass) {
        List<CustomerSatellite> results = customerSatelliteService.searchCustomerSatellites(id, launchDate, country, launcherId, mass);
        return ResponseEntity.ok(results);
    }
}
