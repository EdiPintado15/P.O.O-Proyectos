/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorJefe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Jefe;

/**
 *
 * @author ediss
 */
public class VistaJefe {
    public Scanner teclado;
    private ControladorJefe controladorJefe;
    
    public VistaJefe(ControladorJefe controladorJefe){
        teclado = new Scanner(System.in);
        this.controladorJefe = controladorJefe;
    }
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Jefe: ");
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
        int num1 = 1;
        System.out.println("Ingrese nombre del nuevo jefe a crear: ");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("Ingrese direccion del nuevo jefe a crear: ");
        String direccion = teclado.nextLine();
        System.out.println("Ingrese telefono del nuevo jefe a crear: ");
        String telefono = teclado.nextLine();
        System.out.println("Res:" + controladorJefe.crear(controladorJefe.generarId(), nombre, direccion, telefono));
    }
    
    public void actualizar(){
        System.out.println("Ingrese el nombre del jefe a actualizar: ");        
        String nombre = teclado.next();
        System.out.println("Ingrese la nueva direccion del jefe: ");
        String direccion = teclado.nextLine();  
        System.out.println("Ingrese el nuevo telefono del jefe: ");
        String telefono = teclado.nextLine();
        System.out.println("Res:" + controladorJefe.actualizar(nombre, direccion, telefono));
    }
    
    public void buscar(){
        System.out.println("Ingrese el nombre del jefe a buscar: ");
        String nombre = teclado.next();
        System.out.println(controladorJefe.buscar(nombre));
    }
    
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorJefe.eliminar(controladorJefe.getSeleccionado().getNombre()));
    }
    
    public void listar(){
        for (Jefe jefe : controladorJefe.getListaJefes()) {
            System.out.println(jefe);
        }
    }
}
