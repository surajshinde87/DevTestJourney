package com.mockito.day4.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.day4.model.Farmer;
import com.mockito.day4.repo.FarmerRepository;


@ExtendWith(MockitoExtension.class)
public class FertilizerServiceTest {

    @Mock
    private FarmerRepository farmerRepository;

    @InjectMocks
    private FertilizerService fertilizerService;

    private Farmer farmer;

    @BeforeEach
    public void setUp() {
        farmer = new Farmer();
        farmer.setId(1L);
        farmer.setName("Suraj");
        farmer.setN(20);
        farmer.setP(25);
        farmer.setK(30);
    }

    @Test
    void recommendFertilizer_lowNpk() {
        // Arrange stub repo
        when(farmerRepository.findById(1L)).thenReturn(Optional.of(farmer));

        // Act
        String recommendation = fertilizerService.recommendFertilizerFor(1L);

        // Assert
        assertEquals("Apply high NPK mix", recommendation);

        // Verify
        verify(farmerRepository, times(1)).findById(1L);
    }

    @Test
    void recommendFertilizer_farmerNotFound() {
        when(farmerRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> fertilizerService.recommendFertilizerFor(2L));
        verify(farmerRepository).findById(2L);
    }

    @Test
    void addFarmer_savesFarmer() {
        when(farmerRepository.save(any(Farmer.class))).thenReturn(farmer);

        Farmer saved = fertilizerService.addFarmer(farmer);

        assertNotNull(saved);
        assertEquals("Suraj", saved.getName());

        // capture what was saved
        ArgumentCaptor<Farmer> captor = ArgumentCaptor.forClass(Farmer.class);
        verify(farmerRepository).save(captor.capture());
        assertEquals("Suraj", captor.getValue().getName());
    }

    @Test
    void removeFarmer_invokesDelete() {
        // delete returns void — just verify behavior
        doNothing().when(farmerRepository).deleteById(1L);

        fertilizerService.removeFarmer(1L);

        verify(farmerRepository).deleteById(1L);
    }

    @Test
    void addFarmer_whenRepoThrows_shouldPropagate() {
        when(farmerRepository.save(any(Farmer.class))).thenThrow(new RuntimeException("DB down"));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> fertilizerService.addFarmer(farmer));
        assertEquals("DB down", ex.getMessage());
        verify(farmerRepository).save(any(Farmer.class));
    }

}