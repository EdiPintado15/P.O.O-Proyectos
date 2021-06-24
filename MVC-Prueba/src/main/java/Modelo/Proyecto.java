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
public class Proyecto {
    private long id;
    private String codigo;
    private String nombre;
    private JefeProyecto jefeProyecto;
    private List<Planos> listaPlanos;

    public Proyecto(long id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Proyecto(long id, String codigo, String nombre, JefeProyecto jefeProyecto) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.jefeProyecto = jefeProyecto;
        this.listaPlanos=new ArrayList<>();
    }

   
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JefeProyecto getJefeProyecto() {
        return jefeProyecto;
    }

    public void setJefeProyecto(JefeProyecto jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public List<Planos> getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(List<Planos> listaPlanos) {
        this.listaPlanos = listaPlanos;
    }

    
    

    @Override
    public String toString() {
        return "Proyecto{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "\n, jefeProyecto=" + jefeProyecto + '}';
    }
    
}
