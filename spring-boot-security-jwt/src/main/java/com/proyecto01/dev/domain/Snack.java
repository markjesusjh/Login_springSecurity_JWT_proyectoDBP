package com.proyecto01.dev.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import jakarta.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
@Table(name = "snack")
public class Snack extends Producto{

    //atributos
    private String Categoria;

    //constructores
    public Snack(){}
    public Snack(Long id2, String img2, Long stock2, Float precio2, String nombre2, Boolean estado2, String fabricante2, String categoria2) {
        super(id2, img2, stock2, precio2, nombre2, estado2, fabricante2);
        Categoria = categoria2;
    }

    //getter
    public String getCategoria() { return Categoria; }

    //setter
    public void setCategoria(String categoria) { Categoria = categoria; }
}
