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
public class Figura {
    private long id;
    private String nombre;
    private String color;
    private double area;
    private double perimetro;
    private Plano plano;

    public Figura(long id, String nombre, String color) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
    }

    public Figura(long id, String nombre, String color, Plano plano) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.plano = plano;
    }

    public Figura(long id, String nombre, String color, double area, double perimetro) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.area = area;
        this.perimetro = perimetro;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Figura{" + "id=" + id + ", nombre=" + nombre + ", color=" + color + ", area=" + area + ", perimetro=" + perimetro + ", plano=" + plano + '}';
    }
    
    
}
