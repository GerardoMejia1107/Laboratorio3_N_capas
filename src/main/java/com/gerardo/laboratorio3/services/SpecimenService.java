package com.gerardo.laboratorio3.services;

import com.gerardo.laboratorio3.dto.request.CreateSpecimenRequest;
import com.gerardo.laboratorio3.dto.request.UpdateSpecimenRequest;
import com.gerardo.laboratorio3.dto.response.PageableResponse;
import com.gerardo.laboratorio3.dto.response.SpecimenResponse;

import java.util.List;
import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);

    PageableResponse<SpecimenResponse> getAllSpecimens(
            Integer page,
            Integer size,
            String sortBy,
            String sortOrder
    );

    SpecimenResponse getSpecimenById(UUID id);

    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);

    SpecimenResponse deleteSpecimen(UUID id);
}
