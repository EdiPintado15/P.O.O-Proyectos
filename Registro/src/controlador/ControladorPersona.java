/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.DNI;
import modelo.Fecha;
import modelo.Persona;

/**
 *
 * @author diego
 */
public class ControladorPersona {
    private List<Persona> listaPersona;
    private Persona seleccionado;
    
    public ControladorPersona(){
        listaPersona = new ArrayList<>();
    }
     public long generarId(){
        return (listaPersona.size() >0)? listaPersona.get(listaPersona.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(String nombreCompleto, Fecha fecha, DNI dni){
        return listaPersona.add(new Persona(generarId(), nombreCompleto, fecha, dni));
    }
    public Persona buscar(String nombreCompleto){
        for (Persona persona : listaPersona) {
            if(persona.getNombreCompleto().equals(nombreCompleto)){
                seleccionado = persona;
                return persona;
            }
        }
        return null;
    }
    public boolean actualizar(String nombreCompleto, Fecha fecha, DNI dni){
        Persona persona = buscar(nombreCompleto);
        if(persona != null){
            int posicion = listaPersona.indexOf(persona);
            persona.setFecha(fecha);
            persona.setDni(dni);
            listaPersona.set(posicion, persona);
            return true;
        }
        return false;
    }
    public boolean eliminar(String nombreCompleto){
        Persona persona = buscar(nombreCompleto);
        return listaPersona.remove(persona);
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public Persona getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Persona seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
