package com.mockito.day4.service;

import java.util.Optional;

import com.mockito.day4.model.Farmer;
import com.mockito.day4.repo.FarmerRepository;



public class FertilizerService {

    private final FarmerRepository farmerRepository;
    
    public FertilizerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public String recommendFertilizerFor(Long farmerId) {
        Optional<Farmer> opt = farmerRepository.findById(farmerId);
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Farmer not found: " + farmerId);
        }
        Farmer f = opt.get();
        int avg = (f.getN() + f.getP() + f.getK()) / 3;
        if (avg < 30) return "Apply high NPK mix";
        if (avg > 80) return "Reduce NPK";
        return "Balanced";
    }

    public Farmer addFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public void removeFarmer(Long id) {
        farmerRepository.deleteById(id);
    }
}