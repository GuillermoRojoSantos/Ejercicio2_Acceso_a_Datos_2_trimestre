package com.example.ejercicio2.repositories;

import com.example.ejercicio2.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}