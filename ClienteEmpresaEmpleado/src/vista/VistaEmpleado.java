package vista;

import controlador.ControladorEmpleado;
import java.util.Scanner;
import modelo.Empleado;

/**
 *
 * @author ediss
 */
public class VistaEmpleado {
    private ControladorEmpleado controladorEmpleado;
    private final Scanner teclado;
    public VistaEmpleado(){
        controladorEmpleado=new ControladorEmpleado();
        teclado=new Scanner(System.in);
    }
    public void menu(){
        int opcion=0;
        do{
            System.out.println("1.Crear");
            System.out.println("2.Actualizar");
            System.out.println("3.Buscar");
            System.out.println("4.Eliminar");
            System.out.println("5.Listar");
            System.out.println("6.Salir");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:this.crear();break;
                case 2:this.actualizar();break;
                case 3:this.buscar();break;
                case 4:this.eliminar();break;
                case 5:this.listar();break;
            }
        }while(opcion<6);
    }
    public void crear(){
        System.out.println("ingresar id");
        long id=teclado.nextLong();
        System.out.println("ingresar nombre");
        String nombre=teclado.next();
        System.out.println("ingresar apellido");
        String apellido=teclado.next();
        System.out.println("ingresar cedula");
        String cedula=teclado.next();
        System.out.println("ingresar direccion");
        String direccion=teclado.next();
        System.out.println("ingresar sueldo");
        double SueldoBruto=teclado.nextDouble();
        System.out.println("Resultado "+controladorEmpleado.crear(id,cedula, nombre, apellido, direccion, SueldoBruto));

    }
    public Empleado buscar(){
        System.out.println("Ingresar cedula");
        String cedula=teclado.next();
        Empleado empleado=controladorEmpleado.buscar(cedula);
        controladorEmpleado.setSeleccionado(empleado);
        System.out.println(empleado);
        return empleado;
    }
    public void actualizar(){
        Empleado empleado=buscar();
        if (empleado!=null){
            System.out.println("ingresar nombre");
            String nombre=teclado.next();
            System.out.println("ingresar apellido");
            String apellido=teclado.next();
            System.out.println("ingresr direccion");
            String direccion=teclado.next();
            System.out.println("ingresr sueldo");
            double sueldo=teclado.nextDouble();
            System.out.println("Actualizado "+controladorEmpleado.actualizar(empleado.getCedula(), nombre, apellido, direccion,sueldo));
        }
    }
    public void eliminar(){
        Empleado empleado=buscar();
        if(empleado!=null)
            System.out.println("Resultado: "+controladorEmpleado.eliminar(empleado.getCedula()));
    }
    public void listar(){
        controladorEmpleado.getListaEmpleado().forEach(empleado -> {
            System.out.println(empleado);
        });
    }

    public ControladorEmpleado getControladorEmpleado() {
        return controladorEmpleado;
    }

    public void setControladorEmpleado(ControladorEmpleado controladorEmpleado) {
        this.controladorEmpleado = controladorEmpleado;
    }
    
}
