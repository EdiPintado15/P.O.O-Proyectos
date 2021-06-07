/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.DNI;

/**
 *
 * @author diego
 */
public class ControladorDNI {
    private List<DNI> listaDNI;
    private DNI seleccionado;
    
    public ControladorDNI(){
        listaDNI = new ArrayList<>();
    }
     public long generarId(){
        return (listaDNI.size() >0)? listaDNI.get(listaDNI.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(String numero, int codigoVerificacion){
        return listaDNI.add(new DNI(generarId(), numero, codigoVerificacion));
    }
    public DNI buscar(String numero){
        for (DNI dni : listaDNI) {
            if(dni.getNumero().equals(numero)){
                seleccionado = dni;
                return dni;
            }
        }
        return null;
    }
    public boolean actualizar(String numero, int codigoVerificacion){
        DNI dni = buscar(numero);
        if(dni != null){
            int posicion = listaDNI.indexOf(dni);
            dni.setCodigoVerificacion(codigoVerificacion);
            listaDNI.set(posicion, dni);
            return true;
        }
        return false;
    }
    public boolean eliminar(String numero){
        DNI dni = buscar(numero);
        return listaDNI.remove(dni);
    }

    public List<DNI> getListaDNI() {
        return listaDNI;
    }

    public void setListaDNI(List<DNI> listaDNI) {
        this.listaDNI = listaDNI;
    }

    public DNI getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(DNI seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
