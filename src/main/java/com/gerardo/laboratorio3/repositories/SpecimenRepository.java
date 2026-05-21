package com.gerardo.laboratorio3.repositories;

import com.gerardo.laboratorio3.model.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecimenRepository extends JpaRepository<Specimen, UUID> {
}
