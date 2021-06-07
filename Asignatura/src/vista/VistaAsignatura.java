/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author ediss
 */
import controlador.ControladorAsignatura;
import java.util.Scanner;
import modelo.Asignatura;
import modelo.Grupo;

public class VistaAsignatura {
   private ControladorAsignatura controladorAsignatura;
    private VistaGrupo vistaGrupo;
    private Scanner teclado;

    public VistaAsignatura(VistaGrupo vistaGrupo) {
        controladorAsignatura = new ControladorAsignatura ();
        this.vistaGrupo = vistaGrupo;
        teclado = new Scanner(System.in);
    }
    
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Gestion Asignarura");            
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch(opcion){
                case 1: crear(); break;
                case 2: actualizar(); break;
                case 3: buscar(); break;
                case 4: eliminar(); break;
                case 5: listar(); break;

            }
        } while (opcion<5);
    }
    
    public void crear(){
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        System.out.println("Resultado: " + controladorAsignatura.crear(nombre));
    }
    
    public Asignatura buscar() {
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        Asignatura asignatura = controladorAsignatura.buscar(nombre);
        controladorAsignatura.setSeleccionado(asignatura);
        System.out.println(asignatura);
        return asignatura;
    }
    
    public void actualizar() {
        Asignatura asignatura = buscar();
        System.out.println("Ingrese el nuevo nombre");
        String nombreNuevo = teclado.next();
        System.out.println("Resultado: " + controladorAsignatura.actualizar(asignatura.getNombre(), nombreNuevo));
    }

    public void eliminar() {
        Asignatura asignatura = buscar();
        System.out.println("Resultado: " + controladorAsignatura.eliminar(asignatura.getNombre()));
    }

    public void listar() {
        for (Asignatura asignatura : controladorAsignatura.getListaAsignatura()) {
            System.out.println(asignatura);
        }
    }

    public ControladorAsignatura getControladorAsignatura() {
        return controladorAsignatura;
    }

    public void setControladorAsignatura(ControladorAsignatura controladorAsignatura) {
        this.controladorAsignatura = controladorAsignatura;
    }

    public VistaGrupo getVistaGrupo() {
        return vistaGrupo;
    }

    public void setVistaGrupo(VistaGrupo vistaGrupo) {
        this.vistaGrupo = vistaGrupo;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    } 
}
