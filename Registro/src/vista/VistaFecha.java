/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFecha;
import java.util.Scanner;
import modelo.Fecha;

/**
 *
 * @author diego
 */
public class VistaFecha {
    public Scanner teclado;
    private ControladorFecha controladorFecha;
    public VistaFecha(ControladorFecha controladorFecha){
        teclado = new Scanner(System.in);
        this.controladorFecha = controladorFecha;
    }
    public void menu(){
        int opcion = 0;
        do {            
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
        System.out.println("Ingrese: \n dia");
        int dia = teclado.nextInt();
        System.out.println("mes");
        int mes = teclado.nextInt();
        System.out.println("Año");
        int anio = teclado.nextInt();
        System.out.println("Res:" + controladorFecha.crear(dia, mes, anio));
    }
    public void actualizar(){
        System.out.println("Ingrese: \n dia");
        int dia = teclado.nextInt();
        System.out.println("mes");
        int mes = teclado.nextInt();
        System.out.println("Año");
        int anio = teclado.nextInt();
        System.out.println("Res:" + controladorFecha.actualizar(dia, mes, anio));
    }
    public Fecha buscar(){
        System.out.println("Ingrese: \n dia");
        int dia = teclado.nextInt();
        System.out.println("mes");
        int mes = teclado.nextInt();
        System.out.println(controladorFecha.buscar(dia, mes));
        return controladorFecha.buscar(dia, mes);
    }
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorFecha.eliminar(controladorFecha.getSeleccionado().getDia(), controladorFecha.getSeleccionado().getMes()));
    }
    public void listar(){
        for (Fecha fecha : controladorFecha.getListaFecha()) {
            System.out.println(fecha);
        }
    }
}
