/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author ediss
 */
public class ControladorProducto {
    private Producto seleccionado;
    private List<Producto> listaProductosDisp;
    
    public ControladorProducto(){
        listaProductosDisp = new ArrayList<>();
    }
    public long generarId(){
        return (listaProductosDisp.size() >0)? listaProductosDisp.get(listaProductosDisp.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, String descripcion, double valor_uni, int stock){
        return listaProductosDisp.add(new Producto(generarId(), descripcion, valor_uni, stock));
    }
    public Producto buscar(String descripcion){
        for (Producto producto : listaProductosDisp) {
            if(producto.getDescripcion().equals(descripcion)){
                seleccionado = producto;
                return producto;
            }
        }
        return null;
    }
    public boolean actualizar(String descripcion, double valor_uni, int stock){
        Producto producto = buscar(descripcion);
        if(producto != null){
            int posicion = listaProductosDisp.indexOf(producto);
            producto.setPrecio_uni(valor_uni);
            producto.setStock(stock);
            listaProductosDisp.set(posicion, producto);
            return true;
        }
        return false;
    }
    public boolean eliminar(String descripcion){
        Producto producto = buscar(descripcion);
        return listaProductosDisp.remove(producto);
    }
    

    public Producto getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Producto seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Producto> getListaProductosDisp() {
        return listaProductosDisp;
    }

    public void setListaProductosDisp(List<Producto> listaProductosDisp) {
        this.listaProductosDisp = listaProductosDisp;
    }
    
    
    
    
}
