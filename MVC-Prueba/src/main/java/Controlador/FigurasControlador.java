/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Figuras;
import Modelo.Planos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ediss
 */
public class FigurasControlador {
    private List<Figuras> listaFiguras;
    private Figuras seleccionado;
    public FigurasControlador(){
        listaFiguras= new ArrayList<>();
        seleccionado=null;
    }
    public long generarID(){
        if(listaFiguras.size()>0){ //valido que existe datos en la lista 
            return listaFiguras.get(listaFiguras.size()-1).getId()+1; //obtengo el ultimo elemento de la lista y le sumo uno
        }else{
            return 1; //de no haber datos por defecto empieza en uno
        }
    }
    public boolean Crear(String identificador, String nombre, String color){
        Figuras figura=new Figuras(this.generarID(), identificador, nombre, color);
        return listaFiguras.add(figura);
    }
    public boolean Crear(String identificador, String nombre, String color, Planos planos){
        Figuras figuras=new Figuras(this.generarID(), identificador, nombre, color, planos);
        planos.getFiguras().add(figuras);
        return listaFiguras.add(figuras);
    }
    public Figuras Buscar(String identificador){
        for (Figuras figura : listaFiguras) {
            if (figura.getIdentificador().equals(identificador)) {
                return figura;
            }
        }
        return null;
    }
    public boolean Actualizar(String identificador, String nombre, String color){
        Figuras figura=this.Buscar(identificador);
        if (figura!=null) {
            int posicion=listaFiguras.indexOf(figura);
            figura.setIdentificador(identificador);
            figura.setNombre(nombre);
            figura.setColor(color);
            listaFiguras.set(posicion, figura);
            return true;
        }
        return false;
    }
    public boolean Eliminar(String identificador){
        Figuras figura=this.Buscar(identificador);
        if (figura!=null) {
            figura.getPlanos().getFiguras().remove(figura);
            listaFiguras.remove(figura);
        }
        return false;
    }
    public void Imprimir(){
        listaFiguras.forEach(figura -> {
            System.out.println(figura);
        });
    }

    public List<Figuras> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(List<Figuras> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    public Figuras getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Figuras seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
