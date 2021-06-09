/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Cliente;
import modelo.Factura;
import modelo.Producto;

/**
 *
 * @author ediss
 */
public class ControladorFactura {
    private Factura seleccionado;
    private List<Factura> listaFacturas;
    
    public ControladorFactura(){
        listaFacturas = new ArrayList<>();
    }
    public long generarId(){
        return (listaFacturas.size() >0)? listaFacturas.get(listaFacturas.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, Date fecha, List<Producto> listaProductosClie, Cliente cliente, double valor){
        return listaFacturas.add(new Factura(generarId(), fecha, listaProductosClie, cliente, valor));
    }
    public Factura buscar(String cedula){
        for (Factura factura : listaFacturas) {
            if(factura.getCliente().getCedula().equals(cedula)){
                seleccionado = factura;
                return factura;
            }
        }
        return null;
    }
    public boolean actualizar(Date fecha, String cedula){
        Factura factura = buscar(cedula);
        if(factura != null){
            int posicion = listaFacturas.indexOf(factura);
            factura.setFecha(fecha);
            listaFacturas.set(posicion, factura);
            return true;
        }
        return false;
    }
    public boolean eliminar(String cedula){
        Factura factura = buscar(cedula);
        return listaFacturas.remove(factura);
    }

    public Factura getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Factura seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }
    
    
    
   
}
