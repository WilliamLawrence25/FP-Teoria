//Choquehuanca Berna William Herderson
package TeoriaFP.fase02.trabajo02;

import java.util.*;
class Soldado{
  private String nombre;
  private int vida;
  private int fila;
  private int columna;
  public void setNombre(String n){
    nombre=n;
  }
  public void setVida(int v){
    vida=v;
  }
  public void setFila(int f){
    fila = f;
  }
  public void setColumna(int c){
    columna = c;
  }
  public String getNombre(){
    return nombre;  
  }
  public int getVida(){
    return vida;
  }
  public int getFila(){
    return fila;
  }
  public int getColumna(){
    return columna;
  }
}
public class Pract02 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    Random random=new Random();
    Soldado[][] ejercito1=crearEjercito("A", 10, random);
    Soldado[][] ejercito2=crearEjercito("B", 10, random);
    mostrarTablero(ejercito1);
    mostrarTablero(ejercito2);
    // Enfrentar los ejércitos
    enfrentarEjercitos(ejercito1, ejercito2);
    System.out.println("\nGana el ejercito con mas soldados vivos, en caso de empate gana el ejercito con mas vida");
    // Calcular al ganador
    calcularGanador(ejercito1, ejercito2);

    // Mostrar el tablero final
    mostrarTablero(ejercito1);
    mostrarTablero(ejercito2);


    sc.close();
  }
  public static Soldado[][] crearEjercito(String m, int length, Random random){
    Soldado[] soldados=new Soldado[random.nextInt(6)+5];
    Soldado[][] tablero=new Soldado[10][10];
    String nombre;
    int vida, fila, columna;
    for(int i=0; i<soldados.length; i++){
      nombre=m+(i);
      vida=random.nextInt(5)+1;
      do{ 
        fila=random.nextInt(10);
        columna=random.nextInt(10);
      }while(tablero[fila][columna]!=null);
      soldados[i]=new Soldado();
      soldados[i].setNombre(nombre);
      soldados[i].setVida(vida);
      soldados[i].setFila(fila);
      soldados[i].setColumna(columna);
      tablero[fila][columna]=soldados[i];
    }
    return tablero;
  } 
  public static void mostrarTablero(Soldado[][] tablero){
    System.out.print(" _____________________________\n");
    for (int i = 0; i < tablero.length; i++) {
      for (int j = 0; j < tablero[i].length; j++) {
          if (tablero[i][j] == null) {
            System.out.print("|__");
          } else {
              System.out.print("|" + tablero[i][j].getNombre() + "");
          }
      }
      System.out.println("|");
    }
  }
  public static void enfrentarEjercitos(Soldado[][] ejercito1, Soldado[][] ejercito2) {
    for (int i = 0; i < ejercito1.length; i++) {
      for (int j = 0; j < ejercito1[i].length; j++) {
        Soldado soldado1 = ejercito1[i][j];
        Soldado soldado2 = ejercito2[i][j];

        if (soldado1 != null && soldado2 != null) {
          if (soldado1.getVida() > soldado2.getVida()) {
            soldado1.setVida(soldado1.getVida() - soldado2.getVida());
            ejercito2[i][j] = null;
          } else if (soldado1.getVida() < soldado2.getVida()) {
            soldado2.setVida(soldado2.getVida() - soldado1.getVida());
            ejercito1[i][j] = null;
          } else {
            ejercito1[i][j] = null;
            ejercito2[i][j] = null;
          }
        }
      }
    }
  }
  public static void calcularGanador(Soldado[][] ejercito1, Soldado[][] ejercito2) {
    int sobrevivientes1 = 0;
    int sobrevivientes2 = 0;
    int totalVida1 = 0;
    int totalVida2 = 0;
    for (int i = 0; i < ejercito1.length; i++) {
      for (int j = 0; j < ejercito1[i].length; j++) {
        if (ejercito1[i][j] != null) {
          sobrevivientes1++;
          totalVida1 += ejercito1[i][j].getVida();
        }
        if (ejercito2[i][j] != null) {
          sobrevivientes2++;
          totalVida2 += ejercito2[i][j].getVida();
        }
      }
    }
    if (sobrevivientes1 > sobrevivientes2 || (sobrevivientes1 == sobrevivientes2 && totalVida1 > totalVida2)) {
      System.out.println("\nGana ejercito 1");;
    } else if (sobrevivientes2 > sobrevivientes1 || (sobrevivientes2 == sobrevivientes1 && totalVida2 > totalVida1)) {
      System.out.println("\nGana ejercito 2");;
    }
  }
}
