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
import controlador.ControladorAula;
import java.util.Scanner;
import modelo.Aula;
import modelo.Grupo;

public class VistaAula {
     private ControladorAula controladorAula;
    private VistaGrupo vistaGrupo;
    private Scanner teclado;

    public VistaAula(VistaGrupo vistaGrupo) {
        controladorAula = new ControladorAula ();
        this.vistaGrupo= vistaGrupo;
        teclado = new Scanner(System.in);
    }

    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Gestion Aula");            
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
        System.out.println("Ingrese la descripcion");
        String descripcion = teclado.next();
        System.out.println("Resultado: " + controladorAula.crear(descripcion));
    }
    
    public Aula buscar() {
        System.out.println("Ingrese la descripcion");
        String descripcion = teclado.next();
        Aula aula = controladorAula.buscar(descripcion);
        controladorAula.setSeleccionado(aula);
        System.out.println(aula);
        return aula;
    }
    
    public void actualizar() {
        Aula aula = buscar();
        System.out.println("Ingrese la nueva descripcion");
        String descripcionNuevo = teclado.next();
        System.out.println("Resultado: " + controladorAula.actualizar(aula.getDescripcion(), descripcionNuevo));
    }

    public void eliminar() {
        Aula aula = buscar();
        System.out.println("Resultado: " + controladorAula.eliminar(aula.getDescripcion()));
    }

    public void listar() {
        for (Aula aula : controladorAula.getListaAula()) {
            System.out.println(aula);
        }
    }

    public ControladorAula getControladorAula() {
        return controladorAula;
    }

    public void setControladorAula(ControladorAula controladorAula) {
        this.controladorAula = controladorAula;
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
