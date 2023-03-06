package com.example.ejercicio2.controllers;

import com.example.ejercicio2.models.Alumno;
import com.example.ejercicio2.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumnado")
public class AlumnoController {

    @Autowired
    AlumnoRepository repo;

    @GetMapping
    private List<Alumno> findAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Alumno> getById(@PathVariable Long id){
        if(repo.existsById(id)){
            return new ResponseEntity<Alumno>(repo.findById(id).get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/suspensos/{module}")
    private List<Alumno> getSuspendedByModule(@PathVariable String module){
        List<Alumno> alumnos =repo.findAll();
        List<Alumno> result = new ArrayList<>();
        if(module.equals("di") || module.equals("DI")){
            alumnos.forEach(alumno -> {
                if(alumno.nDI<5.00){
                    result.add(alumno);
                }
            });
        } else if (module.equals("ad") || module.equals("AD")) {
            alumnos.forEach(alumno -> {
                if(alumno.nAD<5.00){
                    result.add(alumno);
                }
            });
        }else {
            return (List<Alumno>) new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return result;
    }
}