package com.Duran.Matiass.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Duran.Matiass.model.Eventos;

@Repository
public class eventosRepository {
    List<Eventos> eventoss=new ArrayList<>();

    public Eventos agregar(Eventos eventos) {
        eventoss.add(eventos);
        return eventos;
    }

    public List<Eventos> readAll(){
        return eventoss;
    }

    public boolean eliminar(String nombre) {
        return eventoss.removeIf(b-> b.getNombre().equals(nombre));
    }


    }


    
