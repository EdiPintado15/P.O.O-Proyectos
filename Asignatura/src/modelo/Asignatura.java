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
        
public class Asignatura {
    private long id;
    private String nombre;
    private List<Grupo> listadoGrupo;

    public Asignatura() {
        this.id = 0;
        this.nombre = ""; 
        this.listadoGrupo= new ArrayList();
    }

    public Asignatura(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Asignatura(long id, String nombre, List<Grupo> grupos) {
        this.id = id;
        this.nombre = nombre;
        this.listadoGrupo = grupos;
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

    public List<Grupo> getListadoGrupo() {
        return listadoGrupo;
    }

    public void setListadoGrupo(List<Grupo> listadoGrupo) {
        this.listadoGrupo = listadoGrupo;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id=" + id + ", nombre=" + nombre + ", grupos=" + listadoGrupo + '}';
    }
}
    

