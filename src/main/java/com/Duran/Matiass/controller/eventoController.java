package com.Duran.Matiass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Duran.Matiass.model.CapacidadDTO;
import com.Duran.Matiass.model.Evento;
import com.Duran.Matiass.service.eventoService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("api/v1/evento")
public class eventoController {
    @Autowired
    private eventoService eventoService;

    @GetMapping
    public ResponseEntity<?> getEvento(){
        List<Evento> lista = eventoService.readAll();
        if(lista.isEmpty()){
            return ResponseEntity
            .status(404)
            .body("Recurso no encontrado");
        }
        return ResponseEntity.ok(lista);
    }


    @PostMapping
    public ResponseEntity<?>postEvento(@Valid @RequestBody Evento evento) {
        Evento event= eventoService.create(evento);
        if(event!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Evento creado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }
    
    @PutMapping("actualizar/{id}")
    public Evento putEvento(@PathVariable int id, @RequestBody Evento evento){
        return eventoService.update(id, evento);
    }

    @GetMapping("reporte")
    public List<CapacidadDTO> capacidad(){
        return eventoService.capacidad();
    }

    @DeleteMapping("eliminar/{id}")
    public String deleteEvento(@PathVariable int id){
        return eventoService.delete(id);
    }



}
