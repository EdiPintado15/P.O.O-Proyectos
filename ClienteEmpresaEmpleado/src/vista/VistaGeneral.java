package vista;

import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class VistaGeneral {
    private final VistaEmpresa vistaEmpresa;
    private final VistaCliente vistaCliente;
    private final VistaEmpleado vistaEmpleado;
    private final VistaDirectivo vistaDirectivo;
    private final Scanner teclado;
    public VistaGeneral(){
        vistaCliente=new VistaCliente();
        vistaDirectivo=new VistaDirectivo();
        vistaEmpleado=new VistaEmpleado();
        vistaEmpresa=new VistaEmpresa(vistaCliente,vistaEmpleado,vistaDirectivo);
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("1.Empresa");
            System.out.println("2.Salir");
            //System.out.println("3.Directivos");
            //System.out.println("4.Clientes");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1: vistaEmpresa.menu();break;
                //case 2: vistaEmpleado.menu();break;
                //case 3: vistaDirectivo.menu();break;
                //case 4: vistaCliente.menu();break;
            }
        }while(opcion<5);
    }
               
}
