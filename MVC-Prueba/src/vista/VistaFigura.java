/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFigura;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import modelo.Figura;

/**
 *
 * @author ediss
 */
public class VistaFigura {
    public Scanner teclado;
    private ControladorFigura controladorFigura;
    
    public VistaFigura(ControladorFigura controladorFigura){
        teclado = new Scanner(System.in);
        this.controladorFigura = controladorFigura;
    }
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Figura ");
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
        double area = 0;
        double perimetro = 0;
        String nombre = "";
        System.out.println("Ingrese color de la nueva figura a crear: ");
        teclado.nextLine();
        String color = teclado.nextLine();
        int opcion = 0;
            System.out.println("Elija una Figura: ");
            System.out.println(" 1. Cuadrado \n 2. Rectangulo \n 3. Triangulo \n 4. Circulo \n 5. Salir ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: 
                    System.out.println("Ingrese la longitud del lado del cuadrado: ");        
                    double lineaCuadrado = teclado.nextDouble();
                    area = lineaCuadrado * lineaCuadrado;
                    perimetro = 4*lineaCuadrado;
                    System.out.println("Ingrese el nombre del Cuadrado (C#): ");
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    break;
                case 2: 
                    System.out.println("Ingrese la longitud de la base del rectangulo: ");        
                    double baseRect = teclado.nextDouble();
                    System.out.println("Ingrese la longitud de la altura del rectangulo: ");        
                    double alturaRect = teclado.nextDouble();
                    area = baseRect * alturaRect;
                    perimetro = (2*baseRect) + (2*alturaRect);
                    System.out.println("Ingrese el nombre del Rectangulo (R#): ");
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    break;
                case 3: 
                    System.out.println("Ingrese la longitud de la base del triangulo: ");        
                    double baseTri = teclado.nextDouble();
                    System.out.println("Ingrese la longitud de la altura del triangulo: ");        
                    double alturaTri = teclado.nextDouble();
                    area = (baseTri * alturaTri)/2;
                    double ladoTri = sqrt(((baseTri/2)*(baseTri/2))+(alturaTri*alturaTri));
                    perimetro = (2*ladoTri) + (baseTri);
                    System.out.println("Ingrese el nombre del Triangulo: ");
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    break;
                case 4: 
                    System.out.println("Ingrese el radio del circulo: ");        
                    double radCirc = teclado.nextDouble();
                    area = 3.14159 * (radCirc*radCirc);
                    perimetro = 2 * 3.14159 * radCirc; 
                    System.out.println("Ingrese el nombre del Circulo: ");
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    break;
            }
        System.out.println("Res:" + controladorFigura.crear(controladorFigura.generarId(), nombre, color, area, perimetro));
    }
    
    public void actualizar(){
        System.out.println("Ingrese nombre de la figura a actualizar: ");        
        String nombre = teclado.next();
        System.out.println("Ingrese color de la figura a actualizar: ");
        String color = teclado.nextLine();
        System.out.println("Res:" + controladorFigura.actualizar(nombre, color));
    }
    
    public void buscar(){
        System.out.println("Ingrese el nombre de la figura a buscar: ");
        String nombre = teclado.next();
        System.out.println(controladorFigura.buscar(nombre));
    }
    
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorFigura.eliminar(controladorFigura.getSeleccionado().getNombre()));
    }
    
    public void listar(){
        for (Figura figura : controladorFigura.getListaFiguras()) {
            System.out.println(figura);
        }
    }
}
