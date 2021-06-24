/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Jefe;
import modelo.Plano;
import modelo.Proyecto;

/**
 *
 * @author ediss
 */
public class ControladorJefe {
    private Jefe seleccionado;
    private List<Jefe> listaJefes;
    
    public ControladorJefe(){
        listaJefes = new ArrayList<>();
    }
    public long generarId(){
        return (listaJefes.size() >0)? listaJefes.get(listaJefes.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, String nombre, String direccion, String telefono){
        return listaJefes.add(new Jefe(generarId(), nombre, direccion, telefono));
    }
    public Jefe buscar(String nombre){
        for (Jefe jefe : listaJefes) {
            if(jefe.getNombre().equals(nombre)){
                seleccionado = jefe;
                return jefe;
            }
        }
        return null;
    }
    public boolean actualizar(String nombre, String direccion, String telefono){
        Jefe jefe = buscar(nombre);
        if(jefe != null){
            int posicion = listaJefes.indexOf(jefe);
            jefe.setDireccion(direccion);
            jefe.setTelefono(telefono);
            listaJefes.set(posicion, jefe);
            return true;
        }
        return false;
    }
    public boolean eliminar(String nombre){
        Jefe jefe = buscar(nombre);
        return listaJefes.remove(jefe);
    }    

    public Jefe getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Jefe seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Jefe> getListaJefes() {
        return listaJefes;
    }

    public void setListaJefes(List<Jefe> listaJefes) {
        this.listaJefes = listaJefes;
    }
    
    
}
