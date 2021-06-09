/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import java.util.Scanner;
import modelo.Cliente;

/**
 *
 * @author ediss
 */
public class VistaCliente {
    public Scanner teclado;
    private ControladorCliente controladorCliente;
    
    public VistaCliente(ControladorCliente controladorCliente){
        teclado = new Scanner(System.in);
        this.controladorCliente = controladorCliente;
    }
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Menu  Cliente: ");
            System.out.println(" 1. Crear \n 2. Actualizar \n 3. Buscar \n 4. Eliminar \n 5. Listar \n 6. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: this.crear(); break;
                case 2: this.actualizar(); break;
                case 3: this.buscar(); break;
                case 4: this.eliminar(); break;
                case 5: this.listar(); break;
            }
        } while (opcion < 6);
    }
    public void crear(){
        System.out.println("Ingrese nombre del cliente: ");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("Ingrese cedula del cliente: ");
        String cedula = teclado.nextLine();
        System.out.println("Respuesta:" + controladorCliente.crear(controladorCliente.generarId(), nombre, cedula));
    }
    
    public void actualizar(){
        System.out.println("Ingrese la cedula del cliente: ");        
        String cedula = teclado.next();
        System.out.println("Ingrese  nombre del cliente: ");
        String nombre = teclado.nextLine();         
        System.out.println("Respuesta:" + controladorCliente.actualizar(nombre, cedula));
    }
    
    public void buscar(){
        System.out.println("Ingrese la cedula del cliente: ");
        String cedula = teclado.next();
        System.out.println(controladorCliente.buscar(cedula));
    }
    
    public void eliminar(){
        this.buscar();
        System.out.println("Respuesta: "+ controladorCliente.eliminar(controladorCliente.getSeleccionado().getCedula()));
    }
    
    public void listar(){
        for (Cliente cliente : controladorCliente.getListaClientes()) {
            System.out.println(cliente);
        }
    }
}
