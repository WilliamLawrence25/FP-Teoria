
public class Caballero extends Soldado {
	//ATRIBUTOS
	private static String tipoSoldado = "Caballero";
	private boolean espada;
	private boolean lanza;
	private boolean montar;

	//CONSTRUCTOR
	public Caballero(String nombre, int nivelAtaque, int nivelVida,  String equipo) {
		super(nombre, nivelAtaque, nivelVida, equipo);
		this.espada = true;
		this.lanza = false;
		this.montar = false;
	}
	
    public String toString() {
        return "Caballero  "+
                "nombre "   + getNombre() +
                "\tAtaque " + getNivelAtaque() +
                "\tVida   " + getNivelVida() +
				"\tcolumna "+ getColumna() +
                "\tfila   " + getFila() +
                "\tequipo " + getEquipo() +
                "\tespada " + espada +
                "\tlanza  " + lanza +
                "\tmontar " + montar;
    }
	
	//SETTER Y GETTER
	public boolean isEspada() {
		return espada;
	}
	public void setEspada(boolean espada) {
		this.espada = espada;
	}
	public boolean isLanza() {
		return lanza;
	}
	public void setLanza(boolean lanza) {
		this.lanza = lanza;
	}
	public boolean isMontar() {
		return montar;
	}
	public void setMontar(boolean montar) {
		this.montar = montar;
	}
	public String getTipoSoldado() {
		return tipoSoldado;
	}
	//METODOS
	public void desmontar() {
		this.espada = true;
		this.lanza = false;
	}
	public void montar() {
		this.espada = true;
		this.lanza = false;
	}
	public static void envestir() {
		
	}
}
