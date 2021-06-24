package modelo;
public class DibujoPlanoGeneral {
    private long codigoDibujoPlanoGeneral;
    private int numeroFiguras;

    public DibujoPlanoGeneral() {
    }

    public DibujoPlanoGeneral(long codigoDibujoPlanoGeneral) {
        this.codigoDibujoPlanoGeneral = codigoDibujoPlanoGeneral;
    }
    
    

    public DibujoPlanoGeneral(long codigoDibujoPlanoGeneral, int numeroFiguras) {
        this.codigoDibujoPlanoGeneral = codigoDibujoPlanoGeneral;
        this.numeroFiguras = numeroFiguras;
    }

    public long getCodigoDibujoPlanoGeneral() {
        return codigoDibujoPlanoGeneral;
    }

    public void setCodigoDibujoPlanoGeneral(long codigoDibujoPlanoGeneral) {
        this.codigoDibujoPlanoGeneral = codigoDibujoPlanoGeneral;
    }

    public int getNumeroFiguras() {
        return numeroFiguras;
    }

    public void setNumeroFiguras(int numeroFiguras) {
        this.numeroFiguras = numeroFiguras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.codigoDibujoPlanoGeneral ^ (this.codigoDibujoPlanoGeneral >>> 32));
        hash = 31 * hash + this.numeroFiguras;
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
        final DibujoPlanoGeneral other = (DibujoPlanoGeneral) obj;
        if (this.codigoDibujoPlanoGeneral != other.codigoDibujoPlanoGeneral) {
            return false;
        }
        if (this.numeroFiguras != other.numeroFiguras) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DibujoPlanoGeneral{" + "codigoDibujoPlanoGeneral=" + codigoDibujoPlanoGeneral + ", numeroFiguras=" + numeroFiguras + '}';
    }
    
    
}
