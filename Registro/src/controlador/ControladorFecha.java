/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Fecha;

/**
 *
 * @author diego
 */
public class ControladorFecha {
    private List<Fecha> listaFecha;
    private Fecha seleccionado;

    public ControladorFecha() {
        listaFecha = new ArrayList();
    }
    
    public long generarId(){
        return (listaFecha.size() >0)? listaFecha.get(listaFecha.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(int dia, int mes, int anio){
        return listaFecha.add(new Fecha(generarId(), dia, mes, anio));
    }
    public Fecha buscar(int dia, int mes){
        for (Fecha fecha : listaFecha) {
            if(fecha.getDia() == dia && fecha.getMes() == mes){
                seleccionado = fecha;
                return fecha;
            }
        }
        return null;
    }
    public boolean actualizar(int dia, int mes, int anio){
        Fecha fecha = buscar(dia, mes);
        if(fecha != null){
            int posicion = listaFecha.indexOf(fecha);
            fecha.setDia(dia);
            fecha.setAnio(anio);
            fecha.setMes(mes);
            listaFecha.set(posicion, fecha);
            return true;
        }
        return false;
    }
    public boolean eliminar(int dia, int mes){
        Fecha fecha = buscar(dia, mes);
        return listaFecha.remove(fecha);
    }

    public List<Fecha> getListaFecha() {
        return listaFecha;
    }

    public void setListaFecha(List<Fecha> listaFecha) {
        this.listaFecha = listaFecha;
    }

    public Fecha getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Fecha seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
