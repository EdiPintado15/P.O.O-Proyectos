/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorProducto;
import java.util.Scanner;
import modelo.Producto;

/**
 *
 * @author ediss
 */
public class VistaProducto {
    public Scanner teclado;
    private ControladorProducto controladorProducto;
    
    public VistaProducto(ControladorProducto controladorProducto){
        teclado = new Scanner(System.in);
        this.controladorProducto = controladorProducto;
    }
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Menu de Productos: ");
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
        System.out.println("Ingrese descripcion del  producto: ");
        teclado.nextLine();
        String descripcion = teclado.nextLine();
        System.out.println("Ingrese precio unitario del producto: ");
        double valor_uni = teclado.nextDouble();
        System.out.println("Ingrese stock del  producto: ");
        int stock = teclado.nextInt();
        System.out.println("respuesta:" + controladorProducto.crear(controladorProducto.generarId(), descripcion, valor_uni, stock ));
    }
    
    public void actualizar(){
        System.out.println("Ingrese la descripcion del producto a actualizar: ");        
        String descripcion = teclado.next();
        System.out.println("Ingrese el nuevo valor unitario del producto: ");
        double valor_uni = teclado.nextDouble();       
        System.out.println("Ingrese el nuevo valor de stock del producto: ");
        int stock = teclado.nextInt();   
        System.out.println("respuesta:" + controladorProducto.actualizar(descripcion, valor_uni, stock));
    }
    
    public void buscar(){
        System.out.println("Ingrese la descripcion del producto: ");
        String descripcion = teclado.next();
        System.out.println(controladorProducto.buscar(descripcion));
    }
    
    public void eliminar(){
        this.buscar();
        System.out.println("respuesta: "+ controladorProducto.eliminar(controladorProducto.getSeleccionado().getDescripcion()));
    }
    
    public void listar(){
        for (Producto producto : controladorProducto.getListaProductosDisp()) {
            System.out.println(producto);
        }
    }
}
