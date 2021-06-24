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
public class Poligonos {
    private long id;
    private int numeroLineas;
    private double perimetro;
    private double area;
    private List<Lineas> listaLineas;
    private Figuras figuras;

    public Poligonos(long id, int numeroLineas, double perimetro, double area) {
        this.id = id;
        this.numeroLineas = numeroLineas;
        this.perimetro = perimetro;
        this.area = area;
    }

    public Poligonos(long id, int numeroLineas, double perimetro, double area,Figuras figuras) {
        this.id = id;
        this.numeroLineas = numeroLineas;
        this.perimetro = perimetro;
        this.figuras=figuras;
        this.area = area;
        this.listaLineas = new ArrayList<>();
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }

    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Lineas> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Lineas> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public Figuras getFiguras() {
        return figuras;
    }

    public void setFiguras(Figuras figuras) {
        this.figuras = figuras;
    }

    @Override
    public String toString() {
        return "Poligonos{" + "id=" + id + ", numeroLineas=" + numeroLineas + ", perimetro=" + perimetro + ", area=" + area + ", figuras=" + figuras + '}';
    }
    
    

    
    
}
