/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ediss
 */
import java.util.ArrayList;
import java.util.List;
public class Grupo {
     private long id;
    private String nombre;
    private List<Aula> listadoAula;
    private List<Asignatura> listadoAsignatura;

    public Grupo() {
        this.id = 0;
        this.nombre = "";
        this.listadoAula= new ArrayList();
        this.listadoAsignatura= new ArrayList();
    }

    public Grupo(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Grupo(long id, String nombre, List<Aula> aulas) {
        this.id = id;
        this.nombre = nombre;
        this.listadoAula = aulas;
    }

    public Grupo(long id, String nombre, List<Aula> aulas, List<Asignatura> asignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.listadoAula = aulas;
        this.listadoAsignatura = asignaturas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Aula> getListadoAula() {
        return listadoAula;
    }

    public void setListadoAula(List<Aula> listadoAula) {
        this.listadoAula = listadoAula;
    }

    public List<Asignatura> getListadoAsignatura() {
        return listadoAsignatura;
    }

    public void setListadoAsignatura(List<Asignatura> listadoAsignatura) {
        this.listadoAsignatura = listadoAsignatura;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", nombre=" + nombre + ", aulas=" + listadoAula + ", asignaturas=" + listadoAsignatura + '}';
    }    
}
