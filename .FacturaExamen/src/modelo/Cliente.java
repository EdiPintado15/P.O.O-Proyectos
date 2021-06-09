/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author ediss
 */
public class Cliente {
    private long id;
    private String nombre;
    private String cedula;
    private Factura factura;
    private List<Producto> listaProductosClie;

    public Cliente(long id, String nombre, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Cliente(long id, String nombre, String cedula, Factura factura) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.factura = factura;
    }

    public Cliente(long id, String nombre, String cedula, Factura factura, List<Producto> listaProductosClie) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.factura = factura;
        this.listaProductosClie = listaProductosClie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Producto> getListaProductosClie() {
        return listaProductosClie;
    }

    public void setListaProductosClie(List<Producto> listaProductosClie) {
        this.listaProductosClie = listaProductosClie;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + '}';
    }
    
    
}
