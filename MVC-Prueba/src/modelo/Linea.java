/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ediss
 */
public class Linea {
    private long id;
    private String codigo;
    private double coordX1;
    private double coordY1;
    private double coordX2;
    private double coordY2;
    private double longitud;

    public Linea(long id, String codigo, double coordX1, double coordY1, double coordX2, double coordY2, double longitud) {
        this.id = id;
        this.codigo = codigo;
        this.coordX1 = coordX1;
        this.coordX2 = coordX2;
        this.coordY1 = coordY1;
        this.coordY2 = coordY2;
        this.longitud = longitud;
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
    
    public double getCoordX1() {
        return coordX1;
    }

    public void setCoordX1(double coordX1) {
        this.coordX1 = coordX1;
    }

    public double getCoordY1() {
        return coordY1;
    }

    public void setCoordY1(double coordY1) {
        this.coordY1 = coordY1;
    }

    public double getCoordX2() {
        return coordX2;
    }

    public void setCoordX2(double coordX2) {
        this.coordX2 = coordX2;
    }

    public double getCoordY2() {
        return coordY2;
    }

    public void setCoordY2(double coordY2) {
        this.coordY2 = coordY2;
    }

    
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Linea{" + "id=" + id + ", codigo=" + codigo + ", coordX1=" + coordX1 + ", coordY1=" + coordY1 + ", coordX2=" + coordX2 + ", coordY2=" + coordY2 + ", longitud=" + longitud + '}';
    }

    
    
    
    
}
