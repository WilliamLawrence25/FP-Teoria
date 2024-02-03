import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercito {
    public  List<Soldado> personajes = new ArrayList<>();
    private String reino;
    private boolean vive;

    private int velocidad;
    private int columna = -1;
    private int fila   = -1 ;

    public Ejercito(String reino){ //guerra entre 2 ejercitos
        this.reino = reino;
        this.vive = true;
        crearEjercito(this.reino);
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }
    public int getColumna() {
        return columna;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getFila() {
        return fila;
    }
    public List<Soldado> getEjercito(){
        return personajes;
    }
    public String getReino(){
        return reino;
    }
    public void setVive(boolean vive) {
        if(vive == false){
            this.columna = -1;
            this.fila = -1;
        }
        this.vive = vive;
    }
    public boolean vive() {
        return vive;
    }
    


    //          ----- Creando ejercito por reinos
    public void crearEjercito(String reino){
        int cantidadSoldados = (int) (Math.random() * 10 + 1); // Número aleatorio de personajes en un ejercito
        for (int i = 0; i < cantidadSoldados; i++) {  //-------------------------------------------------------------------------cambiar luego a random pnj
            int tipo = (int) (Math.random() * 4 + 1);
            crearPersonaje(tipo, reino, i);
        }
    }
    //    -----   Todo hacerca de crear a un soldado   ----- 
    public void crearPersonaje(int tipo, String equipo, int i){
        int ataque = (int)(Math.random() * 5 + 1);
        int vida = (int)(Math.random() * 5 + 1);
        switch (tipo) {
            case 1: personajes.add(  arquero(   equipo,  i)  );        break;
            case 2: personajes.add(  caballero( equipo,  i)  );        break;
            case 3: personajes.add(  espadachin(equipo,  i)  );        break;
            case 4: personajes.add(  lancero(   equipo,  i)  );        break;
            default:   System.out.println("Error: no se creo el presonaje en Ejercito");    break;
        }
    }
    public Arquero arquero(String equipo, int i){
        Arquero a = new   Arquero    ("Arquero____" + i + equipo, 7 , (int)(Math.random() * 3 + 3), (int)(Math.random() * 5 + 1), equipo);
        return a;}
    public Caballero caballero(String equipo,  int i){
        Caballero a = new  Caballero ("caballero__" + i + equipo, 13, (int)(Math.random() * 3 + 10), equipo);
        return a;}
    public Espadachin espadachin(String equipo, int i){
        Espadachin a = new Espadachin("espadachin_" + i + equipo, 10, (int)(Math.random() * 3 + 8), (int)(Math.random() * 5 + 1), equipo);
        return a;}
    public Lancero lancero(String equipo,  int i){
        Lancero a = new   Lancero    ("lancero____" + i + equipo, 5 , (int)(Math.random() * 4 + 5), (int)(Math.random() * 5 + 1), equipo);
        return a;}

    public String toString(){
        String a = "";
        for (int i = 0; i < personajes.size(); i++) {
            a = a + personajes.get(i).toString() + "\n";
        }
        return a;
    }

    public Soldado buscarSoldado(String nombre){
        for (Soldado personaje : personajes) {
            if (compararNombre(nombre, personaje)) {
                return personaje;
            }
        }
        System.out.println("No se encontro ningun soldado llamado asi");
        return null;
    }
    public boolean compararNombre(String nombre, Soldado pnj){
        return pnj.getNombre().equalsIgnoreCase(nombre);
    }

    // Funcion 1
    public void crearSoldado(int tipo) {
        crearPersonaje(tipo, reino, personajes.size() + 1);
    }
    // Función 2
    public void eliminarSoldado(String nombre) {
        personajes.remove(buscarSoldado(nombre));
    }
    // Función 3
    public void clonarSoldado(String nombre) {
        Soldado pnj = buscarSoldado(nombre);
        if (pnj instanceof Arquero) {
            personajes.add(new    Arquero(pnj.getNombre(), pnj.getNivelVida() , pnj.getNivelAtaque(), (int)(Math.random() * 5 + 1), reino));
        } else if (pnj instanceof Caballero) {
            personajes.add(new  Caballero(pnj.getNombre(), pnj.getNivelVida() , pnj.getNivelAtaque(), reino));
        } else if (pnj instanceof Espadachin) {
            personajes.add(new Espadachin(pnj.getNombre(), pnj.getNivelVida() , pnj.getNivelAtaque(), (int)(Math.random() * 5 + 1), reino));
        } else if (pnj instanceof Lancero) {
            personajes.add(new    Lancero(pnj.getNombre(), pnj.getNivelVida() , pnj.getNivelAtaque(), (int)(Math.random() * 5 + 1), reino));
        } else{
            System.out.println("no pudo clonar ningun personaje");
        }
    }
    // Función 4 
    public void modificarSoldado(String nombre) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar datos:");
        System.out.println("Ataque:");
        int ataque = sc.nextInt();
        System.out.println("Vida  :");
        int vida   = sc.nextInt();
        for (int i = 0; i < personajes.size(); i++) {
            if (compararNombre(nombre, personajes.get(i))) {
                personajes.get(i).setNivelAtaque(ataque);
                personajes.get(i).setNivelVida(vida);
            }
        }
    }

    // Función 5
    public boolean compararSoldados(String name1, String name2) {
        Soldado pnj1 = buscarSoldado(name1);
        Soldado pnj2 = buscarSoldado(name2);
        if (pnj1.getClass() == pnj2.getClass())
            return (pnj1.getNivelAtaque() == pnj2.getNivelAtaque())&&(pnj1.getNivelVida() == pnj2.getNivelVida())&&(pnj1.Vive() == pnj2.Vive())&&(pnj1.getDefensa() == pnj2.getDefensa());
        return false;
    }
    // Función 6
    public void intercambiarSoldados(Soldado uno, Soldado dos) {
        int x = uno.getColumna();
        int y = uno.getFila();
        uno.setColumna(dos.getColumna());
        uno.setFila(dos.getFila());
        dos.setColumna(x);
        dos.setFila(y);
    }
    // Función 7
    public void verSoldado(String name) {
        Soldado pnj = buscarSoldado(name);
        System.out.println(pnj.toString());
    }
    // Función 8
    public void verEjercito() {
        System.out.println(toString());
    }
    // Función 9
    public int sumarNiveles() {
        int sum = 0;
        for (Soldado soldado : personajes) {
            sum += soldado.getVidaActual();
            sum += soldado.getDefensa();
            sum += soldado.getNivelAtaque();
        }
        return sum;
    }


    public Soldado soldadoEnPosicion(int x, int y){
        for (Soldado soldado : personajes) {
            if (soldado.getColumna() == x  && soldado.getFila() == y) {
                return soldado;
            }
        }
        return null;
    }

    public boolean verificarPosicionLibreSoldado(int x, int y){
        for (Soldado soldado : personajes) {
            if (soldado.getColumna() == x  && soldado.getFila() == y) {
                return true;
            }
        }
        return false;
    }
    //movimientos direccionales en el mapa "x" y "y" es de abajo hacia arriba y de izquierda hacia derecha
    public boolean validaPosicion(int a){
        return (a >= 1 && a <= 10);
    }
    public void alFrente(int i) {
        int x = personajes.get(i).getColumna() + 1;
        if (validaPosicion(x)) 
            personajes.get(i).setColumna(x);
    }
    public void atras(int i) {
        int x = personajes.get(i).getColumna() - 1;
        if (validaPosicion(x)) 
            personajes.get(i).setColumna(x);
    }
    public void izquierda(int i) {
        int y = personajes.get(i).getFila()    + 1;
        if (validaPosicion(y)) 
            personajes.get(i).setColumna(y);
    }
    public void derecha(int i) {
        int y = personajes.get(i).getFila()    - 1;
        if (validaPosicion(y)) 
            personajes.get(i).setColumna(y);
    }
}
