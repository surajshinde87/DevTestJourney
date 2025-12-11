package com.mockito.day6.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.day6.model.FieldData;
import com.mockito.day6.repo.FieldRepository;


@ExtendWith(MockitoExtension.class)
class CropPredictionServiceTest {


@Mock
private FieldRepository fieldRepo;


@InjectMocks
private CropPredictionService cropService;


@BeforeEach
void setup() {}


@Test
void predictCrop_maize() {
FieldData data = new FieldData(1L, 20, 25, 30, 40);
when(fieldRepo.findById(1L)).thenReturn(Optional.of(data));


String crop = cropService.predictCrop(1L);
assertEquals("Maize", crop);
}


@Test
void predictCrop_wheat() {
FieldData data = new FieldData(2L, 40, 50, 60, 60);
when(fieldRepo.findById(2L)).thenReturn(Optional.of(data));


String crop = cropService.predictCrop(2L);
assertEquals("Wheat", crop);
}


@Test
void predictCrop_rice() {
FieldData data = new FieldData(3L, 90, 90, 90, 150);
when(fieldRepo.findById(3L)).thenReturn(Optional.of(data));


String crop = cropService.predictCrop(3L);
assertEquals("Rice", crop);
}


@Test
void predictCrop_fieldNotFound_throws() {
when(fieldRepo.findById(10L)).thenReturn(Optional.empty());
assertThrows(IllegalArgumentException.class, () -> cropService.predictCrop(10L));
}
}