/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorJefe;
import controlador.ControladorPlano;
import controlador.ControladorProyecto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Jefe;
import modelo.Plano;
import modelo.Proyecto;

/**
 *
 * @author ediss
 */
public class VistaProyecto {
    public Scanner teclado;
    private ControladorProyecto controladorProyecto;
    private ControladorJefe controladorJefe;
    private ControladorPlano controladorPlano;
    private List<Plano> listaPlanosProyecto;
    
    public VistaProyecto(ControladorProyecto controladorProyecto, ControladorJefe controladorJefe, ControladorPlano controladorPlano){
        teclado = new Scanner(System.in);
        this.controladorProyecto = controladorProyecto;
        this.controladorJefe = controladorJefe;
        this.controladorPlano = controladorPlano;
        listaPlanosProyecto = new ArrayList();
    }
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Proyectos ");
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
        System.out.println("Ingrese nombre del nuevo proyecto: ");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("Ingrese cuantos planos diferentes agregar: ");
        int num = teclado.nextInt();
        while(num1 <= num){
            System.out.println("Ingrese el codigo del plano "+ num1 +" a agregar: ");
            String codigoPlano = teclado.nextLine();
            Plano plano = controladorPlano.buscar(codigoPlano);
            if(plano != null){
                listaPlanosProyecto.add(plano);
                num1 = num1 + 1;
            }else{
                System.out.println("El Plano no esta en la Base de Datos ");
            }  
        }
        System.out.println("Ingrese nombre del jefe del nuevo proyecto: ");
        String nomjefe = teclado.nextLine();
        Jefe jefe = controladorJefe.buscar(nomjefe);
        System.out.println("Res:" + controladorProyecto.crear(controladorProyecto.generarId(), nombre, listaPlanosProyecto, jefe));
    }
    
    public void actualizar(){
        System.out.println("Ingrese el nombre del proyecto a actualizar: ");        
        String nombre = teclado.next();
        System.out.println("Ingrese el nuevo nombre del proyecto: ");
        String nombreAct = teclado.nextLine();         
        System.out.println("Res:" + controladorProyecto.actualizar(nombre, nombreAct));
    }
    
    public void buscar(){
        System.out.println("Ingrese el nombre del proyecto a buscar: ");
        String nombre = teclado.next();
        System.out.println(controladorProyecto.buscar(nombre));
    }
    
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorProyecto.eliminar(controladorProyecto.getSeleccionado().getNombre()));
    }
    
    public void listar(){
        for (Proyecto proyecto : controladorProyecto.getListaProyectos()) {
            System.out.println(proyecto);
        }
    }   
}
