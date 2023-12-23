import java.lang.Math;

class Punto {
    private double x;
    private double y;

    //Contructor de la clase Punto
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    //Getters y setters
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    //Distancia entre dos puntos
    public double distancia(Punto p1){
        return Math.sqrt(Math.pow(p1.x - this.x, 2) + Math.pow(p1.y - this.y, 2));
    }
}

class Circulo {
    double radio;
    Punto punto;

    //Constructor de la clase Circulo
    public Circulo(Punto p, double r){
        this.punto = p;
        this.radio = r;
    }
    //Getters y setters
    public Punto getPunto() {
        return this.punto;
    }
    public double getRadio() {
        return this.radio;
    }
    public void setPunto(Punto p) {
        this.punto = p;
    }
    public void setRadio(double r) {
        this.radio = r;
    }
}
