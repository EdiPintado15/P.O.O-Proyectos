/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ediss
 */
public class JefeProyecto {
    private long id;
    private String codigo;
    private String direccion;
    private String nombre;
    private String telefono;
    private Proyecto proyecto;

    public JefeProyecto(long id, String codigo, String direccion, String nombre, String telefono) {
        this.id = id;
        this.codigo = codigo;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public JefeProyecto(long id, String codigo, String direccion, String nombre, String telefono, Proyecto proyecto) {
        this.id = id;
        this.codigo = codigo;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.proyecto = proyecto;
    }
    

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "JefeProyecto{" + "id=" + id + ", codigo=" + codigo + ", direccion=" + direccion + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
}
