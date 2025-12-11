package com.mockito.day6.repo;

import java.util.Optional;

import com.mockito.day6.model.FieldData;

public interface FieldRepository {

    Optional<FieldData> findById(Long id);
    
}
