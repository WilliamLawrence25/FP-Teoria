
public class Espadachin extends Soldado {
	//ATRIBUTOS
	private static String tipoSoldado = "Espadachin";
	private int longitudDeEspada;
	//CONSTRUCTORES
	public Espadachin(String nombre, int nivelAtaque, int nivelVida, int longitudDeEspada, String equipo) {
		super(nombre, nivelAtaque, nivelVida, equipo);
		this.longitudDeEspada = longitudDeEspada;
	}
	
	public String toString() {
        return "Espadachin "+
				"nombre "   + getNombre() +
				"\tAtaque " + getNivelAtaque() +
				"\tVida   " + getNivelVida() +
				"\tcolumna "+ getColumna() +
				"\tfila   " + getFila() +
				"\tequipo " + getEquipo() +
                "\tlongitudDeEspada" + longitudDeEspada;
    }
	
	//GETTER Y SETTER
	public int getLongitudDeEspada() {
		return longitudDeEspada;
	}
	public void setLongitudDeEspada(int longitudDeEspada) {
		this.longitudDeEspada = longitudDeEspada;
	}
	
	//METODOS
	public static void crearMuroDeEscudos() {
		
	}
}