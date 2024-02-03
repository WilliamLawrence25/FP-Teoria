 
public class Lancero extends Soldado {
	//ATRIBUTOS
	private int longitudDeLanza;
	private String tipoSoldado = "Lancero";
	//CONSTRUCTORES
	public Lancero(String nombre, int nivelAtaque, int nivelVida, int longitudDeLanza, String equipo) {
		super(nombre, nivelAtaque, nivelVida, equipo);
		this.longitudDeLanza = longitudDeLanza;
	}
	
	public String toString() {
        return "Lancero    "+
				"nombre "   + getNombre() +
				"\tAtaque " + getNivelAtaque() +
				"\tVida   " + getNivelVida() +
				"\tcolumna "+ getColumna() +
				"\tfila   " + getFila() +
				"\tequipo " + getEquipo() +
                "\tlongitudDeLanza " + longitudDeLanza;
    }
	
	//GETTERS Y SETTERS
	public int getLongitudDeLanza() {
		return longitudDeLanza;
	}
	public void setLongitudDeLanza(int longitudDeLanza) {
		this.longitudDeLanza = longitudDeLanza;
	}
	public String getTipoSoldado() {
		return tipoSoldado;
	}	
	
	//METODOS
	public void schilltrom() {
	
	}
	
}
