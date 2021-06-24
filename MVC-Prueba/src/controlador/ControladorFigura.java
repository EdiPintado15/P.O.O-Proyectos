/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Figura;
import modelo.Plano;

/**
 *
 * @author ediss
 */
public class ControladorFigura {
    private Figura seleccionado;
    private List<Figura> listaFiguras;
    
    public ControladorFigura(){
        listaFiguras = new ArrayList<>();
    }
    public long generarId(){
        return (listaFiguras.size() >0)? listaFiguras.get(listaFiguras.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, String nombre, String color, double area, double perimetro){
        return listaFiguras.add(new Figura(generarId(), nombre, color, area, perimetro));
    }
    public Figura buscar(String nombre){
        for (Figura figura : listaFiguras) {
            if(figura.getNombre().equals(nombre)){
                seleccionado = figura;
                return figura;
            }
        }
        return null;
    }
    public boolean actualizar(String nombre, String color){
        Figura figura = buscar(nombre);
        if(figura != null){
            int posicion = listaFiguras.indexOf(figura);
            figura.setColor(color);
            listaFiguras.set(posicion, figura);
            return true;
        }
        return false;
    }
    public boolean eliminar(String nombre){
        Figura figura = buscar(nombre);
        return listaFiguras.remove(figura);
    }

    public Figura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Figura seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    
}
