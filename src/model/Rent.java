package model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Rent implements Serializable{
    public static List<Rent> extent = new ArrayList<>();
    private static final String pathToFile = "extentRent.dat";
    private Client client;
    private Vehicle vehicle;
    private LocalDate startDate;
    LocalDate endDate;
    double cost;


    private RentStatus status;

    public Rent(Client client, Vehicle vehicle, LocalDate startDate, RentStatus status){
        this.client = client;
        this.vehicle = vehicle;
        this.startDate = startDate;
        endDate = LocalDate.now().plusDays(7);
        cost = vehicle.getPrice()*7;
        this.status = status;

        setClient(client);
        setVehicle(vehicle);

        if(!extent.contains(this)) {
            addRentToExtent(this);
        }
    }

    public Rent(Client client, Vehicle vehicle) {
        startDate = LocalDate.now();
        endDate = LocalDate.now().plusDays(7);
        cost = vehicle.getPrice()*7;
        client.balance-=cost;
        status = RentStatus.CREATED;

        //Relacja z Klient i Pojazd
        client.addRent(this);
        vehicle.addRent(this);
        if(!extent.contains(this)) {
            addRentToExtent(this);
        }
        vehicle.setIsRented(true);
    }

    //Ekstencja---------------------
    private static void addRentToExtent(Rent rent) {
        extent.add(rent);
        extent.sort(Comparator.comparing(Rent::getStartDate).reversed());
    }
    public static void showExtent() {
        System.out.println("model.Rent extent:");
        for (Rent r : extent) {
            System.out.println(r);
        }
    }
    public static void removeRent(Rent rent) {;
        for (Rent r : extent) {
            if(r.equals(rent)) {
                extent.remove(r);
            }
        }
    }

    public static void writeExtent() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pathToFile))) {
            out.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readExtent() {
        File file = new File(pathToFile);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                extent = (List<Rent>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //------------------------------
    public Client getClient() {
        return client;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStatus(RentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return client.getName() + " " +
                client.getSurname() + " " +
                client.getPESEL() + " Wynajem:" +
                startDate + " Koniec:"
                + endDate + " "
                + vehicle.getModel() + " "
                + vehicle.getYear() + " "
                + vehicle.getNr_VIN() + " "
                + status.toString();
    }

    public void setVehicle(Vehicle vehicle) {
        if (this.vehicle != null && !this.vehicle.equals(vehicle)) {
            throw new IllegalStateException("Vehicle already set");
        }
        if (this.vehicle == null) {
            this.vehicle = vehicle;
            vehicle.addRent(this);
        }
    }

    public void setClient(Client client) {
        if (this.client != null && !this.client.equals(client)) {
            throw new IllegalStateException("Client already set");
        }
        if (this.client == null) {
            this.client = client;
            client.addRent(this);
        }
    }
}
