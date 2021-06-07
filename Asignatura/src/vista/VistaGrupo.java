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
import controlador.ControladorAula;
import controlador.ControladorGrupo;
import java.util.Scanner;
import modelo.Asignatura;
import modelo.Aula;
import modelo.Grupo;

public class VistaGrupo {
    private ControladorAsignatura controladorAsignatura;
    private ControladorAula controladorAula;
    private ControladorGrupo controladorGrupo;
    private VistaAula vistaAula;
    private VistaAsignatura vistaAsignatura;
    public long idAula;
    public long idAsignatura;
    private Scanner teclado;

    public VistaGrupo(VistaAula vistaAula, VistaAsignatura vistaAsignatura) {
        controladorAsignatura = new ControladorAsignatura();
        controladorAula = new ControladorAula();
        controladorGrupo = new ControladorGrupo();
        this.vistaAula = vistaAula;
        this.vistaAsignatura = vistaAsignatura;
        teclado = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("Gestion Grupo");
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Agregar aula");
            System.out.println("7. Agregar asignatura");
            System.out.println("8. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1: crear(); break;
                case 2: actualizar(); break;
                case 3: buscar(); break;
                case 4: eliminar(); break;
                case 5: listar(); break;
                case 6: agregarAula(); break;
                case 7: agregarAsignatura(); break;
            }
        } while (opcion < 7);
    }

    public void crear() {
        System.out.println("Ingrese el nombre del grupo");
        String nombre = teclado.next();
        int opcion = 0;
        do {
            System.out.println("1. Buscar aula");
            System.out.println("2. Buscar asignaturaa");
            System.out.println("3. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    buscarAula();
                    break;
                case 2:
                    buscarAsignatura();
                    break;
            }
        } while (opcion < 2);
        System.out.println ("Resultado: " + controladorGrupo.crear(nombre, idAula, idAsignatura));
    }

    public Grupo buscar() {
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        Grupo grupo = controladorGrupo.buscar(nombre);
        controladorGrupo.setSeleccionado(grupo);
        System.out.println(grupo);
        return grupo;
    }

    public Asignatura buscarAsignatura() {
        System.out.println("Ingrese el nombre");
        String nombre = teclado.next();
        Asignatura asignatura = controladorAsignatura.buscar(nombre);
        controladorAsignatura.setSeleccionado(asignatura);
        idAsignatura=asignatura.getId();
        System.out.println(asignatura);
        return asignatura;
    }
   

    public Aula buscarAula() {
        System.out.println("Ingrese la descripcion");
        String descripcion = teclado.next();
        Aula aula = controladorAula.buscar(descripcion);
        controladorAula.setSeleccionado(aula);
        idAula=aula.getId();
        System.out.println(aula);
        return aula;
    }

    public void actualizar() {
        Grupo grupo = buscar();
        System.out.println("Ingrese el nuevo nombre");
        String nombreNuevo = teclado.next();
        System.out.println("Resultado: " + controladorGrupo.actualizar(grupo.getNombre(), nombreNuevo));
    }

    public void eliminar() {
        Grupo asignatura = buscar();
        System.out.println("Resultado: " + controladorGrupo.eliminar(asignatura.getNombre()));
    }

    public void listar() {
        for (Grupo grupo : controladorGrupo.getListaGrupo()) {
            System.out.println(grupo);
        }
        for (Aula aula : controladorAula.getListaAula()) {
            System.out.println(aula);
        }
        for (Asignatura asignatura : controladorAsignatura.getListaAsignatura()) {
            System.out.println(asignatura);
        }
    }

    public void agregarAula() {
        Grupo grupo = buscar();
        vistaAula.getControladorAula().setListaAula(grupo.getListadoAula());
        vistaAula.menu();
        
    }

    public void agregarAsignatura() {
        Grupo grupo = buscar();
        vistaAsignatura.getControladorAsignatura().setListaAsignatura(grupo.getListadoAsignatura());
        vistaAsignatura.menu();
    }

    public ControladorGrupo getControladorGrupo() {
        return controladorGrupo;
    }

    public void setControladorGrupo(ControladorGrupo controladorGrupo) {
        this.controladorGrupo = controladorGrupo;
    }

    public VistaAula getVistaAula() {
        return vistaAula;
    }

    public void setVistaAula(VistaAula vistaAula) {
        this.vistaAula = vistaAula;
    }

    public VistaAsignatura getVistaAsignatura() {
        return vistaAsignatura;
    }

    public void setVistaAsignatura(VistaAsignatura vistaAsignatura) {
        this.vistaAsignatura = vistaAsignatura;
    }

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }
    
}

