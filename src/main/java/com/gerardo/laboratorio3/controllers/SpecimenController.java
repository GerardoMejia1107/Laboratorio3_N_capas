package com.gerardo.laboratorio3.controllers;

import com.gerardo.laboratorio3.dto.request.CreateSpecimenRequest;
import com.gerardo.laboratorio3.dto.response.SpecimenResponse;
import com.gerardo.laboratorio3.services.SpecimenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SpecimenController {
    private final SpecimenService specimenService;

    @PostMapping("/specimen")
    public ResponseEntity<SpecimenResponse> createSpecimen(@Valid @RequestBody CreateSpecimenRequest request) {
        SpecimenResponse response = specimenService.createSpecimen(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/specimens")
    public ResponseEntity<List<SpecimenResponse>> listAllSpecimens() {
        List<SpecimenResponse> response = specimenService.getAllSpecimens();
        return ResponseEntity.ok(response);
    }
}
