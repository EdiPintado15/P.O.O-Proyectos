package modelo;

import java.util.Objects;

public class JefeProyecto {
    private long codigoJefeProyecto;
    private String nombreJefeProyecto;
    private String direccionJefeProyecto;
    private String telefonoJefeProyecto;
    private String cedulaJefeProyecto;

    public JefeProyecto() {
    }

    public JefeProyecto(String nombreJefeProyecto, String direccionJefeProyecto, String telefonoJefeProyecto, String cedulaJefeProyecto) {
        this.nombreJefeProyecto = nombreJefeProyecto;
        this.direccionJefeProyecto = direccionJefeProyecto;
        this.telefonoJefeProyecto = telefonoJefeProyecto;
        this.cedulaJefeProyecto = cedulaJefeProyecto;
    }

    public JefeProyecto(String cedulaJefeProyecto) {
        this.cedulaJefeProyecto = cedulaJefeProyecto;
    }
    
    
    
    

    public JefeProyecto(long codigoJefeProyecto, String nombreJefeProyecto, String direccionJefeProyecto, String telefonoJefeProyecto, String cedulaJefeProyecto) {
        this.codigoJefeProyecto = codigoJefeProyecto;
        this.nombreJefeProyecto = nombreJefeProyecto;
        this.direccionJefeProyecto = direccionJefeProyecto;
        this.telefonoJefeProyecto = telefonoJefeProyecto;
        this.cedulaJefeProyecto = cedulaJefeProyecto;
    }

    public long getCodigoJefeProyecto() {
        return codigoJefeProyecto;
    }

    public void setCodigoJefeProyecto(long codigoJefeProyecto) {
        this.codigoJefeProyecto = codigoJefeProyecto;
    }

    public String getNombreJefeProyecto() {
        return nombreJefeProyecto;
    }

    public void setNombreJefeProyecto(String nombreJefeProyecto) {
        this.nombreJefeProyecto = nombreJefeProyecto;
    }

    public String getDireccionJefeProyecto() {
        return direccionJefeProyecto;
    }

    public void setDireccionJefeProyecto(String direccionJefeProyecto) {
        this.direccionJefeProyecto = direccionJefeProyecto;
    }

    public String getTelefonoJefeProyecto() {
        return telefonoJefeProyecto;
    }

    public void setTelefonoJefeProyecto(String telefonoJefeProyecto) {
        this.telefonoJefeProyecto = telefonoJefeProyecto;
    }

    public String getCedulaJefeProyecto() {
        return cedulaJefeProyecto;
    }

    public void setCedulaJefeProyecto(String cedulaJefeProyecto) {
        this.cedulaJefeProyecto = cedulaJefeProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (this.codigoJefeProyecto ^ (this.codigoJefeProyecto >>> 32));
        hash = 47 * hash + Objects.hashCode(this.nombreJefeProyecto);
        hash = 47 * hash + Objects.hashCode(this.direccionJefeProyecto);
        hash = 47 * hash + Objects.hashCode(this.telefonoJefeProyecto);
        hash = 47 * hash + Objects.hashCode(this.cedulaJefeProyecto);
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
        final JefeProyecto other = (JefeProyecto) obj;
        if (this.codigoJefeProyecto != other.codigoJefeProyecto) {
            return false;
        }
        if (!Objects.equals(this.nombreJefeProyecto, other.nombreJefeProyecto)) {
            return false;
        }
        if (!Objects.equals(this.direccionJefeProyecto, other.direccionJefeProyecto)) {
            return false;
        }
        if (!Objects.equals(this.telefonoJefeProyecto, other.telefonoJefeProyecto)) {
            return false;
        }
        if (!Objects.equals(this.cedulaJefeProyecto, other.cedulaJefeProyecto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JefeProyecto{" + "codigoJefeProyecto=" + codigoJefeProyecto + ", nombreJefeProyecto=" + nombreJefeProyecto + ", direccionJefeProyecto=" + direccionJefeProyecto + ", telefonoJefeProyecto=" + telefonoJefeProyecto + ", cedulaJefeProyecto=" + cedulaJefeProyecto + '}';
    }
    
    
}
