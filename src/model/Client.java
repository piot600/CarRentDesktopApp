package model;

import gui.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Client extends Person implements Serializable {
    Set<DriverLicenceCategories> clientLicences;
    int rentCount;
    double balance;
    List<Rent> rents;

    public Client(String name, String surname, String PESEL, LocalDate birthDate,
           String street, String nr, String city, String code) {
        super(name, surname, PESEL, birthDate, street, nr, city, code);
        this.clientLicences = new HashSet<>();
        rentCount = 0;
        balance = 0;
        rents = new ArrayList<Rent>();
    }

    public Client(String name, String secondName, String surname, String PESEL, LocalDate birthDate,
           String street, String nr, String city, String code) {
        super(name, secondName, surname, PESEL, birthDate, street, nr, city, code);
        this.clientLicences = new HashSet<>();
        rentCount = 0;
        rents = new ArrayList<Rent>();
        balance = 0;
    }

//---Asocjacja z model.Rent
    public void addRent(Rent rent) {
        if (!rents.contains(rent)) {
            rents.add(rent);
            rent.setClient(this);
        }
    }
    public List<Rent> getRents() { return rents; }
//------------------

    public Set<DriverLicenceCategories> getClientLicences() { return clientLicences; }
    public int getRentCount() { return rentCount; }
    public double getBalance() { return balance; }

    public void addClientLicences(DriverLicenceCategories clientLicences) {
        this.clientLicences.add(clientLicences);
    }
    public void setRentCount(int rentCount) { this.rentCount = rentCount; }
    public void setRents(List<Rent> rents) { this.rents = rents; }
    public void setBalance(double balance) { this.balance = balance; }

    public void rentVehicle(){
        if(balance<0) new ErrorGUI(this);
        else new TypeSelectGUI(this);
    }
    void cancelRent(){
        //TODO
    }
    public void payRent(){
        setBalance(0);
        new ClientMenuGUI(this);
    }
    void showRentHistory(){
        //TODO
    }
    void showInspections() {
        //TODO
    }


    @Override
    public String toString() {
        return super.toString() +
                "clientLicences=" + clientLicences +
                ", rentCount=" + rentCount +
                ", balance=" + balance +
                '}';
    }
}
