package TeoriaFP.fase03.practica01;

public class Graduate extends User {
	
	String finishYear;
	
	public Graduate(String name) {
		super(name);
	}
	
	public String getFinishYear() {
		return finishYear;
	}

	public void setFinishYear(String finishYear) {
		this.finishYear = finishYear;
	}		
	
}