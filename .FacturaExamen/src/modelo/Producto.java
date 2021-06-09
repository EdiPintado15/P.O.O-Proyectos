/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ediss
 */
public class Producto {
    private long id;
    private String descripcion;
    private double precio_uni;
    private int stock;
    private double iva;
    private Cliente cliente;

    public Producto(long id, String descripcion, double precio_uni, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio_uni = precio_uni;
        this.stock = stock;
    }

    public Producto(long id, String descripcion, double precio_uni, int stock, double iva) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio_uni = precio_uni;
        this.stock = stock;
        this.iva = iva;
    }

    public Producto(long id, String descripcion, double precio_uni, int stock, double iva, Cliente cliente) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio_uni = precio_uni;
        this.stock = stock;
        this.iva = iva;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_uni() {
        return precio_uni;
    }

    public void setPrecio_uni(double precio_uni) {
        this.precio_uni = precio_uni;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", descripcion=" + descripcion + ", precioUnitario=" + precio_uni + ", stock=" + stock  + '}';
    }
    
    
}
