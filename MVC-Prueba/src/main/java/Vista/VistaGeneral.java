/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Figuras;
import Modelo.JefeProyecto;
import Modelo.Planos;
import Modelo.Poligonos;
import Modelo.Proyecto;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class VistaGeneral {
    private VistaLinea vistalinea;
    private PoligonosVista poligonoVista;
    private FiguraVista figuraVista;
    private PlanosVista planosVista;
    private ProyectoVista proyectoVista;
    private JefeProyectoVista jefeProyectoVista;
    private Scanner teclado;
    public VistaGeneral(){
        jefeProyectoVista=new JefeProyectoVista();
        proyectoVista=new ProyectoVista(jefeProyectoVista.getJefeProyectoControlador());
        planosVista=new PlanosVista(proyectoVista.getProyectoControlador());
        figuraVista=new FiguraVista(planosVista.getPlanosControlador());
        poligonoVista=new PoligonosVista(figuraVista.getFiguraControlador());
        vistalinea=new VistaLinea(poligonoVista.getPoligonosControlador());
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int op=0;
        do{
            System.out.println("\nSeleccione una opcion");
            System.out.println("1.Jefe del proyecto");
            System.out.println("2.Proyecto");
            System.out.println("3.Planos");
            System.out.println("4.Figura");
            System.out.println("5.Poligonos");
            System.out.println("6.Lineas");
            System.out.println("7.Finalizar");
            op=teclado.nextInt();
            switch(op){
                case 1:
                    jefeProyectoVista.Menu();
                    break;
                case 2:
                    this.Proyecto();
                    break;
                case 3:
                    this.Planos();
                    break;
                case 4:
                    this.Figura();
                    break;
                case 5:
                    this.Poligonos();
                    break;
                case 6:
                    this.Lineas();
            }
        }while(op<7);//para los demas modelos
    }
    public void Proyecto(){
        System.out.println("Ingrese nombre de el jefe de proyecto");
        JefeProyecto jefe=jefeProyectoVista.Buscar();
        if (jefe!=null) {
            proyectoVista.Menu();
        }else{
            System.out.println("No se encuentra");
            this.Proyecto();
        }
    }
    public void Planos(){
        System.out.println("Ingrese el proyecto que gestione los planos");
        Proyecto proyecto=proyectoVista.Buscar();
        if (proyecto!=null) {
            proyectoVista.asignarSeleccionado(proyecto);
            planosVista.Menu();
        }else{
            System.out.println("No se encuentra");
            this.Planos();
        }
    }
    public void Figura(){
        System.out.println("Ingrese el plano para gestionar la figura");
        Planos planos=planosVista.Buscar();
        if (planos!=null) {
            planosVista.asignarSeleccionado(planos);
            figuraVista.Menu();
        }else{
            System.out.println("No se encuentra");
            this.Figura();
        }
    }
    public void Poligonos(){
        System.out.println("Ingrese la figura para gestionar los poligonos");
        Figuras figura=figuraVista.Buscar();
        if (figura!=null) {
            figuraVista.asignarSeleccionado(figura);
            poligonoVista.Menu();
        }else{
            System.out.println("No se encuentra");
            this.Poligonos();
        }
    }
    public void Lineas(){
        System.out.println("Ingrese el poligono al que desea gestionar las lineas");
        Poligonos poligono=poligonoVista.Buscar();
        if (poligono!=null) {
            poligonoVista.AsignarSeleccionado(poligono);
            vistalinea.Menu();
        }else{
            System.out.println("no se encuentra");
            this.Lineas();
        }
    }
}
