/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PlanosControlador;
import Controlador.ProyectoControlador;
import Modelo.Planos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class PlanosVista {
    private PlanosControlador planosControlador;
    private ProyectoControlador proyectoControlador;
    private Scanner teclado;
    private SimpleDateFormat formatofecha;
    public PlanosVista(ProyectoControlador proyectoControlador){
        this.proyectoControlador=proyectoControlador;
        planosControlador=new  PlanosControlador();
        formatofecha=new SimpleDateFormat("dd/mm/yyyy");
        teclado=new Scanner(System.in);
    }
    public void Menu(){
        int opcion=0;
        do {            
            System.out.println("\n Planos \n1.Crear\n2.Buscar\n3.Actualizar\n4.Eliminar\n5.Listar\n6.Salir");
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
        System.out.println("Ingrese la fecha de entrega del plano");
        String fecha=teclado.next();
        System.out.println("Ingrese la identificacion del plano en enteros");
        int identificacion=teclado.nextInt();
        System.out.println("Ingrese el numero de arquitectos relacionados");
        int numArquitectos=teclado.nextInt();
        try {
            System.out.println("resultado: "+planosControlador.Crear(identificacion, formatofecha.parse(fecha), numArquitectos,proyectoControlador.getSeleccionado()));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
    public Planos Buscar(){
        System.out.println("Ingrese el identificacion en enteros del plano a buscar");
        int identificacion=teclado.nextInt();
        Planos plano=planosControlador.Buscar(identificacion);
        System.out.println(plano);
        return plano;
    }
    public void Actualizar(){
        System.out.println("Ingrese la identificacion del plano en enteros a actualizar");
        int identificacion=teclado.nextInt();
        System.out.println("Ingrese la fecha de entrega del plano ");
        String fecha=teclado.next();
        System.out.println("Ingrese el numero de arquitectos relacionados");
        int numArquitectos=teclado.nextInt();
        try {
            System.out.println("resultado: "+planosControlador.Actualizar(identificacion, formatofecha.parse(fecha), numArquitectos));//le anaido clietne
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void Eliminar(){
        System.out.println("Ingrese la identificacion en enteros del plano a eliminar");
        int identificador=teclado.nextInt();
        boolean resultado=planosControlador.Eliminar(identificador);
        System.out.println("Eliminado="+resultado);
    }
    public void Imprimir(){
        for (Planos plano : planosControlador.getListaPlanos()) {
            System.out.println(plano);
        }
    }
    public void asignarSeleccionado(Planos planos){
        planosControlador.setSeleccionado(planos);
    }

    public PlanosControlador getPlanosControlador() {
        return planosControlador;
    }

    public void setPlanosControlador(PlanosControlador planosControlador) {
        this.planosControlador = planosControlador;
    }

    public ProyectoControlador getProyectoControlador() {
        return proyectoControlador;
    }

    public void setProyectoControlador(ProyectoControlador proyectoControlador) {
        this.proyectoControlador = proyectoControlador;
    }
    
}
