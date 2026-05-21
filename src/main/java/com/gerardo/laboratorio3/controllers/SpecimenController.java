package com.gerardo.laboratorio3.controllers;

import com.gerardo.laboratorio3.dto.GeneralResponse;
import com.gerardo.laboratorio3.dto.request.CreateSpecimenRequest;
import com.gerardo.laboratorio3.dto.response.SpecimenResponse;
import com.gerardo.laboratorio3.services.SpecimenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SpecimenController {
    private final SpecimenService specimenService;

    @PostMapping("/specimen")
    public ResponseEntity<GeneralResponse> createSpecimen(@Valid @RequestBody CreateSpecimenRequest request) {
        return buildResponse(
                "Specimen created successfully",
                HttpStatus.CREATED,
                specimenService.createSpecimen(request)
        );
    }

    @GetMapping("/specimens")
    public ResponseEntity<GeneralResponse> listAllSpecimens(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        return buildResponse(
                "Specimens retrieved successfully",
                HttpStatus.OK,
                specimenService.getAllSpecimens(page, size, sortBy, sortOrder)
        );
    }

    //Method to generate a general response
    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .build()
                .getPath();

        return ResponseEntity.status(status)
                .body(
                        GeneralResponse.builder()
                                .uri(uri)
                                .message(message)
                                .status(status.value())
                                .time(LocalDateTime.now())
                                .data(data)
                                .build()
                );


    }
}
