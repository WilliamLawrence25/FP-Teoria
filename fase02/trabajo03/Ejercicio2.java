package TeoriaFP.fase02.trabajo03;

import java.lang.Math;

class Cilindro extends Circulo{
    private double longitud;

    public Cilindro(Punto p, double r, double l){
        super(p, r);
        this.longitud = l;
    }
    //Getters y setters
    public double getLongitud() {
        return this.longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    //Superficie del cilindro
    public double superficie(){
        return Math.PI*Math.pow(radio, 2)*this.longitud;
    }
    public double superficieZero(){
        return 2*this.radio*(this.longitud + this.radio);
    }
}
