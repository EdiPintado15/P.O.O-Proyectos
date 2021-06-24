/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ediss
 */
public class Figuras {
    private long id;
    private String identificador;
    private String nombre;
    private String color;
    private List<Poligonos> listapoligonos;
    private Planos planos;

    public Figuras(long id, String identificador, String nombre, String color) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.color = color;
       
    }

    public Figuras(long id, String identificador, String nombre, String color, Planos planos) {
        this.id = id;
        this.identificador = identificador;
        this.nombre = nombre;
        this.color = color;
        this.listapoligonos=new ArrayList<>();
        this.planos = planos;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Poligonos> getListapoligonos() {
        return listapoligonos;
    }

    public void setListapoligonos(List<Poligonos> listapoligonos) {
        this.listapoligonos = listapoligonos;
    }

    public Planos getPlanos() {
        return planos;
    }

    public void setPlanos(Planos planos) {
        this.planos = planos;
    }

    @Override
    public String toString() {
        return "Figuras{" + "id=" + id + ", identificador=" + identificador + ", nombre=" + nombre + ", color=" + color + ", planos=" + planos + '}';
    }

    
    
    
}
