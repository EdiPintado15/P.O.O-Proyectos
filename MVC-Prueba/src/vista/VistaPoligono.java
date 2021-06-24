/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLinea;
import controlador.ControladorPoligono;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Linea;
import modelo.Poligono;

/**
 *
 * @author ediss
 */
public class VistaPoligono {
    public Scanner teclado;  
    private ControladorPoligono controladorPoligono;
    private ControladorLinea controladorLinea;
    private List<Linea> listaLineasPoligono;
    
    public VistaPoligono(ControladorPoligono controladorPoligono, ControladorLinea controladorLinea){
        teclado = new Scanner(System.in);
        this.controladorPoligono = controladorPoligono;
        this.controladorLinea = controladorLinea;
        listaLineasPoligono = new ArrayList();
    }
    
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Poligonos ");
            System.out.println(" 1. Crear \n 2. Buscar \n 3. Eliminar \n 4. Listar \n 5. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: this.crear(); break;
                case 2: this.buscar(); break;
                case 3: this.eliminar(); break;
                case 4: this.listar(); break;
            }
        } while (opcion < 5);
    }
    public void crear(){
        int num1 = 1;
        double perimetro = 0;
        System.out.println("Ingrese cuantas lineas diferentes tiene el poligono: ");
        int num = teclado.nextInt();
        System.out.println("Ingrese el codigo del nuevo poligono a crear: ");        
        String codigo = teclado.next();
        while(num1 <= num){
            System.out.println("Ingrese el codigo de la linea "+ num1 +" a agregar: ");
            String codigoLinea = teclado.nextLine();
            Linea linea = controladorLinea.buscar(codigoLinea);
            if(linea != null){
                perimetro = perimetro + linea.getLongitud();
                listaLineasPoligono.add(linea);
                num1=num1+1;
            }else{
                System.out.println("La linea no esta en la Base de Datos ");
                System.out.println(controladorLinea.getListaLineas());
            }  
        }
        System.out.println("Res:" + controladorPoligono.crear(controladorPoligono.generarId(), codigo, listaLineasPoligono, perimetro, num));
    }
    
    public void buscar(){
        System.out.println("Ingrese el codigo del poligono a buscar: ");
        String codigo = teclado.next();
        System.out.println(controladorPoligono.buscar(codigo));       
    }
    
    public void eliminar(){
        System.out.println("Ingrese el codigo del poligono a eliminar: ");
        String codigo = teclado.next();
        System.out.println("Res: "+ controladorPoligono.eliminar(codigo));
    }
    
    public void listar(){
        for(Poligono poligono : controladorPoligono.getListaPoligonos()) {
            System.out.println(poligono);
        }
    }   
}
    