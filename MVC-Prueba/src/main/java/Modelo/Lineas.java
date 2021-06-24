/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ediss
 */
public class Lineas {
    private long id;
    private String identificador;
    private double longitud;
    private double P1X;
    private double P1Y;
    private double P2X;
    private double P2Y;
    private Poligonos poligonos;

    public Lineas(long id, String identificador, double longitud, double P1X, double P1Y, double P2X, double P2Y) {
        this.id = id;
        this.identificador = identificador;
        this.longitud =longitud;
        this.P1X = P1X;
        this.P1Y = P1Y;
        this.P2X = P2X;
        this.P2Y = P2Y;
    }

    public Lineas(long id, String identificador, double longitud, double P1X, double P1Y, double P2X, double P2Y, Poligonos poligonos) {
        this.id = id;
        this.identificador = identificador;
        this.longitud = longitud;
        this.P1X = P1X;
        this.P1Y = P1Y;
        this.P2X = P2X;
        this.P2Y = P2Y;
        this.poligonos = poligonos;
    }
    
    /*
    public double Longitud(){
        
    }*/

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

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getP1X() {
        return P1X;
    }

    public void setP1X(double P1X) {
        this.P1X = P1X;
    }

    public double getP1Y() {
        return P1Y;
    }

    public void setP1Y(double P1Y) {
        this.P1Y = P1Y;
    }

    public double getP2X() {
        return P2X;
    }

    public void setP2X(double P2X) {
        this.P2X = P2X;
    }

    public double getP2Y() {
        return P2Y;
    }

    public void setP2Y(double P2Y) {
        this.P2Y = P2Y;
    }

    public Poligonos getPoligonos() {
        return poligonos;
    }

    public void setPoligonos(Poligonos poligonos) {
        this.poligonos = poligonos;
    }
    

    @Override
    public String toString() {
        return "Lineas{" + "id=" + id + ", identificador=" + identificador + ", longitud=" + longitud + ", Punto inicio=" + "["+P1X +","+ P1Y+"]" + ", Punto fin=" +"["+ P2X +"," + P2Y+"]" +" ,poligono"+poligonos+ '}';
    }
    
}
