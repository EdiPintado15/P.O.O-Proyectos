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

import java.util.Scanner;
import modelo.Aula;
import modelo.Grupo;

public class VistaGeneral {
    private Scanner teclado;
    private VistaAsignatura vistaAsignatura;
    private VistaAula vistaAula;
    private VistaGrupo vistaGrupo;
   

    public VistaGeneral() {
        vistaAsignatura = new VistaAsignatura(vistaGrupo);
        vistaAula = new VistaAula(vistaGrupo);
        vistaGrupo= new VistaGrupo(vistaAula, vistaAsignatura);
        teclado = new Scanner(System.in);
    }

    public void menu(){
        int opcion = 0;
        do {            
            System.out.println("1. Grupos");
            System.out.println("2. Aulas");
            System.out.println("3. Asignaturas");
            System.out.println("4. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: vistaGrupo.menu(); break;
                case 2: vistaAula.menu(); break;
                case 3: vistaAsignatura.menu(); break;
            }
        } while (opcion<5);
    }
}

  


