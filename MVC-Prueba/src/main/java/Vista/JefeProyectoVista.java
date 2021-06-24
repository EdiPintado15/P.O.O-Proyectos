/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.JefeProyectoControlador;
import Controlador.ProyectoControlador;
import Modelo.JefeProyecto;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class JefeProyectoVista {
    private JefeProyectoControlador jefeProyectoControlador;
    private Scanner teclado;
    public JefeProyectoVista(){
        jefeProyectoControlador=new JefeProyectoControlador();
        teclado=new Scanner(System.in);
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n Proyecto \n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Listar\n6.Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:
                    this.Crear();
                    break;
                case 2:
                    this.Buscar();
                    break;
                case 3:
                    this.Actualizar();
                    break;
                case 4:
                    this.Eliminar();
                case 5:
                    this.Imprimir();
            }
        } while (opcion<6);
    }
    public void Crear(){
        System.out.println("Ingrese el codigo del jefe de proyecto");
        String codigo=teclado.next();
        System.out.println("Ingrese el nombre del jefe de proyecto");
        String nombre=teclado.next();
        System.out.println("Ingrese la direccion del jefe de proyecto");
        String direccion=teclado.next();
        System.out.println("Ingrese el telefono del jefe de proyecto");
        String telefono=teclado.next();
        boolean resultado=jefeProyectoControlador.Crear(codigo, direccion, nombre, telefono);
        System.out.println("Creado="+resultado);
    }
    
    public JefeProyecto Buscar(){
        System.out.println("Ingrese el nombre del jefe del proyecto para buscar");
        String nombre=teclado.next();
        JefeProyecto persona=jefeProyectoControlador.Buscar(nombre);
        System.out.println(persona);
        jefeProyectoControlador.setSeleccionado(persona);
        return persona;
    }
    public void Actualizar(){
        
        System.out.println("Ingrese el nombre del jefe de proyecto a actualizar");
        String nombre=teclado.next();
        System.out.println("Ingrese el nuevo nombre del jefe de proyecto");
        String nombrenuevo=teclado.next();
        System.out.println("Ingrese el codigo nuevo del jefe de proyecto");
        String codigo=teclado.next();
        System.out.println("Ingrese la direccion del jefe de proyecto");
        String direccion=teclado.next();
        System.out.println("Ingrese el telefono del jefe de proyecto");
        String telefono=teclado.next();
        boolean resultado=jefeProyectoControlador.Actualizar(codigo, direccion, nombre, nombrenuevo, telefono);
        System.out.println("Resultado="+resultado);
    }
    public void Eliminar(){
        System.out.println("ingrese el nombre del jefe a eliminar");
        String nombre=teclado.next();
        boolean resultado=jefeProyectoControlador.Eliminar(nombre);
        System.out.println("Eliminado="+resultado);
    }
    public void Imprimir(){
        for (JefeProyecto listaPersona : jefeProyectoControlador.getListaPersonas()) {
            System.out.println(listaPersona);
        }
    }
    public void asignarSeleccionado(JefeProyecto jefe){
        jefeProyectoControlador.setSeleccionado(jefe);
    }

    public JefeProyectoControlador getJefeProyectoControlador() {
        return jefeProyectoControlador;
    }

    public void setJefeProyectoControlador(JefeProyectoControlador jefeProyectoControlador) {
        this.jefeProyectoControlador = jefeProyectoControlador;
    }

    
    
}
