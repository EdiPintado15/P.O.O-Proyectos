/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author ediss
 */
public class Proyecto {
    private long id;
    private String nombre;
    private List<Plano> listaPlanos;
    private Jefe jefe;

    public Proyecto(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Proyecto(long id, String nombre, Jefe jefe) {
        this.id = id;
        this.nombre = nombre;
        this.jefe = jefe;
    }

    public Proyecto(long id, String nombre, List<Plano> listaPlanos, Jefe jefe) {
        this.id = id;
        this.nombre = nombre;
        this.listaPlanos = listaPlanos;
        this.jefe = jefe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Plano> getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(List<Plano> listaPlanos) {
        this.listaPlanos = listaPlanos;
    }

    public Jefe getJefe() {
        return jefe;
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "id=" + id + ", nombre=" + nombre + ", listaPlanos=" + listaPlanos + ", jefe=" + jefe + '}';
    }
    
    
}
