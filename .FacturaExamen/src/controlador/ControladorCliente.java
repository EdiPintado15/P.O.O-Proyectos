/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author ediss
 */
public class ControladorCliente {
    private Cliente seleccionado;
    private List<Cliente> listaClientes;
    
    public ControladorCliente(){
        listaClientes = new ArrayList<>();
    }
    public long generarId(){
        return (listaClientes.size() >0)? listaClientes.get(listaClientes.size() - 1).getId() + 1 : 1;
    }
    public boolean crear(long id, String nombre, String cedula){
        return listaClientes.add(new Cliente(generarId(), nombre, cedula));
    }
    public Cliente buscar(String cedula){
        for (Cliente cliente : listaClientes) {
            if(cliente.getCedula().equals(cedula)){
                seleccionado = cliente;
                return cliente;
            }
        }
        return null;
    }
    public boolean actualizar(String nombre, String cedula){
        Cliente cliente = buscar(cedula);
        if(cliente != null){
            int posicion = listaClientes.indexOf(cliente);
            cliente.setNombre(nombre);
            listaClientes.set(posicion, cliente);
            return true;
        }
        return false;
    }
    public boolean eliminar(String cedula){
        Cliente cliente = buscar(cedula);
        return listaClientes.remove(cliente);
    }

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
}
