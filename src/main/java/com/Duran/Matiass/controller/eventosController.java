package com.Duran.Matiass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Duran.Matiass.model.Eventos;
import com.Duran.Matiass.service.eventosService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("api/v1/evento")
public class eventosController {
    @Autowired
    private eventosService eventosservice;

    @GetMapping
    public List<Eventos> getEventos(){
        return eventosservice.readAll();
    }


    @PostMapping
    public ResponseEntity<?>postEvento(@Valid @RequestBody Eventos eventos) {
        Eventos event= eventosservice.create(eventos);
        if(event!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Evento creado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }
    
    @DeleteMapping("eliminar/{nombre}")
    public String deleteProducto(@PathVariable String nombre){
        return eventosService.delete(nombre);
    }


}
