package TeoriaFP.fase03.practica01;

public class Article {
	String code;
	String title;
	int pages;
	byte type;
	String autor;
	
	public Article(String code, String title) {
		this.code = code;
		this.title = title;
		this.type = 0;
	}

	public Article(String code, String title, int pages, String autor) {
		this.code = code;
		this.title = title;
		this.pages = pages;
		this.type = 0;
		this.autor = autor;
	}

	public Article(String title) {
		this.title = title;
		this.type = 0;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}
	
	
}