package com.mockito.day6.service;

import com.mockito.day6.model.FieldData;
import com.mockito.day6.repo.FieldRepository;

public class CropPredictionService {

    private final FieldRepository fieldRepository;

    public CropPredictionService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }   

    public String predictCrop(Long fieldId){
        FieldData data = fieldRepository.findById(fieldId)
                .orElseThrow(() -> new IllegalArgumentException("Field data not found"));

         int avg = (data.getN() + data.getP() + data.getK()) / 3;
         if(avg < 30 && data.getRainfall() < 50) return "Maize";
         if(avg >= 30 && data.getRainfall() < 100) return "Wheat";
         return "Rice";       
    }

}
