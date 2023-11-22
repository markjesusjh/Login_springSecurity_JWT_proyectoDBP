package com.proyecto01.dev.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
//import jakarta.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
@Entity
@Table(name = "producto")
public class Producto {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    //llave primaria
    private Long id;
    @Column(name = "img", length = 600)
    private String img;
    private Long stock;
    private Float precio;
    private String nombre;
    private Boolean estado; //booleano para convertir el "v" en disponible y el "f"  en agotado
    private String fabricante;


    //Constructores
    public Producto(){}
    public Producto(Long id2, String img2, Long stock2, Float precio2, String nombre2, Boolean estado2, String fabricante2){
        this.id =  id2;
        this.img = img2;
        this.stock = stock2;
        this.precio = precio2;
        this.nombre = nombre2;
        this.estado = estado2;
        this.fabricante = fabricante2;
    }


    //Getters
    public Long getId(){ return id; }
    public String getImg(){ return img; }
    public Long getStock(){ return stock; }
    public Float getPrecio(){ return precio; }
    public String getNombre(){ return nombre; }
    public Boolean getEstado(){ return estado; }

    public String getFabricante() { return fabricante; }

    //Setters
    public void setId(Long id){ this.id = id; }
    public void setImg(String img){ this.img = img; }
    public void setStock(Long stock){ this.stock = stock; }
    public void setPrecio(Float precio){ this.precio = precio; }
    public void setNombre(String nombre2){ this.nombre = nombre2; }
    public void setEstado(Boolean estado){ this.estado = estado; }
    public void setFabricante(String fabricante2) { this.fabricante = fabricante2; }
}
