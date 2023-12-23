//Interfaz Hidroavion
interface Hidroavion {
    void despegar();
    void aterrizar();
    
}
class Barco{
    public void despegar(){
        System.out.println("Barco desplegado");
    }
    public void aterrizar(){
        System.out.println("Barco aterrizado");
    }
}
class Avion{
    public void despegar(){
        System.out.println("Avion despegado");
    }
    public void aterrizado(){
        System.out.println("Avion aterrizado");
    }
}
public class Ejercicio3{
    public static void main(String[] args) {
        Avion avion = new Avion();
        Barco barco = new Barco();

        //Pruebas
        avion.despegar();
        avion.aterrizado();

        barco.despegar();
        barco.aterrizar();
    }
}