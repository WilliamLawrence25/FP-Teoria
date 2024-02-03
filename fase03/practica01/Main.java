package TeoriaFP.fase03.practica01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        ArrayList<Article> c1 = new ArrayList<>();
        ArrayList<Article> c2 = new ArrayList<>();
        ArrayList<Article> c3 = new ArrayList<>();

        c1.add(new Book("BOOK-DBMS-01", "Fundamentos de Bases de Datos Modernas", 300, "Fernandez Anderson"));
        c2.add(new Book("BOOK-ALGO-02", "Algoritmos y Estructuras de Datos", 400, "Gomez Martinez"));
        c3.add(new Book("BOOK-ML-03", "Conceptos y Aplicaciones de Aprendizaje Automático", 500, "Rodriguez Lopez"));
        c1.add(new Book("BOOK-DS-04", "Manual de Ciencia de Datos", 450, "Smith John"));
        c2.add(new Book("BOOK-SE-05", "Principios de Ingeniería de Software", 350, "Garcia Maria"));
        c3.add(new Book("BOOK-DB-06", "Sistemas de Bases de Datos", 320, "Rodriguez Lopez"));
        c1.add(new Book("BOOK-OS-07", "Diseño de Sistemas Operativos", 280, "Fernandez Anderson"));
        c2.add(new Book("BOOK-AI-08", "Conceptos Esenciales de Inteligencia Artificial", 420, "Smith John"));
        c3.add(new Book("BOOK-NET-09", "Fundamentos de Redes", 380, "Garcia Maria"));
        c1.add(new Book("BOOK-WEB-10", "Principios Básicos de Desarrollo Web", 320, "Fernandez Anderson"));
        c2.add(new Book("BOOK-SEC-11", "Introducción a la Ciberseguridad", 300, "Gomez Martinez"));
        c3.add(new Book("BOOK-ROBOT-12", "Robótica: Principios y Aplicaciones", 450, "Rodriguez Lopez"));
        c1.add(new Book("BOOK-APP-13", "Desarrollo de Aplicaciones Móviles", 350, "Smith John"));
        c2.add(new Book("BOOK-DBA-14", "Guía de Administración de Bases de Datos", 400, "Garcia Maria"));
        c3.add(new Book("BOOK-ML-15", "Técnicas Avanzadas de Aprendizaje Profundo", 550, "Rodriguez Lopez"));
        c1.add(new Book("BOOK-ROCKET-16", "Principios Básicos de Ciencia de Cohetes", 280, "Fernandez Anderson"));
        c2.add(new Book("BOOK-VR-17", "Realidad Virtual: Una Guía Completa", 420, "Smith John"));
        c3.add(new Book("BOOK-IOT-18", "Manual del Internet de las Cosas", 380, "Garcia Maria"));
        c1.add(new Book("BOOK-CLOUD-19", "Conceptos Básicos de Computación en la Nube", 300, "Fernandez Anderson"));
        c2.add(new Book("BOOK-UX-20", "Diseño de Experiencia de Usuario", 320, "Gomez Martinez"));

		Sucursal s1 = new Sucursal(c1.size(), 01, "Sucursal 01", "Arequipa");
		s1.setEjemplares(c1);
        Sucursal s2 = new Sucursal(c2.size(), 02, "Sucursal 02", "Arequipa");
		s2.setEjemplares(c2);
		Sucursal s3 = new Sucursal(c3.size(), 03, "Sucursal 03", "Arequipa");
		s3.setEjemplares(c3);
		

		System.out.println("BIBLIOTECA DEEPBOOKS");
		System.out.println("Seleccione: \n1. Ejemplares por sucursal\n2. Informacion de sucursal\n3. Buscar por autores");

		int opcion = sc.nextInt();

		switch (opcion) {
			case 1:
				System.out.println("Seleccione el Nro de sucursal (1, 2, 3): ");
				int s = sc.nextInt();
				if(s == 1){
					System.out.println("La sucursal tiene " + c1.size() + " ejemplares.");
				}if(s == 2){
					System.out.println("La sucursal tiene " + c2.size() + " ejemplares.");
				}if(s == 3){
					System.out.println("La sucursal tiene " + c3.size() + " ejemplares.");
				}
				break;
			case 2:
				System.out.println("Seleccione el Nro de sucursal (1, 2, 3): ");
				int ss = sc.nextInt();
				if (ss == 1) {s1.mostrarInformacion();}
				if (ss == 2) {s2.mostrarInformacion();}
				if (ss == 3) {s3.mostrarInformacion();}
				break;
			case 3:
				// Lógica para Buscar por autores
				break;
			case 0:
				System.out.println("Saliendo del programa. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
				break;
		}

	}
	
	

}