package TeoriaFP.fase03.practica01;

public class Thesis extends Article {
	
	
	public Thesis(String title) {
		super(title);
		super.setType((byte) 2);
	}
	
	public Thesis(String code, String title, int pages, String autor) {
		super(code,title,pages, autor);
		super.setType((byte) 2);
	}
	
	
}