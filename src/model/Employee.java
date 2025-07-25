package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee extends Person implements Serializable {
    private double salary;

    public Employee(String name, String surname, String PESEL, LocalDate birthDate,
             String street, String nr, String city, String code) {
        super(name, surname, PESEL, birthDate, street, nr, city, code);
        salary=0;
    }

    public Employee(String name, String secondName, String surname, String PESEL, LocalDate birthDate,
             String street, String nr, String city, String code) {
        super(name, secondName, surname, PESEL, birthDate, street, nr, city, code);
        salary=0;
    }
    public double getSalary(){ return salary; }
    public void setSalary(double salary){ this.salary = salary; }

    void deleteVehicle(){
        //TODO
    }

}
