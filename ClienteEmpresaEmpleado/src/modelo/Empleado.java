package modelo;

/**
 *
 * @author ediss
 */
public class Empleado extends Persona{ //relacion de herencia con  respecto a persona/ hereda atributos solo de forma simple
    private double SueldoBruto;

    public Empleado( long id, String cedula, String nombre, String apellido, String direccion) {
        super(id, cedula, nombre, apellido, direccion); //super indica que datos vienen del 
    }
    public Empleado( long id, String cedula, String nombre, String apellido, String direccion,double SueldoBruto) {
        super(id, cedula, nombre, apellido, direccion); //super indica que datos vienen del 
        this.SueldoBruto = SueldoBruto; //agregamos sueldo bruto a un constructor aparte
    }

    public double getSueldoButro() {
        return SueldoBruto;
    }

    public void setSueldoButro(double SueldoButro) {
        this.SueldoBruto = SueldoButro;
    }

    @Override
    public String toString() {
        return "Empleado{" + "SueldoBruto=" + SueldoBruto + super.toString()+'}'; //agrega datos de la persona
    }
    

}
