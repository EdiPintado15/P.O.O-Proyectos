/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author ediss
 */

import java.util.ArrayList;
import java.util.List;
import modelo.Asignatura;
import modelo.Grupo;

public class ControladorAsignatura {
    private List<Asignatura> listaAsignatura;
    private Asignatura seleccionado;
    
    public ControladorAsignatura() {
        listaAsignatura = new ArrayList<>();
        seleccionado = null;
    }

    public long generarId(){
        return (listaAsignatura.size()>0)? listaAsignatura.get(listaAsignatura.size()-1).getId()+1 : 1;
    }
    
    public boolean crear(String nombre){
        return listaAsignatura.add(new Asignatura(generarId(),nombre)); 
    }
    
    public Asignatura buscar(String nombre){
        for (Asignatura asignatura : listaAsignatura) {
            if(asignatura.getNombre().equals(nombre))
                return asignatura;
        }
        return null;
    }
    
    public boolean actualizar(String nombreAnterior, String nombre){
        Asignatura asignatura =buscar(nombreAnterior);
        if(asignatura != null){
            int posicion = listaAsignatura.indexOf(asignatura);
            asignatura.setNombre(nombre);
            listaAsignatura.set(posicion, asignatura);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String nombre){
        return listaAsignatura.remove(buscar(nombre));
    }
    
    //public boolean agregarGrupo(Grupo grupo){
        //return seleccionado.getListadoGrupo().add(grupo);
    //}

    public List<Asignatura> getListaAsignatura() {
        return listaAsignatura;
    }

    public void setListaAsignatura(List<Asignatura> listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }

    public Asignatura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Asignatura seleccionado) {
        this.seleccionado = seleccionado;
    }       
}
    

