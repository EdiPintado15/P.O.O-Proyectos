/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Figuras;
import Modelo.Poligonos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ediss
 */
public class PoligonosControlador {
    private List<Poligonos> listaPoligonos;
    private Poligonos seleccionado;
    public PoligonosControlador(){
        listaPoligonos=new ArrayList<>();
        seleccionado=null;
    }
    public long generarId(){
        if(listaPoligonos.size()>0){ //valido que existe datos en la lista 
            return listaPoligonos.get(listaPoligonos.size()-1).getId()+1; //obtengo el ultimo elemento de la lista y le sumo uno
        }else{
            return 1; //de no haber datos por defecto empieza en uno
        }
    }
    public boolean Crear( int numeroLineas, double perimetro, double area){
        Poligonos poligonos=new Poligonos(this.generarId(), numeroLineas, perimetro, area);
        return listaPoligonos.add(poligonos);
    }
    public boolean Crear( int numeroLineas, double perimetro, double area,Figuras figura){
        Poligonos poligono=new Poligonos(this.generarId(), numeroLineas, perimetro, area,figura);
        figura.getListapoligonos().add(poligono);
        return listaPoligonos.add(poligono);
    }
    public Poligonos Buscar(int numeroLineas){
        for (Poligonos poligono : listaPoligonos) {
            if(poligono.getNumeroLineas()==numeroLineas){
                return poligono;
            }
        }
        return null;
    }
    public boolean Actualizar(int numeroLineas, int numeroLineasNuevo ){
        Poligonos poligono=Buscar(numeroLineas);
        if (poligono!=null) {
            int posicion=listaPoligonos.indexOf(poligono);
            poligono.setNumeroLineas(numeroLineasNuevo);
            listaPoligonos.set(posicion, poligono);
            return true;
        }
        return false;
    }
    public boolean Eliminar(int numeroLineas){
        Poligonos poligono=Buscar(numeroLineas);
        if(poligono!=null){
            poligono.getFiguras().getListapoligonos().remove(poligono);
            listaPoligonos.remove(poligono);
        }
        return false;
    }
    public void Imprimir(){
        listaPoligonos.forEach(poligono -> {
            System.out.println(poligono);
        });
    }

    public List<Poligonos> getListaPoligonos() {
        return listaPoligonos;
    }

    public void setListaPoligonos(List<Poligonos> listaPoligonos) {
        this.listaPoligonos = listaPoligonos;
    }

    public Poligonos getSeleccionado() {
        return seleccionado;
    }

    public void setSelccionado(Poligonos selccionado) {
        this.seleccionado = selccionado;
    }
    
}
