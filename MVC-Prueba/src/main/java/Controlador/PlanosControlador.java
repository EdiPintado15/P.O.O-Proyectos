/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Planos;
import Modelo.Proyecto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ediss
 */
public class PlanosControlador {
    private List<Planos> listaPlanos;
    private Planos seleccionado;
    public PlanosControlador(){
        listaPlanos=new ArrayList<>();
        seleccionado=null;
    }
    public long GenerarID(){
        if(listaPlanos.size()>0){ //valido que existe datos en la lista 
            return listaPlanos.get(listaPlanos.size()-1).getId()+1; //obtengo el ultimo elemento de la lista y le sumo uno
        }else{
            return 1; //de no haber datos por defecto empieza en uno
        }
    }
    public boolean Crear( int identificacion, Date fechaEntrega, int num_arquitectos){
        Planos planos=new Planos(this.GenerarID(), identificacion, fechaEntrega, num_arquitectos);
        return listaPlanos.add(planos);
    }
    public boolean Crear( int identificacion, Date fechaEntrega, int num_arquitectos,Proyecto proyecto){
          Planos planos=new Planos(this.GenerarID(), identificacion, fechaEntrega, num_arquitectos, proyecto);
          proyecto.getListaPlanos().add(planos);
          return listaPlanos.add(planos);
    }
    public Planos Buscar(int identificacion){
        for (Planos plano : listaPlanos) {
            if (plano.getIdentificacion()==identificacion) {
                return plano;
            }
        }
        return null;
    }
    public boolean Actualizar(int identificacion, Date fechaEntrega, int num_arquitectos){
        Planos plano=Buscar(identificacion);
        if (plano!=null) {
            int posicion=listaPlanos.indexOf(plano);
            plano.setIdentificacion(identificacion);
            plano.setNum_arquitectos(num_arquitectos);
            plano.setFechaEntrega(fechaEntrega);
            listaPlanos.set(posicion, plano);
            return true;
        }
        return false;
    }
    public boolean Eliminar(int identificacion){
        Planos plano=Buscar(identificacion);
        if (plano!=null) {
            plano.getProyecto().getListaPlanos().remove(plano);
            return listaPlanos.remove(plano);
        }
        return false;
    }
    public void Imprimir(){
        for (Planos plano : listaPlanos) {
            System.out.println(plano);
        }
    }

    public List<Planos> getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(List<Planos> listaPlanos) {
        this.listaPlanos = listaPlanos;
    }

    public Planos getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Planos seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
