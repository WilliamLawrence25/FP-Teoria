package TeoriaFP.fase02.trabajo03;

//Interfaz Hidroavion
interface Hidroavion {
    void despegar();
    void aterrizar();
    
}
class Barco implements Hidroavion{
    public void despegar(){
        System.out.println("Barco desplegado");
    }
    public void aterrizar(){
        System.out.println("Barco aterrizado");
    }
}
class Avion implements Hidroavion{
    public void despegar(){
        System.out.println("Avion desplegado");
    }
    public void aterrizar(){
        System.out.println("Avion aterrizado");
    }
}
public class Ejercicio3{
    public static void main(String[] args) {
        Avion avion = new Avion();
        Barco barco = new Barco();

        //Pruebas
        avion.despegar();
        avion.aterrizar();

        barco.despegar();
        barco.aterrizar();
    }
}