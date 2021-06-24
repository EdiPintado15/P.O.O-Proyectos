package modelo;

import java.util.List;
import java.util.Objects;



public class Poligono {
    private long codigoPoligono;
    private int numeroLineasContenidas;
    private Linea LineaForman;
    private double perimetro;
    private  double area;

    public Poligono() {
    }

    public Poligono(long codigoPoligono, int numeroLineasContenidas, Linea LineaForman, double perimetro, double area) {
        this.codigoPoligono = codigoPoligono;
        this.numeroLineasContenidas = numeroLineasContenidas;
        this.LineaForman = LineaForman;
        this.perimetro = perimetro;
        this.area = area;
    }

    public long getCodigoPoligono() {
        return codigoPoligono;
    }

    public void setCodigoPoligono(long codigoPoligono) {
        this.codigoPoligono = codigoPoligono;
    }

    public int getNumeroLineasContenidas() {
        return numeroLineasContenidas;
    }

    public void setNumeroLineasContenidas(int numeroLineasContenidas) {
        this.numeroLineasContenidas = numeroLineasContenidas;
    }

    public Linea getLineaForman() {
        return LineaForman;
    }

    public void setLineaForman(Linea LineaForman) {
        this.LineaForman = LineaForman;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.codigoPoligono ^ (this.codigoPoligono >>> 32));
        hash = 79 * hash + this.numeroLineasContenidas;
        hash = 79 * hash + Objects.hashCode(this.LineaForman);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.perimetro) ^ (Double.doubleToLongBits(this.perimetro) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.area) ^ (Double.doubleToLongBits(this.area) >>> 32));
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
        final Poligono other = (Poligono) obj;
        if (this.codigoPoligono != other.codigoPoligono) {
            return false;
        }
        if (this.numeroLineasContenidas != other.numeroLineasContenidas) {
            return false;
        }
        if (Double.doubleToLongBits(this.perimetro) != Double.doubleToLongBits(other.perimetro)) {
            return false;
        }
        if (Double.doubleToLongBits(this.area) != Double.doubleToLongBits(other.area)) {
            return false;
        }
        if (!Objects.equals(this.LineaForman, other.LineaForman)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Poligono{" + "codigoPoligono=" + codigoPoligono + ", numeroLineasContenidas=" + numeroLineasContenidas + ", LineaForman=" + LineaForman + ", perimetro=" + perimetro + ", area=" + area + '}';
    }

    
    
    

   
    

    
    
    
}
