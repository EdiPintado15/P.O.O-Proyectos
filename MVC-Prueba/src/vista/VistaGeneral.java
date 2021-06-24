/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFigura;
import controlador.ControladorJefe;
import controlador.ControladorLinea;
import controlador.ControladorPlano;
import controlador.ControladorPoligono;
import controlador.ControladorProyecto;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class VistaGeneral {
    public Scanner teclado;
    public VistaProyecto vistaProyecto;
    public ControladorProyecto controladorProyecto;
    public VistaJefe vistaJefe;
    public ControladorJefe controladorJefe;
    public VistaPlano vistaPlano;
    public ControladorPlano controladorPlano;
    public VistaFigura vistaFigura;
    public ControladorFigura controladorFigura;
    public VistaPoligono vistaPoligono;
    public ControladorPoligono controladorPoligono;
    public VistaLinea vistaLinea;
    public ControladorLinea controladorLinea;
    
    public VistaGeneral() {
        teclado = new Scanner(System.in);
        controladorLinea = new ControladorLinea();
        vistaLinea = new VistaLinea(controladorLinea);
        controladorFigura = new ControladorFigura();
        vistaFigura = new VistaFigura(controladorFigura);
        controladorJefe = new ControladorJefe();
        vistaJefe = new VistaJefe(controladorJefe);
        controladorPoligono = new ControladorPoligono();
        vistaPoligono = new VistaPoligono(controladorPoligono, controladorLinea);
        controladorPlano = new ControladorPlano();
        vistaPlano = new VistaPlano(controladorPlano, controladorFigura, controladorPoligono);
        controladorProyecto = new ControladorProyecto();
        vistaProyecto = new VistaProyecto(controladorProyecto, controladorJefe, controladorPlano);
        
    }
        
    public void menu() {
        int opcion = 0;
        do {
            System.out.println("Proyectos ");
            System.out.println(" 1. Proyectos \n 2. Jefes \n 3. Planos \n 4. Figuras \n 5. Poligonos \n 6. Lineas \n 7. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: this.menFacturaProy(); break;
                case 2: vistaJefe.menu(); break;
                case 3: this.menFacturaPlan(); break;
                case 4: vistaFigura.menu(); break;
                case 5: this.menFacturaPol(); break;
                case 6: vistaLinea.menu(); break;
            }
        } while (opcion < 7);
    }
    
    public void menFacturaProy(){
        if(controladorPlano.getListaPlanos().size()!= 0 ){
            if(controladorJefe.getListaJefes().size()!= 0){
                vistaProyecto.menu();
            }else{
                System.out.println("No existen Jefes en la base de Datos para crear Proyectos");
                vistaJefe.menu();
            }   
        }else{
            System.out.println("No existen Planos en la base de Datos para crear Proyectos ");
            this.menFacturaPlan();
        }
    }     

    private void menFacturaPlan() {
        if(controladorPoligono.getListaPoligonos().size()!= 0 ){
            if(controladorFigura.getListaFiguras().size()!= 0){
                vistaPlano.menu();
            }else{
                System.out.println("No existen Figuras en la base de Datos para crear Planos");
                vistaFigura.menu();
            }   
        }else{
            System.out.println("No existen Poligonos en la base de Datos para crear Planos ");
            this.menFacturaPol();
        }
    }

    private void menFacturaPol() {
        if(controladorLinea.getListaLineas().size()!= 0 ){
            vistaPoligono.menu();
        }else{
            System.out.println("No existen Lineas en la base de Datos para crear Poligonos");
            vistaLinea.menu();
        }   
    }
}
