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
import modelo.Aula;
import modelo.Grupo;
public class ControladorAula {
    
    private List<Aula> listaAula;
    private Aula seleccionado;
    private Grupo grupo;

    public ControladorAula() {
        listaAula = new ArrayList<Aula>();
        seleccionado = null;
        grupo = new Grupo();
    }

    public long generarId() {
        // Operadores ternarios: Es poder realizar un if / else en una sola linea
        return (listaAula.size() > 0) ? listaAula.get(listaAula.size() - 1).getId() + 1 : 1;
    }

    // CRUD -> Create, Read , Update, Delete -- Crear Leer/Buscar Actualizar Eliminar
    public boolean crear(String descripcion) {
        return listaAula.add(new Aula(generarId(), descripcion));

    }

    public Aula buscar(String descripcion) {
        for (Aula aula : listaAula) {
            if (aula.getDescripcion().equals(descripcion)) {
                return aula;
            }
        }
        return null;
    }

    public boolean actualizar(String descripcionAnterior, String descripcion) {
        Aula aula = buscar(descripcionAnterior);
        if (aula != null) {
            int posicion = listaAula.indexOf(aula);
            aula.setDescripcion(descripcion);
            listaAula.set(posicion, aula);
            return true;
        }
        return false;
    }

    public boolean eliminar(String descripcion) {
        return listaAula.remove(buscar(descripcion));
    }

    //public boolean agregarGrupo(Grupo grupo) {
      //  return seleccionado.getListadoGrupo().add(grupo);
    //}

    public List<Aula> getListaAula() {
        return listaAula;
    }

    public void setListaAula(List<Aula> listaAula) {
        this.listaAula = listaAula;
    }

    public Aula getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Aula seleccionado) {
        this.seleccionado = seleccionado;
    }

}
    

