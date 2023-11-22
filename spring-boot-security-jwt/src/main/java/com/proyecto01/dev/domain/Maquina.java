package com.proyecto01.dev.domain;

//import jakarta.persistence.*;

import javax.persistence.*;
import java.util.List;

@Entity

//Nombre de la tabla de la clase.
@Table(name = "maquina")
public class Maquina {

    //Generando la llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a GenerationType.IDENTITY para autoincrementar
    @Column(name = "id", nullable = false)

    private Long id;

    //Los demás atributos
    @Column(name = "img", length = 600) //Se usa esto para que la columna de String tenga un tamaño maximo de
    //600 caracteres.
    private String img;
    private String ubicacion;
    private String tipo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "maquina_id")
    private List<Producto> inventario;

    //Constructores
    public Maquina(){}


    public Maquina(Long id2, String img2, String ubicacion2, List<Producto> inventario2, String tipo2){
        this.id = id2;
        this.img = img2;
        this.ubicacion = ubicacion2;
        this.inventario = inventario2;
        this.tipo = tipo2;
    }

    //getters
    public Long getId(){ return id; }
    public String getImg(){ return img; }
    public String getUbicacion(){ return ubicacion; }
    public List<Producto> getInventario() { return inventario; }

    public String getTipo() { return tipo; }

    //setters
    public void setId(Long id2){ this.id = id; }
    public void setImg(String img){ this.img = img; }
    public void setUbicacion(String ubicacion){ this.ubicacion = ubicacion; }
    public void setInventario(List<Producto> inventario2) { this.inventario = inventario2; }

    public void setTipo(String tipo) { this.tipo = tipo; }
}
