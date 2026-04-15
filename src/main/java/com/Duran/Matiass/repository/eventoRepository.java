package com.Duran.Matiass.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Duran.Matiass.model.CapacidadDTO;
import com.Duran.Matiass.model.Evento;

@Repository
public class eventoRepository {
    List<Evento> eventoss=new ArrayList<>();

    public Evento agregar(Evento eventos) {
        eventoss.add(eventos);
        return eventos;
    }

    public List<Evento> readAll(){
        return eventoss;
    }

    public boolean eliminar(int id) {
        return eventoss.removeIf(b-> b.getId()==id);
    }

    public Evento obtenerPorId(int id){
        for(Evento e : eventoss){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }

    public Evento modificar(int id, Evento evento){
        Evento buscado = obtenerPorId(id);
        if(buscado!= null){
            buscado.setNombre(evento.getNombre());
            buscado.setTipoEvento(evento.getTipoEvento());
            buscado.setUbicacion(evento.getUbicacion());
            buscado.setCapacidad(evento.getCapacidad());
            return buscado;
        }
        return null;
    }

    public List<CapacidadDTO> modificarCapacidad(){
        List<CapacidadDTO> capacidades = new ArrayList<>();
        for(Evento e : eventoss){
            CapacidadDTO cdto = new CapacidadDTO(e.getNombre(),e.getTipoEvento(),e.getCapacidad()-200);
            capacidades.add(cdto);
        }
        return capacidades;
    }

    }


    
