package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Coordinator extends Employee implements Serializable {
    private int addedCarCount;
    private String phone;

    public Coordinator(String name, String surname, String PESEL, LocalDate birthDate, String street,
                String nr, String city, String code, String phone) {
        super(name, surname, PESEL, birthDate, street, nr, city, code);
        super.setSalary(4000);
        addedCarCount = 0;
        this.phone = phone;
    }

    public Coordinator(String name, String secondName, String surname, String PESEL, LocalDate birthDate,
                String street, String nr, String city, String code, String phone) {
        super(name, secondName, surname, PESEL, birthDate, street, nr, city, code);
        setSalary(4000);
        addedCarCount = 0;
        this.phone = phone;
    }
    public double getAddedCarCount() { return addedCarCount; }
    public String getPhone() { return phone; }
    public void setAddedCarCount(int addedCarCount) { this.addedCarCount = addedCarCount; }
    public void setPhone(String phone){ this.phone = phone; }

    void addVehicleCar() {
        //TODO
    }
    void addVehicleMotorbike(){
        //TODO
    }
    void addVehicleTruck(){
        //TODO
    }

    void showClients() {
        for(Person a: Person.extent){
            if(a.getClass().equals("model.Client")){
                System.out.println(a);
            }
        }
    }
    void deleteClient(String PESEL) {
        for(Person a: Person.extent){
            if(a.getPESEL().equals(PESEL)){
                extent.remove(a);
            }
        }
    }
    void editClientBalance (Client client, double balance) {
        client.setBalance(balance);
    }

    @Override
    public String toString() {
        return super.toString() + " model.Coordinator{" +
                "addedCarCount=" + addedCarCount +
                ", phone='" + phone + '\'' +
                '}';
    }
}
