package TeoriaFP.fase03.practica01;

public class Teacher extends User {
	
	String speciality;
	
	public Teacher(String name) {
		super(name);
	}
	
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}	
	
}
