package modelo;

import java.util.List;
import java.util.Objects;

public class Proyecto {
    private long codigoProyecto;
    private String nombreProyecto;
    private JefeProyecto jefeProyecto;
    private List<Plano> listaPlanos; 

    public Proyecto() {
    }

    public Proyecto(long codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }
    
    

    public Proyecto(long codigoProyecto, String nombreProyecto, JefeProyecto jefeProyecto, List<Plano> listaPlanos) {
        this.codigoProyecto = codigoProyecto;
        this.nombreProyecto = nombreProyecto;
        this.jefeProyecto = jefeProyecto;
        this.listaPlanos = listaPlanos;
    }

    public long getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(long codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public JefeProyecto getJefeProyecto() {
        return jefeProyecto;
    }

    public void setJefeProyecto(JefeProyecto jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public List<Plano> getListaPlanos() {
        return listaPlanos;
    }

    public void setListaPlanos(List<Plano> listaPlanos) {
        this.listaPlanos = listaPlanos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.codigoProyecto ^ (this.codigoProyecto >>> 32));
        hash = 97 * hash + Objects.hashCode(this.nombreProyecto);
        hash = 97 * hash + Objects.hashCode(this.jefeProyecto);
        hash = 97 * hash + Objects.hashCode(this.listaPlanos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proyecto other = (Proyecto) obj;
        if (this.codigoProyecto != other.codigoProyecto) {
            return false;
        }
        if (!Objects.equals(this.nombreProyecto, other.nombreProyecto)) {
            return false;
        }
        if (!Objects.equals(this.jefeProyecto, other.jefeProyecto)) {
            return false;
        }
        if (!Objects.equals(this.listaPlanos, other.listaPlanos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "codigoProyecto=" + codigoProyecto + ", nombreProyecto=" + nombreProyecto + ", jefeProyecto=" + jefeProyecto + ", listaPlanos=" + listaPlanos + '}';
    }
    
    
    
    
    
}
