/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.JefeProyecto;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ediss
 */
public class ProyectoControlador {
    private List<Proyecto> listaProyectos;
    private Proyecto seleccionado;
    public ProyectoControlador(){
        listaProyectos=new ArrayList<>();
        seleccionado=null;
    }
    public long GenerarId(){
        if(listaProyectos.size()>0){ //valido que existe datos en la lista 
            return listaProyectos.get(listaProyectos.size()-1).getId()+1; //obtengo el ultimo elemento de la lista y le sumo uno
        }else{
            return 1; //de no haber datos por defecto empieza en uno
        }
    }
    public boolean Crear(String codigo, String nombre){
        Proyecto proyecto=new Proyecto(this.GenerarId(), codigo, nombre);
        return listaProyectos.add(proyecto);
    }
    public boolean Crear(String codigo, String nombre, JefeProyecto jefeProyecto){
        Proyecto proyecto=new Proyecto(this.GenerarId(), codigo, nombre, jefeProyecto);
        return listaProyectos.add(proyecto);
    }
    public Proyecto Buscar(String Nombre){
        for (Proyecto proyecto : listaProyectos) {
            if (proyecto.getNombre().equals(Nombre)) {
                return proyecto;
            }
        }
        return null;
    }
    public boolean Actualizar(String codigo, String nombre, String nombreNuevo){
        Proyecto proyecto=Buscar(nombre);
        if(proyecto!=null){
            int posicion=listaProyectos.indexOf(proyecto);
            proyecto.setCodigo(codigo);
            proyecto.setNombre(nombreNuevo);
            listaProyectos.set(posicion, proyecto);
            return true;
        }
        return false;
    }
    public boolean Eliminar(String nombre){
        Proyecto proyecto=Buscar(nombre);
        if(proyecto!=null){
            return listaProyectos.remove(proyecto);
        }
        return false;
    }

    public List<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(List<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public Proyecto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Proyecto seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
