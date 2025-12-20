package com.mockito.day7.service.impl;

import org.springframework.stereotype.Service;
import com.mockito.day7.service.CropService;

@Service
public class CropServiceImpl implements CropService {

    @Override
    public String predictCrop(Long fieldId) {
        return "Predicted crop for field " + fieldId + " is Wheat";
    }
}
