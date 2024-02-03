package TeoriaFP.fase03.practica01;

public class Book extends Article {
	String ISBN;
	
	
	public Book(String title) {
		super(title);
		super.setType((byte) 1);
	}
	
	public Book(String code, String title, int pages, String autor) {
		super(code,title,pages, autor);
		super.setType((byte) 1);
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
		
}