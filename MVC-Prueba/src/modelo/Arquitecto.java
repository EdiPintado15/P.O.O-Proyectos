package modelo;

import java.util.Objects;

public class Arquitecto {
    private long codigoArquitecto;
    private String nombreArquitecto;
    private String cedulaArquitecto;

    public Arquitecto() {
    }

    public Arquitecto(String cedulaArquitecto) {
        this.cedulaArquitecto = cedulaArquitecto;
    }

    public Arquitecto(long codigoArquitecto, String nombreArquitecto, String cedulaArquitecto) {
        this.codigoArquitecto = codigoArquitecto;
        this.nombreArquitecto = nombreArquitecto;
        this.cedulaArquitecto = cedulaArquitecto;
    }

    public long getCodigoArquitecto() {
        return codigoArquitecto;
    }

    public void setCodigoArquitecto(long codigoArquitecto) {
        this.codigoArquitecto = codigoArquitecto;
    }

    public String getNombreArquitecto() {
        return nombreArquitecto;
    }

    public void setNombreArquitecto(String nombreArquitecto) {
        this.nombreArquitecto = nombreArquitecto;
    }

    public String getCedulaArquitecto() {
        return cedulaArquitecto;
    }

    public void setCedulaArquitecto(String cedulaArquitecto) {
        this.cedulaArquitecto = cedulaArquitecto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.codigoArquitecto ^ (this.codigoArquitecto >>> 32));
        hash = 97 * hash + Objects.hashCode(this.nombreArquitecto);
        hash = 97 * hash + Objects.hashCode(this.cedulaArquitecto);
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
        final Arquitecto other = (Arquitecto) obj;
        if (this.codigoArquitecto != other.codigoArquitecto) {
            return false;
        }
        if (!Objects.equals(this.nombreArquitecto, other.nombreArquitecto)) {
            return false;
        }
        if (!Objects.equals(this.cedulaArquitecto, other.cedulaArquitecto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Arquitecto{" + "codigoArquitecto=" + codigoArquitecto + ", nombreArquitecto=" + nombreArquitecto + ", cedulaArquitecto=" + cedulaArquitecto + '}';
    }
    
    
}
