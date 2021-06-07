/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author ediss
 */
import java.util.ArrayList;
import java.util.List;
import modelo.Asignatura;
import modelo.Aula;
import modelo.Grupo;

public class ControladorGrupo {
    private List<Grupo> listaGrupo;
    private Grupo seleccionado;
    

    public ControladorGrupo() {
        listaGrupo = new ArrayList<Grupo>();
        seleccionado = null;
    }

    public long generarId() {
        return (listaGrupo.size() > 0) ? listaGrupo.get(listaGrupo.size() - 1).getId() + 1 : 1;
    }

    public boolean crear(String nombre, long idAula, long Asignatura) {
        return listaGrupo.add(new Grupo(generarId(), nombre));
    }

    public Grupo buscar(String nombre) {
        for (Grupo grupo : listaGrupo) {
            if (grupo.getNombre().equals(nombre)) {
                return grupo;
            }
        }
        return null;
    }

    public boolean actualizar(String nombreAnterior, String nombre) {
        Grupo grupo = buscar(nombreAnterior);
        if (grupo != null) {
            int posicion = listaGrupo.indexOf(grupo);
            grupo.setNombre(nombre);
            listaGrupo.set(posicion, grupo);
            return true;
        }
        return false;
    }

    public boolean eliminar(String nombre) {
        return listaGrupo.remove(buscar(nombre));
    }

    public boolean agregarAula(Aula aula) {
        return seleccionado.getListadoAula().add(aula);
    }

    public boolean agregarAsignatura(Asignatura asignatura) {
        return seleccionado.getListadoAsignatura().add(asignatura);
    }

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    public Grupo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Grupo seleccionado) {
        this.seleccionado = seleccionado;
    }

}
    

