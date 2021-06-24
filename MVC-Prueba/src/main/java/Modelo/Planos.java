/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ediss
 */
public class Planos {
    private long id;
    private int identificacion;
    private Date fechaEntrega;
    private int num_arquitectos;
    private List<Figuras> figuras;
    private Proyecto proyecto;

    public Planos(long id, int identificacion, Date fechaEntrega, int num_arquitectos) {
        this.id = id;
        this.identificacion = identificacion;
        this.fechaEntrega = fechaEntrega;
        this.num_arquitectos = num_arquitectos;
        
    }
    

    public Planos(long id, int identificacion, Date fechaEntrega, int num_arquitectos,Proyecto proyecto) {
        this.id = id;
        this.identificacion = identificacion;
        this.fechaEntrega = fechaEntrega;
        this.num_arquitectos = num_arquitectos;
        this.proyecto=proyecto;
        this.figuras = new ArrayList<>();
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getNum_arquitectos() {
        return num_arquitectos;
    }

    public void setNum_arquitectos(int num_arquitectos) {
        this.num_arquitectos = num_arquitectos;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    

    public List<Figuras> getFiguras() {
        return figuras;
    }

    public void setFiguras(List<Figuras> figuras) {
        this.figuras = figuras;
    }

    @Override
    public String toString() {
        return "Planos{" + "id=" + id + ", identificacion=" + identificacion + ", fechaEntrega=" + fechaEntrega + ", num_arquitectos=" + num_arquitectos + ", proyecto=" + proyecto + '}';
    }

    
    

    
    
}
