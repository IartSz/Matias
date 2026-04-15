package com.Duran.Matiass.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CapacidadDTO {
    private String nombre;
    private String tipoEvento;
    private int capacidad;
}
