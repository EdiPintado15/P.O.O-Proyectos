/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FigurasControlador;
import Controlador.PoligonosControlador;
import Modelo.Lineas;
import Modelo.Poligonos;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class PoligonosVista {
    private PoligonosControlador poligonosControlador;
    private FigurasControlador figurasControlador;
    private Scanner teclado;
    public PoligonosVista(FigurasControlador figurasControlador){
        this.figurasControlador=figurasControlador;
        poligonosControlador=new PoligonosControlador();
        teclado=new Scanner(System.in);
        
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n Poligonos \n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Listar\n6.Salir");
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
        System.out.println("Ingrese el numero de lineas");
        int numLineas=teclado.nextInt();
        boolean resultado=poligonosControlador.Crear(numLineas, 20, 400, figurasControlador.getSeleccionado());
        System.out.println("Creado="+resultado);
    }
   
   
    public Poligonos Buscar(){
        System.out.println("Ingrese el numero de lineas del poligono a buscar");
        int numLineas=teclado.nextInt();
        Poligonos poligono=poligonosControlador.Buscar(numLineas);
        System.out.println(poligono);
        return poligono;
    }
    public void Actualizar(){
        System.out.println("Ingrese el numero de lineas anterior");
        int numLineas=teclado.nextInt();
        System.out.println("Ingrese el numero de lineas nuevo");
        int numLineasAnt=teclado.nextInt();
        boolean resultado=poligonosControlador.Actualizar(numLineas, numLineasAnt);
        System.out.println("Resultado="+resultado);
    }
    public void Eliminar(){
        System.out.println("ingrese el numero de lineas de el poligono a eliminar");
        int numlineas=teclado.nextInt();
        boolean resultado=poligonosControlador.Eliminar(numlineas);
        System.out.println("Eliminado="+resultado);
    }
    public void Imprimir(){
        for (Poligonos poligono : poligonosControlador.getListaPoligonos()) {
            System.out.println(poligono);
        }
    }
    public void AsignarSeleccionado(Poligonos poligonos){
        poligonosControlador.setSelccionado(poligonos);
    }

    public PoligonosControlador getPoligonosControlador() {
        return poligonosControlador;
    }

    public void setPoligonosControlador(PoligonosControlador poligonosControlador) {
        this.poligonosControlador = poligonosControlador;
    }

    public FigurasControlador getFigurasControlador() {
        return figurasControlador;
    }

    public void setFigurasControlador(FigurasControlador figurasControlador) {
        this.figurasControlador = figurasControlador;
    }
    
}
