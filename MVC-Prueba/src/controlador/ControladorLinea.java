/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import modelo.Linea;

/**
 *
 * @author ediss
 */
public class ControladorLinea {
    private Linea seleccionado;
    private List<Linea> listaLineas;
    
    public ControladorLinea(){
        listaLineas = new ArrayList<>();
    }
    public long generarId(){
        return (listaLineas.size() >0)? listaLineas.get(listaLineas.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, String codigo, double coordX1, double coordY1, double coordX2, double coordY2, double longitud){
        return listaLineas.add(new Linea(generarId(), codigo, coordX1, coordY1, coordX2, coordY2, longitud));
    }
    public Linea buscar(String codigo){
        for (Linea linea : listaLineas) {
            if(linea.getCodigo().equals(codigo)){
                seleccionado = linea;
                return linea;
            }
        }
        return null;
    }
    
    public boolean actualizar(String codigo, double coordX1, double coordY1, double coordX2, double coordY2){
        Linea linea = buscar(codigo);
        double lx=0;
        double ly=0;
        double longitud=0;
        if(linea != null){
            int posicion = listaLineas.indexOf(linea);
            linea.setCoordX1(coordX1);
            linea.setCoordY1(coordY1);
            linea.setCoordX1(coordX2);
            linea.setCoordY1(coordY2);
            if(coordX1<coordX2){
                lx = coordX2-coordX1;
            }else{
                lx = coordX1-coordX2;
            }
            if(coordY1<coordY2){
                ly = coordY2-coordY1;
            }else{
                ly = coordY1-coordY2;
            }
            longitud = sqrt((lx*lx)+(ly*ly));
            linea.setLongitud(longitud);
            listaLineas.set(posicion, linea);
            return true;
        }
        return false;
    }
    public boolean eliminar(String codigo){
        Linea linea = buscar(codigo);
        return listaLineas.remove(linea);
    }

    public Linea getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Linea seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Linea> getListaLineas() {
        return listaLineas;
    }

    public void setListaLineas(List<Linea> listaLineas) {
        this.listaLineas = listaLineas;
    }

    
}
