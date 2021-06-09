/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ediss
 */
public class Factura {
    private long id;
    private Date fecha;
    private List<Producto> listaProductosClie;
    private double valor;
    private Cliente cliente;

    public Factura(long id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Factura(long id, Date fecha, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Factura(long id, Date fecha, List<Producto> listaProductosClie, Cliente cliente, double valor) {
        this.id = id;
        this.fecha = fecha;
        this.listaProductosClie = listaProductosClie;
        this.cliente = cliente;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public List<Producto> getListaProductosClie() {
        return listaProductosClie;
    }

    public void setListaProductosClie(List<Producto> listaProductosClie) {
        this.listaProductosClie = listaProductosClie;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", fecha=" + fecha + ", listaProductosCliete=" + listaProductosClie + ", valor=" + valor + ", cliente=" + cliente + '}';
    }
    
}
