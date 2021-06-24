/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Figura;
import modelo.Linea;
import modelo.Poligono;

/**
 *
 * @author ediss
 */
public class ControladorPoligono {
    private Poligono seleccionado;
    private List<Poligono> listaPoligonos;
    
    public ControladorPoligono(){
        listaPoligonos = new ArrayList<>();
    }
    public long generarId(){
        return (listaPoligonos.size() >0)? listaPoligonos.get(listaPoligonos.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, String codigo, List<Linea> listaLineas, double perimetro, int numLineas){
        return listaPoligonos.add(new Poligono(generarId(), codigo, listaLineas, perimetro, numLineas));
    }
    public Poligono buscar(String codigo){
        for (Poligono poligono : listaPoligonos) {
            if(poligono.getCodigo().equals(codigo)){
                seleccionado = poligono;
                return poligono;
            }
        }
        return null;
    }
    
    public boolean eliminar(String codigo){
        Poligono poligono = buscar(codigo);
        return listaPoligonos.remove(poligono);
    } 

    public Poligono getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Poligono seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Poligono> getListaPoligonos() {
        return listaPoligonos;
    }

    public void setListaPoligonos(List<Poligono> listaPoligonos) {
        this.listaPoligonos = listaPoligonos;
    }
    
}
