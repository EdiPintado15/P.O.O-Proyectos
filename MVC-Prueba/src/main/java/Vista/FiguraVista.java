/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FigurasControlador;
import Controlador.PlanosControlador;
import Modelo.Figuras;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class FiguraVista {
    private FigurasControlador figuraControlador;
    private PlanosControlador planosControlador;
    private Scanner teclado;
    public FiguraVista(PlanosControlador planosControlador){
        this.planosControlador=planosControlador;
        figuraControlador=new FigurasControlador();
        teclado=new Scanner(System.in);
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n Figura \n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Listar\n6.Salir");
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
        System.out.println("Ingrese el identificador de la figura");
        String identificador=teclado.next();
        System.out.println("Ingrese el Nombre de la figura");
        String nombre=teclado.next();
        System.out.println("Ingrese el color de la figura");
        String color=teclado.next();
        boolean resultado=figuraControlador.Crear(identificador, nombre, color, planosControlador.getSeleccionado());
        System.out.println("Creado="+resultado);
    }
   
   
    public Figuras Buscar(){
        System.out.println("Ingrese el identificador de la figura a buscar");
        String identificador=teclado.next();
        Figuras figura=figuraControlador.Buscar(identificador);
        System.out.println(figura);
        return figura;
    }
    public void Actualizar(){
        System.out.println("Ingrese el identificador de la figura a actualizar");
        String identificador=teclado.next();
        System.out.println("Ingrese el nuevo Nombre  de la figura");
        String nombre=teclado.next();
        System.out.println("Ingrese el nuevo color  de la figura");
        String color=teclado.next();;
        boolean resultado=figuraControlador.Actualizar(identificador, nombre, color);
        System.out.println("Resultado="+resultado);
    }
    public void Eliminar(){
        System.out.println("Ingrese el identificador de la figura a eliminar");
        String identificador=teclado.next();
        boolean resultado=figuraControlador.Eliminar(identificador);
        System.out.println("Eliminado="+resultado);
    }
    public void Imprimir(){
        for (Figuras figuras :figuraControlador.getListaFiguras()) {
            System.out.println(figuras);
        }
    }
    public void asignarSeleccionado(Figuras figura){
        figuraControlador.setSeleccionado(figura);
    }

    public FigurasControlador getFiguraControlador() {
        return figuraControlador;
    }

    public void setFiguraControlador(FigurasControlador figuraControlador) {
        this.figuraControlador = figuraControlador;
    }

    public PlanosControlador getPlanosControlador() {
        return planosControlador;
    }

    public void setPlanosControlador(PlanosControlador planosControlador) {
        this.planosControlador = planosControlador;
    }
    
}
