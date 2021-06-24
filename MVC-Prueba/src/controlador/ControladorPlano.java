/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Figura;
import modelo.Jefe;
import modelo.Plano;
import modelo.Poligono;
import modelo.Proyecto;

/**
 *
 * @author ediss
 */
public class ControladorPlano {
    private Plano seleccionado;
    private List<Plano> listaPlanos;
    
    public ControladorPlano(){
        listaPlanos = new ArrayList<>();
    }
    public long generarId(){
        return (listaPlanos.size() >0)? listaPlanos.get(listaPlanos.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, String codigo, Date fechaentrega, List<String> listaArquitectos, List<Figura> listaFiguras, List<Poligono> listaPoligonos){
        return listaPlanos.add(new Plano(generarId(), codigo, fechaentrega, listaArquitectos, listaFiguras, listaPoligonos));
    }
    public Plano buscar(String codigo){
        for (Plano plano : listaPlanos) {
            if(plano.getCodigo().equals(codigo)){
                seleccionado = plano;
                return plano;
            }
        }
        return null;
    }
    public boolean actualizar(String codigo, Date fechaentrega){
        Plano plano = buscar(codigo);
        if(plano != null){
            int posicion = listaPlanos.indexOf(plano);
            plano.setFechaentrega(fechaentrega);
            listaPlanos.set(posicion, plano);
            return true;
        }
        return false;
    }
    public boolean eliminar(String codigo){
        Plano plano = buscar(codigo);
        return listaPlanos.remove(plano);
    }   

    public Plano getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Plano seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Plano> getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(List<Plano> listaPlanos) {
        this.listaPlanos = listaPlanos;
    }
    
    
}
