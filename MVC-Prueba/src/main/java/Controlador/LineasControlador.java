/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Lineas;
import Modelo.Poligonos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ediss
 */
public class LineasControlador {
    private List<Lineas> listaLineas;
    private Lineas seleccionado;
    public LineasControlador(){
        listaLineas=new ArrayList<>();
        seleccionado=null;
    }
    public long  generarid(){
        if(listaLineas.size()>0)     
            return listaLineas.get(listaLineas.size()-1).getId()+1;
        else
            return 1;
    }
    public boolean Crear( String identificador, double longitud, double P1X, double P1Y, double P2X, double P2Y,Poligonos poligonos){
        Lineas lineas=new Lineas(this.generarid(),identificador,longitud,P1X,P1Y,P2X,P2Y,poligonos);
        poligonos.getListaLineas().add(lineas);
        return listaLineas.add(lineas);
    }
    public boolean Crear( String identificador, double longitud, double P1X, double P1Y, double P2X, double P2Y){
        Lineas lineas=new Lineas(this.generarid(),identificador,longitud,P1X,P1Y,P2X,P2Y);
        return listaLineas.add(lineas);
    }
    public Lineas Buscar(String identificador){
        for (Lineas Linea : listaLineas) {
            if(Linea.getIdentificador().equals(identificador))
                return Linea;
        }
        return null;
    }
    public boolean Actualizar(String identificador, double longitud, double P1X, double P1Y, double P2X, double P2Y){
        Lineas linea= Buscar(identificador);
        if(linea!=null){
            int posicion=listaLineas.indexOf(linea);
            linea.setP1X(P1X);
            linea.setP2X(P2X);
            linea.setP1Y(P1Y);
            linea.setP2Y(P2Y);
            linea.setLongitud(longitud);
            listaLineas.set(posicion, linea);
            return true;
        }
        return false;
    }
    public boolean Eliminar(String identificador){
        Lineas linea=Buscar(identificador);
        if(linea!=null){
            linea.getPoligonos().getListaLineas().remove(linea);
            return listaLineas.remove(linea);
        }
        return false;
    }

    public List<Lineas> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Lineas> listaLineas) {
        this.listaLineas = listaLineas;
    }

    public Lineas getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Lineas seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    
}
