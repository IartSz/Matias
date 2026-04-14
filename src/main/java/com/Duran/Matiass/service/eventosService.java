package com.Duran.Matiass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Duran.Matiass.model.Eventos;
import com.Duran.Matiass.repository.eventosRepository;

@Service
public class eventosService {
    @Autowired
    private eventosRepository eventosRepository;
    
    public Eventos create(Eventos eventos){
        return eventosRepository.agregar(eventos);
    }

    public List<Eventos> readAll(){
        return eventosRepository.readAll();
    }

    public String delete(String nombre) {
        if(eventosRepository.eliminar(nombre)){
            return("Evento eliminado");
        }
        return"No se pudo eliminar";
    }

    
}
