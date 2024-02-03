
public class Arquero extends Soldado {
	//ATRIBUTOS
	private int numeroFlechas;
	private static String tipoSoldado = "Arquero"; 



	//constructor
	public Arquero(String nombre, int nivelAtaque, int nivelVida, int velocidad, int columna, int fila, String equipo, int numeroFlechas) {
		super(nombre, nivelAtaque, nivelVida, velocidad, columna, equipo);
		this.numeroFlechas = numeroFlechas;
	}
	public Arquero(String nombre, int nivelAtaque, int nivelVida, int numeroFlechas, String equipo) {
		super(nombre, nivelAtaque, nivelVida, equipo);
		this.numeroFlechas = numeroFlechas;
	}
    public String toString() {
        return "Arquero    "+
                "nombre "   +  getNombre() +
                "\tAtaque " +  getNivelAtaque() +
                "\tVida   " +  getNivelVida() +
                "\tcolumna "+  getColumna() +
                "\tfila   " +  getFila() +
                "\tequipo " +  getEquipo() +
                "\tFlechas "+  numeroFlechas;
    }

	//GETTERS AND SETTERS
	public int getNumeroFlechas() {
		return numeroFlechas;
	}
	public void setNumeroFlechas(int numeroFlechas) {
		this.numeroFlechas = numeroFlechas;
	}
	
	//METODOS
	public void disparar() {
		this.numeroFlechas--;
	}
}
