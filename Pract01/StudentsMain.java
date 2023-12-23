package TeoriaFP.Pract01;
import java.time.LocalDate;
import java.util.Scanner;

public class StudentsMain {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    /*System.out.println("Ingrese la cantidad de estudiantes: ");
    int numStudents = scanner.nextInt();*/

    Student[] students = new Student[5];

    /*for (int i = 0; i < numStudents; i++) {
        System.out.println("Ingrese datos del estudiante " + (i + 1) + ":");
        scanner.nextLine();
        System.out.print("Primer Nombre: ");
        String firstName = scanner.nextLine();
        System.out.print("Apellido Paterno: ");
        String lastName = scanner.nextLine();
        System.out.print("Año de Nacimiento: ");
        int year = scanner.nextInt();
        System.out.print("Mes de Nacimiento (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Día de Nacimiento: ");
        int day = scanner.nextInt();

        LocalDate dateOfBirth = LocalDate.of(year, month, day);

        students[i] = new Student(firstName, lastName, dateOfBirth);
    }*/
    students[0] = new Student("Juan", "Perez", LocalDate.of(2000, 5, 15));
    students[1] = new Student("Maria", "Gomez", LocalDate.of(1999, 8, 20));
    students[2] = new Student("Carlos", "Lopez", LocalDate.of(2002, 3, 10));
    students[3] = new Student("Laura", "Martinez", LocalDate.of(2001, 7, 5));
    students[4] = new Student("Pedro", "Rodriguez", LocalDate.of(1998, 12, 25));
    
    long startTime = System.nanoTime();
    sortByLastNameInsercion(students);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("\nLista de estudiantes ordenados por Apellido Paterno(Insercion):");
    for (Student student : students) {
        System.out.println(student);
    }
    System.out.println("Tiempo de ordenamiento por Apellido (en nanosegundos): " + duration);

    startTime = System.nanoTime();
    sortByDateOfBirthInsercion(students);
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("\nLista de estudiantes ordenados por Fecha de Nacimiento(Insercion):");
    for (Student student : students) {
        System.out.println(student);
    }
    System.out.println("Tiempo de ordenamiento por Fecha de Nacimiento (en nanosegundos): " + duration);

    startTime = System.nanoTime();
    sortByLastNameBurbuja(students);
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("\nLista de estudiantes ordenados por Apellido Paterno(Burbuja):");
    for (Student student : students) {
        System.out.println(student);
    }
    System.out.println("Tiempo de ordenamiento por Apellido (en nanosegundos): " + duration);

    startTime = System.nanoTime();
    sortByDateOfBirthBurbuja(students);
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("\nLista de estudiantes ordenados por Fecha de Nacimiento(Burbuja):");
    for (Student student : students) {
        System.out.println(student);
    }
    System.out.println("Tiempo de ordenamiento por Fecha de Nacimiento (en nanosegundos): " + duration);
    
    scanner.close();
  }

    public static void sortByLastNameInsercion (Student[] students) {
        int n = students.length;
        for (int i = 1; i < n; i++) {
            Student key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].getLastName().compareTo(key.getLastName()) > 0) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }
    }
    public static void sortByDateOfBirthInsercion(Student[] students) {
      int n = students.length;
      for (int i = 1; i < n; i++) {
          Student key = students[i];
          int j = i - 1;
          while (j >= 0 && students[j].getDateOfBirth().isAfter(key.getDateOfBirth())) {
              students[j + 1] = students[j];
              j = j - 1;
          }
          students[j + 1] = key;
      }
  }
  public static void sortByLastNameBurbuja(Student[] students) {
    int n = students.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (students[j].getLastName().compareTo(students[j + 1].getLastName()) > 0) {
                Student temp = students[j];
                students[j] = students[j + 1];
                students[j + 1] = temp;
            }
        }
    }
  }
  public static void sortByDateOfBirthBurbuja(Student[] students) {
    int n = students.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (students[j].getDateOfBirth().isAfter(students[j + 1].getDateOfBirth())) {
                Student temp = students[j];
                students[j] = students[j + 1];
                students[j + 1] = temp;
            }
        }
    }
}
}
