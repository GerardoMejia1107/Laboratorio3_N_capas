package com.gerardo.laboratorio3.services;

import com.gerardo.laboratorio3.dto.request.CreateSpecimenRequest;
import com.gerardo.laboratorio3.dto.request.UpdateSpecimenRequest;
import com.gerardo.laboratorio3.dto.response.SpecimenResponse;

import java.util.List;
import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);

    List<SpecimenResponse> getAllSpecimens();

    SpecimenResponse getSpecimenById(UUID id);

    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);

    SpecimenResponse deleteSpecimen(UUID id);
}
