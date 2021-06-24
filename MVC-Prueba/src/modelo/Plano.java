package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Plano {
    private long codigoPlano;
    private Date fechaEntregaPlano;
    private ArrayList<Arquitecto> listaArquitectos; 
    private DibujoPlanoGeneral dibujoPlanoGeneral;
    private ArrayList<Figura> listaFiguras; 

    public Plano() {
    }

    public Plano(long codigoPlano) {
        this.codigoPlano = codigoPlano;
    }
    
    

    public Plano(long codigoPlano, Date fechaEntregaPlano, ArrayList<Arquitecto> listaArquitectos, DibujoPlanoGeneral dibujoPlanoGeneral, ArrayList<Figura> listaFiguras) {
        this.codigoPlano = codigoPlano;
        this.fechaEntregaPlano = fechaEntregaPlano;
        this.listaArquitectos = listaArquitectos;
        this.dibujoPlanoGeneral = dibujoPlanoGeneral;
        this.listaFiguras = listaFiguras;
    }

    public Plano(long codigoPlano, Date fechaEntregaPlano) {
        this.codigoPlano = codigoPlano;
        this.fechaEntregaPlano = fechaEntregaPlano;
    }
    
    

    public long getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(long codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public Date getFechaEntregaPlano() {
        return fechaEntregaPlano;
    }

    public void setFechaEntregaPlano(Date fechaEntregaPlano) {
        this.fechaEntregaPlano = fechaEntregaPlano;
    }

    public ArrayList<Arquitecto> getListaArquitectos() {
        return listaArquitectos;
    }

    public void setListaArquitectos(ArrayList<Arquitecto> listaArquitectos) {
        this.listaArquitectos = listaArquitectos;
    }

    public DibujoPlanoGeneral getDibujoPlanoGeneral() {
        return dibujoPlanoGeneral;
    }

    public void setDibujoPlanoGeneral(DibujoPlanoGeneral dibujoPlanoGeneral) {
        this.dibujoPlanoGeneral = dibujoPlanoGeneral;
    }

    public ArrayList<Figura> getListaFiguras() {
        return listaFiguras;
    }

    public void setListaFiguras(ArrayList<Figura> listaFiguras) {
        this.listaFiguras = listaFiguras;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.codigoPlano ^ (this.codigoPlano >>> 32));
        hash = 79 * hash + Objects.hashCode(this.fechaEntregaPlano);
        hash = 79 * hash + Objects.hashCode(this.listaArquitectos);
        hash = 79 * hash + Objects.hashCode(this.dibujoPlanoGeneral);
        hash = 79 * hash + Objects.hashCode(this.listaFiguras);
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
        final Plano other = (Plano) obj;
        if (this.codigoPlano != other.codigoPlano) {
            return false;
        }
        if (!Objects.equals(this.fechaEntregaPlano, other.fechaEntregaPlano)) {
            return false;
        }
        if (!Objects.equals(this.listaArquitectos, other.listaArquitectos)) {
            return false;
        }
        if (!Objects.equals(this.dibujoPlanoGeneral, other.dibujoPlanoGeneral)) {
            return false;
        }
        if (!Objects.equals(this.listaFiguras, other.listaFiguras)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plano{" + "codigoPlano=" + codigoPlano + ", fechaEntregaPlano=" + fechaEntregaPlano + ", listaArquitectos=" + listaArquitectos + ", dibujoPlanoGeneral=" + dibujoPlanoGeneral + ", listaFiguras=" + listaFiguras + '}';
    }
}
