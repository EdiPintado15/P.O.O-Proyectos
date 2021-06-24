package modelo;
public class Linea {
    private long codigoLinea;
    private double puntoOrigenX;
    private double puntoOrigenY;
    private double puntoFinalX;
    private double puntoFinalY;
    private double longitud;

    public Linea() {
    }

    public Linea(long codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    
    
    

    public Linea(long codigoLinea, double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY, double longitud) {
        this.codigoLinea = codigoLinea;
        this.puntoOrigenX = puntoOrigenX;
        this.puntoOrigenY = puntoOrigenY;
        this.puntoFinalX = puntoFinalX;
        this.puntoFinalY = puntoFinalY;
        this.longitud = longitud;
    }

    public long getCodigoLinea() {
        return codigoLinea;
    }

    public void setCodigoLinea(long codigoLinea) {
        this.codigoLinea = codigoLinea;
    }

    public double getPuntoOrigenX() {
        return puntoOrigenX;
    }

    public void setPuntoOrigenX(double puntoOrigenX) {
        this.puntoOrigenX = puntoOrigenX;
    }

    public double getPuntoOrigenY() {
        return puntoOrigenY;
    }

    public void setPuntoOrigenY(double puntoOrigenY) {
        this.puntoOrigenY = puntoOrigenY;
    }

    public double getPuntoFinalX() {
        return puntoFinalX;
    }

    public void setPuntoFinalX(double puntoFinalX) {
        this.puntoFinalX = puntoFinalX;
    }

    public double getPuntoFinalY() {
        return puntoFinalY;
    }

    public void setPuntoFinalY(double puntoFinalY) {
        this.puntoFinalY = puntoFinalY;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.codigoLinea ^ (this.codigoLinea >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.puntoOrigenX) ^ (Double.doubleToLongBits(this.puntoOrigenX) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.puntoOrigenY) ^ (Double.doubleToLongBits(this.puntoOrigenY) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.puntoFinalX) ^ (Double.doubleToLongBits(this.puntoFinalX) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.puntoFinalY) ^ (Double.doubleToLongBits(this.puntoFinalY) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.longitud) ^ (Double.doubleToLongBits(this.longitud) >>> 32));
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
        final Linea other = (Linea) obj;
        if (this.codigoLinea != other.codigoLinea) {
            return false;
        }
        if (Double.doubleToLongBits(this.puntoOrigenX) != Double.doubleToLongBits(other.puntoOrigenX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.puntoOrigenY) != Double.doubleToLongBits(other.puntoOrigenY)) {
            return false;
        }
        if (Double.doubleToLongBits(this.puntoFinalX) != Double.doubleToLongBits(other.puntoFinalX)) {
            return false;
        }
        if (Double.doubleToLongBits(this.puntoFinalY) != Double.doubleToLongBits(other.puntoFinalY)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitud) != Double.doubleToLongBits(other.longitud)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Linea{" + "codigoLinea=" + codigoLinea + ", puntoOrigenX=" + puntoOrigenX + ", puntoOrigenY=" + puntoOrigenY + ", puntoFinalX=" + puntoFinalX + ", puntoFinalY=" + puntoFinalY + ", longitud=" + longitud + '}';
    }
}
