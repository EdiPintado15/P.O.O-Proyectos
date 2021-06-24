/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorFigura;
import controlador.ControladorPlano;
import controlador.ControladorPoligono;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Figura;
import modelo.Plano;
import modelo.Poligono;

/**
 *
 * @author ediss
 */
public class VistaPlano {
    public Scanner teclado;
    private ControladorPlano controladorPlano;
    private ControladorFigura controladorFigura;
    private ControladorPoligono controladorPoligono;
    private List<String> listaArquitectos;
    private List<Figura> listaFiguras;
    private List<Poligono> listaPoligonos;
    public DateFormat formatoFecha;
    
    public VistaPlano(ControladorPlano controladorPlano, ControladorFigura controladorFigura, ControladorPoligono controladorPoligono){
        teclado = new Scanner(System.in);
        this.controladorPlano = controladorPlano;
        this.controladorFigura = controladorFigura;
        this.controladorPoligono = controladorPoligono;
        listaArquitectos = new ArrayList();
        listaFiguras = new ArrayList();
        listaPoligonos = new ArrayList();
        formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
    }
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Planos ");
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
        System.out.println("Ingrese codigo del nuevo plano: ");
        teclado.nextLine();
        String codigo = teclado.nextLine();
        System.out.println("Ingrese cuantos arquitectos diferentes agregar al nuevo plano: ");
        int num = teclado.nextInt();
        System.out.println("Ingrese cuantas figuras diferentes agregar al nuevo plano: ");
        int numf = teclado.nextInt();
        System.out.println("Ingrese cuantos poligonos diferentes agregar al nuevo plano: ");
        int nump = teclado.nextInt();
        while(num1 <= num){
            System.out.println("Ingrese el nombre del arquitecto "+ num1 +" a agregar: ");
            teclado.nextLine();
            String nomArq = teclado.nextLine();
            listaArquitectos.add(nomArq);
            num1 = num1 + 1; 
        }
        num1=1;
        while(num1 <= numf){
            System.out.println("Ingrese el nombre de la figura "+ num1 +" a agregar: ");
            String nomFig = teclado.nextLine();
            Figura figura = controladorFigura.buscar(nomFig);
            listaFiguras.add(figura);
            num1 = num1 + 1; 
        }
        num1=1;
        while(num1 <= nump){
            System.out.println("Ingrese el nombre del poligono "+ num1 +" a agregar: ");
            String nomPol = teclado.nextLine();
            Poligono poligono = controladorPoligono.buscar(nomPol);
            listaPoligonos.add(poligono);
            num1 = num1 + 1; 
        }
        System.out.println("Ingresar la Fecha de entrega del plano con formato (dd/mm/yyyy): ");
        String fecha = teclado.next();     
        try {
            System.out.println("Res:" + controladorPlano.crear(controladorPlano.generarId(), codigo, formatoFecha.parse(fecha), listaArquitectos, listaFiguras, listaPoligonos));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void actualizar(){
        System.out.println("Ingrese el codigo del plano a actualizar: ");        
        String codigoplano = teclado.next();
        System.out.println("Ingresar la Fecha de entrega a actualizar con formato (dd/mm/yyyy): ");
        String fechaplano = teclado.next();     
        try {
            System.out.println("Res:" + controladorPlano.actualizar(codigoplano, formatoFecha.parse(fechaplano)));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void buscar(){
        System.out.println("Ingrese el codigo del plano a buscar: ");
        String codigo = teclado.next();
        System.out.println(controladorPlano.buscar(codigo));
    }
    
    public void eliminar(){
        this.buscar();
        System.out.println("Res: "+ controladorPlano.eliminar(controladorPlano.getSeleccionado().getCodigo()));
    }
    
    public void listar(){
        for (Plano plano : controladorPlano.getListaPlanos()) {
            System.out.println(plano);
        }
    }
}
