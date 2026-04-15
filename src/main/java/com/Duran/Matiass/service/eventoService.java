package com.Duran.Matiass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Duran.Matiass.model.CapacidadDTO;
import com.Duran.Matiass.model.Evento;
import com.Duran.Matiass.repository.eventoRepository;

@Service
public class eventoService {
    @Autowired
    private eventoRepository eventoRepository;
    
    public Evento create(Evento eventos){
        return eventoRepository.agregar(eventos);
    }

    public List<Evento> readAll(){
        return eventoRepository.readAll();
    }

    public String delete(int id) {
        if(eventoRepository.eliminar(id)){
            return("Evento eliminado");
        }
        return"No se pudo eliminar";
    }

    public Evento update(int id, Evento eventos){
        return eventoRepository.modificar(id, eventos);
    }

    public List<CapacidadDTO> capacidad(){
        return eventoRepository.modificarCapacidad();
    }
    
    public Evento readbyId(int id){
        return eventoRepository.obtenerPorId(id);
    }
}
