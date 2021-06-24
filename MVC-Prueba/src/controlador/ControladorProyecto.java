/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Jefe;
import modelo.Plano;
import modelo.Proyecto;

/**
 *
 * @author ediss
 */
public class ControladorProyecto {
    private Proyecto seleccionado;
    private List<Proyecto> listaProyectos;
    
    public ControladorProyecto(){
        listaProyectos = new ArrayList<>();
    }
    public long generarId(){
        return (listaProyectos.size() >0)? listaProyectos.get(listaProyectos.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, String nombre, List<Plano> listaPlanos, Jefe jefe){
        return listaProyectos.add(new Proyecto(generarId(), nombre, listaPlanos, jefe));
    }
    public Proyecto buscar(String nombre){
        for (Proyecto proyecto : listaProyectos) {
            if(proyecto.getNombre().equals(nombre)){
                seleccionado = proyecto;
                return proyecto;
            }
        }
        return null;
    }
    public boolean actualizar(String nombre, String nombrenew){
        Proyecto proyecto = buscar(nombre);
        if(proyecto != null){
            int posicion = listaProyectos.indexOf(proyecto);
            proyecto.setNombre(nombrenew);
            listaProyectos.set(posicion, proyecto);
            return true;
        }
        return false;
    }
    public boolean eliminar(String nombre){
        Proyecto proyecto = buscar(nombre);
        return listaProyectos.remove(proyecto);
    }   

    public Proyecto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Proyecto seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(List<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }
    
}
