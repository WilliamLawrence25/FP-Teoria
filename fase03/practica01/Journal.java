package TeoriaFP.fase03.practica01;

public class Journal extends Article {
	
	public Journal(String title) {
		super(title);
		super.setType((byte) 3);
	}
	
	public Journal(String code, String title, int pages, String autor) {
		super(code,title,pages, autor);
		super.setType((byte) 3);
	}
	
}