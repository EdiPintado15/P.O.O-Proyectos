/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLinea;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import modelo.Linea;

/**
 *
 * @author ediss
 */
public class VistaLinea {
    public Scanner teclado;
    private ControladorLinea controladorLinea;    
    
    public VistaLinea(ControladorLinea controladorLinea){
        teclado = new Scanner(System.in);
        this.controladorLinea = controladorLinea;
    }
    
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Linea: ");
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
        double lx=0;
        double ly=0;
        double longitud=0;
        System.out.println("Ingrese codigo de la nueva linea a crear: ");
        teclado.nextLine();
        String codigo = teclado.nextLine();
        System.out.println("Ingrese coordenada X1 de la nueva linea a crear: ");
        double x1 = teclado.nextDouble();
        System.out.println("Ingrese coordenada Y1 de la nueva linea a crear: ");
        double y1 = teclado.nextDouble();
        System.out.println("Ingrese coordenada X2 de la nueva linea a crear: ");
        double x2 = teclado.nextDouble();
        System.out.println("Ingrese coordenada Y2 de la nueva linea a crear: ");
        double y2 = teclado.nextDouble();
        if(x1<x2){
            lx = x2-x1;
        }else{
            lx = x1-x2;
        }
        if(y1<y2){
            ly = y2-y1;
        }else{
            ly = y1-y2;
        }
        longitud = sqrt((lx*lx)+(ly*ly));
        System.out.println("Res:" + controladorLinea.crear(controladorLinea.generarId(), codigo, x1, y1, x2, y2, longitud));
    }
    
    public void actualizar(){
        System.out.println("Ingrese codigo de la nueva linea a actualizar: ");
        teclado.nextLine();
        String codigo = teclado.nextLine();
        System.out.println("Ingrese coordenada X1 de la linea a actualizar: ");
        double x1 = teclado.nextDouble();
        System.out.println("Ingrese coordenada Y1 de la linea a actualizar: ");
        double y1 = teclado.nextDouble();
        System.out.println("Ingrese coordenada X2 de la linea a actualizar: ");
        double x2 = teclado.nextDouble();
        System.out.println("Ingrese coordenada Y2 de la linea a actualizar: ");
        double y2 = teclado.nextDouble();
        System.out.println("Res:" + controladorLinea.actualizar(codigo, x1, y1, x2, y2));
    }
    
    public void buscar(){
        System.out.println("Ingrese el codigo de la linea a buscar: ");
        String codigo = teclado.next();
        System.out.println(controladorLinea.buscar(codigo));
    }
    
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorLinea.eliminar(controladorLinea.getSeleccionado().getCodigo()));
    }
    
    public void listar(){
        for (Linea linea : controladorLinea.getListaLineas()) {
            System.out.println(linea);
        }
    }
}
