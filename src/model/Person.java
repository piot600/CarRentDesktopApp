package model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Serializable{
    static List<Person> extent = new ArrayList<>();
    final static String pathToFile = "extentOsoba.dat";

    private String name;
    private String secondName;
    private String surname;
    private String PESEL;
    private LocalDate birthDate;
    private AddressData address;

    Person(String name, String surname, String PESEL, LocalDate birthDate,
           String street, String nr, String city, String code) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.birthDate = birthDate;
        address = new AddressData(street, nr, city, code);
        if (!containsClient(this)) {
            addClient(this);
        } else {
            System.out.println("model.Client already exists: " + this);
        }
    }

    Person(String name, String secondName, String surname, String PESEL, LocalDate birthDate,
           String street, String nr, String city, String code) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.birthDate = birthDate;
        address = new AddressData(street, nr, city, code);
        this.secondName = secondName;
        if (!containsClient(this)) {
            addClient(this);
        } else {
            System.out.println("model.Client already exists: " + this);
        }
    }
//EKSTENCJA---------------------
    private void addClient(Person person) {
        extent.add(person);
    }
    private static boolean containsClient(Person client) {
        for (Person person : extent) {
            if (person.getPESEL().equals(client.getPESEL())) {
                return true;
            }
        }
        return false;
    }
    public static void showExtent() {
        System.out.println("Osoba extent:");
        for (Person person : extent)
            System.out.println(person);
    }
    public static void writeExtent() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathToFile));
            out.writeObject(extent);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readExtent() {
        try {
            File f = new File(pathToFile);
            if (!f.exists()) return;
            ObjectInputStream stream = new ObjectInputStream(new FileInputStream(f));
            extent = (List<Person>) stream.readObject();
            stream.close();
        } catch (IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }
    public static Person getPESELIfFromExtent(String PESEL) {
        for (Person person : extent){
            person.getPESEL().equals(PESEL);
            return person;
        }
        return null;
    }

//---------------------------------


    public String getName() { return name; }
    public String getSecondName() { return secondName; }
    public String getSurname() { return surname; }
    public String getPESEL() { return PESEL; }
    public LocalDate getBirthDate() { return birthDate; }
    public AddressData getAddressData() { return address; }


    public void setName(String name) { this.name = name; }
    public void setSecondName(String secondName) { this.secondName = secondName; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPESEL(String PESEL) { this.PESEL = PESEL; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setAddressData(String street, String nr, String city, String code) {
        address.setStreet(street);
        address.setNr(nr);
        address.setCity(city);
        address.setCode(code);
    }

    void showVehicles() {}
    void showInspections() {}

    @Override
    public String toString() {
        return getClass().getName()+ "{" +
                "name='" + name + '\'' +
                (secondName != null ? ", second name='" + secondName : "") +
                "', surname='" + surname + '\'';
    }
}


class AddressData implements Serializable {
    private String street;
    private String nr;
    private String city;
    private String code;

    AddressData(String street, String nr, String city, String code){
        this.street = street;
        this.nr = nr;
        this.city = city;
        this.code = code;
    }

    public String getStreet() {
        return street;
    }
    public String getNr() {
        return nr;
    }
    public String getCity() {
        return city;
    }
    public String getCode() {
        return code;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public void setNr(String nr) {
        this.nr = nr;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "("+ street +" "+nr+", "+ code +", "+ city +")";
    }
}