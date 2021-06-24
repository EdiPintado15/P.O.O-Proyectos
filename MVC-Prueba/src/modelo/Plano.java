/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ediss
 */
public class Plano {
    private long id;
    private String codigo;
    private Date fechaentrega;
    private List<String> listaArquitectos;
    private List<Figura> listaFiguras;
    private List<Poligono> listaPoligonos;

    public Plano(long id, String codigo, Date fechaentrega, List<String> listaArquitectos) {
        this.id = id;
        this.codigo = codigo;
        this.fechaentrega = fechaentrega;
        this.listaArquitectos = listaArquitectos;
    }

    public Plano(long id, String codigo, Date fechaentrega, List<String> listaArquitectos, List<Figura> listaFiguras, List<Poligono> listaPoligonos) {
        this.id = id;
        this.codigo = codigo;
        this.fechaentrega = fechaentrega;
        this.listaArquitectos = listaArquitectos;
        this.listaFiguras = listaFiguras;
        this.listaPoligonos = listaPoligonos;
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
    
    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public List<String> getListaArquitectos() {
        return listaArquitectos;
    }

    public void setListaArquitectos(List<String> listaArquitectos) {
        this.listaArquitectos = listaArquitectos;
    }

    public List<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    public List<Poligono> getListaPoligonos() {
        return listaPoligonos;
    }

    public void setListaPoligonos(List<Poligono> listaPoligonos) {
        this.listaPoligonos = listaPoligonos;
    }

    @Override
    public String toString() {
        return "Plano{" + "id=" + id + ", fechaentrega=" + fechaentrega + ", listaArquitectos=" + listaArquitectos + ", listaFiguras=" + listaFiguras + ", listaPoligonos=" + listaPoligonos + '}';
    }
    
    
    
}
