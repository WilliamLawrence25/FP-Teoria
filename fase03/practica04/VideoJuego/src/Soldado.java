public class Soldado {
	
	//Atributos
	private String nombre;  //Soldado
	private int nivelAtaque;//[1...5]
	private int nivelVida;  //[1...5]
	private int vidaActual; //igual nivel de vida
	private int velocidad;  //
	private int defensa;

	private String actitud; //defensa, ofensa, fuga
	private boolean vive;

    private int columna;
    private int fila;
	private String equipo;

	
	//Constructor completo pelea entre 2 ejercitos
	public Soldado(String nombre, int nivelAtaque, int nivelVida, int columna, int fila, String equipo) {
		this.nombre = nombre;
		this.nivelAtaque = nivelAtaque;
		this.nivelVida = nivelAtaque;
		this.vidaActual = nivelVida;
		this.velocidad = 0;
		this.vive = true;

        this.columna = columna;
        this.fila = fila;
        this.equipo = equipo;

	}

	//Constructor completo pelea entre 2 reinos	
	public Soldado(String nombre, int nivelAtaque, int nivelVida, String equipo) {
		this.nombre = nombre;
		this.nivelAtaque = nivelAtaque;
		this.nivelVida = nivelAtaque;
		this.vidaActual = nivelVida;

        this.equipo = equipo;
	}
    
    //nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}


	//nivelAtaque
	public void setNivelAtaque(int nivelAtaque) {
		this.nivelAtaque = nivelAtaque;
	}
	public int getNivelAtaque() {
		return nivelAtaque;
	}


    //defensa
	public void setDefensa(int defensa){
		this.defensa = defensa;
	}
	public int getDefensa(){
		return this.defensa;
	}

	//nivelVida
	public void setNivelVida(int nivelVida) {
		this.nivelVida = nivelVida;
	}
	public int getNivelVida() {
		return nivelVida;
	}


	//vidaActual
	public void setVidaActual(int vidaActual) {	
		this.vidaActual += vidaActual;
		this.nivelVida = this.vidaActual;
	}
	public int getVidaActual() {	
		return nivelVida;
	}


	//velocidad
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getVelocidad() {
		return velocidad;
	}


	//actitud
	public void setActitud(String actitud) {
		switch(actitud) {
			case "defensiva" : this.velocidad = 0; break;
			case "ofensiva" : this.velocidad++; break;
			case "fuga" : this.velocidad += 2; break;
		}
		this.actitud = actitud;
	}
	public String getActitud() {
		return actitud;
	}


	//vive
	public void setVive(boolean vive) {
		this.vive = vive;
	}
    public boolean Vive() {
        return vive;
	}

    //--columna y fila
    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }

    //--equipo
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

	public void atacar() {
		setActitud("ofensiva");
	}
	public void defender() {
		setActitud("defensiva");
	}
	public void avanzar() {
		this.velocidad += 1;
	}
	public void retroceder() {
		if (this.velocidad > 0) {
			this.velocidad = 0;
			this.actitud = "defensiva";
		} else {
			this.velocidad -= 1;
			this.actitud = "fuga";
		}
	}
	public void serAtacado() {
		this.vidaActual -= 1;//vida actual disminuyendo
	}
	public void huir() {
		this.velocidad += 2;
	}
	public void morir() {
		this.velocidad = 0;
	}
}