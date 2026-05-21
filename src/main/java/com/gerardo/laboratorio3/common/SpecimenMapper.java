package com.gerardo.laboratorio3.common;

import com.gerardo.laboratorio3.dto.request.CreateSpecimenRequest;
import com.gerardo.laboratorio3.dto.request.UpdateSpecimenRequest;
import com.gerardo.laboratorio3.dto.response.PageableResponse;
import com.gerardo.laboratorio3.dto.response.SpecimenResponse;
import com.gerardo.laboratorio3.model.Specimen;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SpecimenMapper {
    public Specimen toEntityCreate(CreateSpecimenRequest request) {
        return Specimen.builder()
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public Specimen toEntityUpdate(UpdateSpecimenRequest request, UUID id) {
        return Specimen.builder()
                .id(id)
                .name(request.getName())
                .region(request.getRegion())
                .dangerLevel(request.getDangerLevel())
                .isFriendly(request.getIsFriendly())
                .build();
    }

    public SpecimenResponse toDto(Specimen specimen) {
        return SpecimenResponse.builder()
                .id(specimen.getId())
                .name(specimen.getName())
                .region(specimen.getRegion())
                .dangerLevel(specimen.getDangerLevel())
                .isFriendly(specimen.getIsFriendly())
                .build();
    }

    public PageableResponse<SpecimenResponse> toPageableResponse(Page<Specimen> specimenPage) {
        return PageableResponse.<SpecimenResponse>builder()
                .content(
                        specimenPage.getContent()
                                .stream()
                                .map(this::toDto)
                                .collect(Collectors.toList())
                )
                .page(specimenPage.getNumber())
                .size(specimenPage.getSize())
                .totalElements(specimenPage.getTotalElements())
                .totalPages(specimenPage.getTotalPages())
                .first(specimenPage.isFirst())
                .last(specimenPage.isLast())
                .empty(specimenPage.isEmpty())
                .hasNext(specimenPage.hasNext())
                .hasPrevious(specimenPage.hasPrevious())
                .build();
    }
}
