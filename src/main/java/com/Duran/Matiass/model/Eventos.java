package com.Duran.Matiass.model;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eventos {
    
    private static final AtomicInteger contador = new AtomicInteger(1);
    private int id;


    @NotBlank(message = "Debe agregar un nombre para el evento")
    @Size(min = 1, max = 200, message = "El nombre del evento debe ser de minimo un caracter y maximo 200")
    private String nombre;
    @NotBlank(message = "Debe agregar un nombre para el evento")
    @Size(min = 1, max = 200, message = "El nombre del evento debe ser de minimo un caracter y maximo 200")
    private String tipoEvento;
    @NotBlank(message = "Debe agregar un nombre para el evento")
    @Size(min = 1, max = 200, message = "El nombre del evento debe ser de minimo un caracter y maximo 200")
    private String fechaRealizacion;
    @NotBlank(message = "Debe agregar un nombre para el evento")
    @Size(min = 1, max = 200, message = "El nombre del evento debe ser de minimo un caracter y maximo 200")
    private String ubicacion;
    @Min(value = 1, message = "La capacidad no puede ser negativa")
    @Max(value = 1000, message = "La capacidad maxima es de 1000")
    private int capacidad;

    public Eventos(String nombre, String tipoEvento, String fechaRealizacion, String ubicacion, int capacidad){
        this.id = contador.getAndIncrement();
        this.nombre = nombre;
        this.tipoEvento = tipoEvento;
        this.fechaRealizacion = fechaRealizacion;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }
}
