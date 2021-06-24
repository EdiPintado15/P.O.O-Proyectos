/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.LineasControlador;
import Controlador.PoligonosControlador;
import Modelo.Lineas;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class VistaLinea {
    private PoligonosControlador poligonosControlador;
    private LineasControlador lineasControlador;
    private Scanner teclado;
    public VistaLinea(PoligonosControlador poligonosControlador){
        this.poligonosControlador=poligonosControlador;
        lineasControlador=new LineasControlador();
        teclado=new Scanner(System.in);
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n Lineas \n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Listar\n6.Salir");
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
        System.out.println("Ingrese el identificador");
        String identificador=teclado.next();
        System.out.println("Ingrese el punto el eje X donde comienza la linea.");
        double P1X=teclado.nextDouble();
        System.out.println("Ingrese el punto el eje X donde termina la linea.");
        double P2X=teclado.nextDouble();
        System.out.println("Ingrese el punto el eje Y donde comienza la linea.");
        double P1Y=teclado.nextDouble();
        System.out.println("Ingrese el punto el eje Y donde termina la linea.");
        double P2Y=teclado.nextDouble();
        double longitud=this.longitud(P1X, P2X, P1Y, P2Y);
        boolean resultado=lineasControlador.Crear(identificador, longitud, P1X, P1Y, P2X, P2Y,poligonosControlador.getSeleccionado());
        System.out.println("Creado="+resultado);
    }
    public double longitud(double P1X,double P2X,double P1Y,double P2Y){
        double val=Math.pow((P2Y-P1Y),2)+Math.pow((P2X-P1X),2);
        double longi=Math.sqrt(val);
        return longi;
    }
    public Lineas Buscar(){
        System.out.println("Ingrese el identificador de la linea a buscar");
        String identificador=teclado.next();
        Lineas linea=lineasControlador.Buscar(identificador);
        System.out.println(linea);
        return linea;
    }
    public void Actualizar(){
        System.out.println("Ingrese el identificador de la linea a actualizar");
        String identificador=teclado.next();
        System.out.println("Ingrese el punto el eje X donde comienza la linea.");
        double P1X=teclado.nextDouble();
        System.out.println("Ingrese el punto el eje X donde termina la linea.");
        double P2X=teclado.nextDouble();
        System.out.println("Ingrese el punto el eje Y donde comienza la linea.");
        double P1Y=teclado.nextDouble();
        System.out.println("Ingrese el punto el eje Y donde termina la linea.");
        double P2Y=teclado.nextDouble();
        double longitud=this.longitud(P1X, P2X, P1Y, P2Y);
        boolean resultado=lineasControlador.Actualizar(identificador, longitud, P1X, P1Y, P2X, P2Y);
        System.out.println("Resultado="+resultado);
    }
    public void Eliminar(){
        System.out.println("ingrese el identificador de la linea a eliminar");
        String identificador=teclado.next();
        boolean resultado=lineasControlador.Eliminar(identificador);
        System.out.println("Eliminado="+resultado);
    }
    public void Imprimir(){
        for (Lineas linea : lineasControlador.getListaLineas()) {
            System.out.println(linea);
        }
    }
    
}

