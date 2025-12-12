package com.mockito.day7.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mockito.day7.service.CropService;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    private final CropService cropService;
    public CropController(CropService cropService) { this.cropService = cropService; }

    @GetMapping("/predict")
    public ResponseEntity<String> predict(@RequestParam Long fieldId) {
        return ResponseEntity.ok(cropService.predictCrop(fieldId));
    }
}
