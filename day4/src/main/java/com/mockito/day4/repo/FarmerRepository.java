package com.mockito.day4.repo;

import java.util.Optional;

import com.mockito.day4.model.Farmer;

public interface FarmerRepository {

    Optional<Farmer> findById(Long id);
    Farmer save(Farmer farmer);
    void deleteById(Long id);
    
}