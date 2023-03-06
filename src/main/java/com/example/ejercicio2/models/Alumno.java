package com.example.ejercicio2.models;

import jakarta.persistence.*;
import lombok.Data;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "alumnado")
public class Alumno {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;

    public String nombre;

    public String telefono;

    public String email;

    public Double nDI;

    public Double nAD;
}
