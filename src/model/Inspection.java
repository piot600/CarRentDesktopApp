package model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inspection implements Serializable{
    private LocalDate inspectionDate;
    private final LocalDate inspectionExpire;
    private Vehicle vehicle;
    private MechanicDetailer mechanic;

    static List<Inspection> extent = new ArrayList<>();
    private static final String pathToFile = "extentInspection.dat";

    public Inspection(LocalDate inspectionDate, Vehicle vehicle, MechanicDetailer mechanic) {

        this.inspectionDate = inspectionDate;
        this.inspectionExpire = inspectionDate.plusMonths(1);
        this.mechanic=mechanic;
        vehicle.setInspectioned(true);
        vehicle.addInspection(this);
        mechanic.addInspection(this);
        if(!extent.contains(this)) {
            addInspectionToExtent(this);
        }
    }

    //Ekstencja---------------------
    private static void addInspectionToExtent(Inspection inspection) {
        extent.add(inspection);
    }
    public static void showExtent() {
        System.out.println("InspectionExtent extent:");
        for (Inspection r : extent) {
            System.out.println(r);
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
                extent = (List<Inspection>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    //------------------------------

    @Override
    public String toString() {
        return "Data końca:" + inspectionExpire + " " + vehicle.getNr_VIN() + " PESEL: " + mechanic.getPESEL();
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public java.time.LocalDate getInspectionExpire() {
        return inspectionExpire;
    }

    public MechanicDetailer getMechanic() {
        return mechanic;
    }
    public Vehicle getVehicle() { return vehicle; }

    public void setVehile(Vehicle vehicle) {
        if (this.vehicle != null) { throw new IllegalStateException(); }
        this.vehicle = vehicle;
        vehicle.addInspection(this);
    }
}
