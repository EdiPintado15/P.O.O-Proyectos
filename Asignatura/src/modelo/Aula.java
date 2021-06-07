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

public class Aula {
     private long id;
    private String descripcion;
    private List<Grupo> listadoGrupo;

    public Aula() {
        this.id = 0;
        this.descripcion = ""; 
        this.listadoGrupo= new ArrayList();
    }

    public Aula(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Aula(long id, String descripcion, List<Grupo> grupos) {
        this.id = id;
        this.descripcion = descripcion;
        this.listadoGrupo = grupos;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Grupo> getListadoGrupo() {
        return listadoGrupo;
    }

    public void setListadoGrupo(List<Grupo> listadoGrupo) {
        this.listadoGrupo = listadoGrupo;
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", descripcion=" + descripcion + ", grupos=" + listadoGrupo + '}';
    }
    
}
