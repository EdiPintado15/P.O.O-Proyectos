package modelo;

import java.util.Objects;

public class Figura {
    private long codigoFigura;
    private String nombreFigura;
    private String color;
    private Poligono poligono;

    public Figura() {
    }

    public Figura(long codigoFigura) {
        this.codigoFigura = codigoFigura;
    }
    
    

    public Figura(long codigoFigura, String nombreFigura, String color, Poligono poligono) {
        this.codigoFigura = codigoFigura;
        this.nombreFigura = nombreFigura;
        this.color = color;
        this.poligono = poligono;
    }

    public long getCodigoFigura() {
        return codigoFigura;
    }

    public void setCodigoFigura(long codigoFigura) {
        this.codigoFigura = codigoFigura;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Poligono getPoligono() {
        return poligono;
    }

    public void setPoligono(Poligono poligono) {
        this.poligono = poligono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.codigoFigura ^ (this.codigoFigura >>> 32));
        hash = 37 * hash + Objects.hashCode(this.nombreFigura);
        hash = 37 * hash + Objects.hashCode(this.color);
        hash = 37 * hash + Objects.hashCode(this.poligono);
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
        final Figura other = (Figura) obj;
        if (this.codigoFigura != other.codigoFigura) {
            return false;
        }
        if (!Objects.equals(this.nombreFigura, other.nombreFigura)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.poligono, other.poligono)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Figura{" + "codigoFigura=" + codigoFigura + ", nombreFigura=" + nombreFigura + ", color=" + color + ", poligono=" + poligono + '}';
    }

    
    
}
