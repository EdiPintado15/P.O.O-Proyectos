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
public class Poligono {
    private long id;
    private String codigo;
    private List<Linea> listaLineas;
    private int numLineas;
    private double perimetro;
    private Plano plano;

    public Poligono(long id, String codigo, List<Linea> listaLineas, double perimetro, int numLineas) {
        this.id = id;
        this.codigo = codigo;
        this.listaLineas = listaLineas;
        this.perimetro = perimetro;
        this.numLineas = numLineas;
    }

    public Poligono(long id, String codigo, List<Linea> listaLineas, int numLineas) {
        this.id = id;
        this.codigo = codigo;
        this.listaLineas = listaLineas;
        this.numLineas = numLineas;
    }

    public Poligono(long id, String codigo, List<Linea> listaLineas, int numLineas, Plano plano) {
        this.id = id;
        this.codigo = codigo;
        this.listaLineas = listaLineas;
        this.numLineas = numLineas;
        this.plano = plano;
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
    
    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public int getNumLineas() {
        return numLineas;
    }

    public void setNumLineas(int numLineas) {
        this.numLineas = numLineas;
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
        return "Poligono{" + "id=" + id + ", codigo=" + codigo + ", listaLineas=" + listaLineas + ", numLineas=" + numLineas + ", perimetro=" + perimetro + ", plano=" + plano + '}';
    }

    
    
    
}
