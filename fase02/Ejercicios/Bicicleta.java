package TeoriaFP.fase02.Ejercicios;

public class Bicicleta {
  private int diasPrestamo;
  private String dueno;

  public Bicicleta(int dias, String d){
    this.diasPrestamo=dias;
    this.dueno=d;
  }
  public int getDias(){
    return this.diasPrestamo;
  }
  public String getDueno(){
    return this.dueno;
  }
  
}
