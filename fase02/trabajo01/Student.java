package TeoriaFP.fase02.trabajo01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateOfBirth = dateOfBirth.format(formatter);
        return "Nombre: " + firstName + " " + lastName + ", Fecha de Nacimiento: " + formattedDateOfBirth;
    }
}