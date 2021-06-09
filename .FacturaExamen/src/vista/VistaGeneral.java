/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import controlador.ControladorFactura;
import controlador.ControladorProducto;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class VistaGeneral {
    public Scanner teclado;
    public VistaProducto vistaProducto;
    public ControladorProducto controladorProducto;
    public VistaCliente vistaCliente;
    public ControladorCliente controladorCliente;
    public VistaFactura vistaFactura;
    public ControladorFactura controladorFactura;
    
    
    public VistaGeneral() {
        teclado = new Scanner(System.in);
        controladorProducto = new ControladorProducto();
        vistaProducto = new VistaProducto(controladorProducto);
        controladorCliente = new ControladorCliente();
        vistaCliente = new VistaCliente(controladorCliente);
        controladorFactura = new ControladorFactura();
        vistaFactura = new VistaFactura(controladorFactura, controladorProducto, controladorCliente);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("Gestion de la Tienda: ");
            System.out.println(" 1. Productos \n 2. Clientes \n 3. Facturas \n 4. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: vistaProducto.menu(); break;
                case 2: vistaCliente.menu(); break;
                case 3: this.menFactura(); break;
            }
        } while (opcion < 4);
    }
    
    public void menFactura(){
        if(controladorCliente.getListaClientes().size()!= 0 ){
            if(controladorProducto.getListaProductosDisp().size()!= 0){
                vistaFactura.menu();
            }else{
                System.out.println("No existe Productos ");
                vistaProducto.menu();
            }   
        }else{
            System.out.println("No existe Clientes con estas caracteristicas ");
            vistaCliente.menu();
        }
    }  
}
