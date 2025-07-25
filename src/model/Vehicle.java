package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Vehicle implements Serializable{
    public static int VehicleCountInOffer = 0;
    private String brand;
    private String model;
    private int mileage;
    private int year;
    private String nr_VIN;
    private double price;
    private DriverLicenceCategories category;
    Specification specification;

    private static List<Vehicle> vehicles = new ArrayList<>();

    int rentCount=0;

    private Boolean isInspectioned = false;

    private List<Inspection> inspections = new ArrayList<Inspection>();
    private Inspection inspection = null;

    private Boolean isRented;
    private List<Rent> rents = new ArrayList<>();
    private Boolean clean = true;

    private static Set<String> nr_VINs = new HashSet<>();
    static List<Vehicle> extent = new ArrayList<>();
    final static String pathToFile = "extentVehicle.dat";


    public Vehicle(String brand, String model, int mileage, int year, String nr_VIN,
                   double price) throws Exception {
        this.brand = brand;
        this.model = model;
        setMileage(mileage);
        this.year = year;
        setNr_VIN(nr_VIN);
        this.price = price;
        category = null;
        this.specification = null;
        VehicleCountInOffer++;
        this.inspection = null;
        vehicles.add(this);
        rents = new ArrayList<>();
        isRented = false;
        if (!containsVehicleInExtent(this)) {
            addVehicleToExtent(this);
        } else {
            System.out.println("model.Vehicle already exists: " + this);
        }
    }

//Extencja------------------------------------
    private void addVehicleToExtent(Vehicle vehicle) {
        extent.add(vehicle);
    }
    public static void showExtent() {
        System.out.println("model.Vehicle extent:");
        for (Vehicle a : extent)
            System.out.println(a);
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
            extent = (List<Vehicle>) stream.readObject();
        } catch (IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
        Vehicle.setVehicles(extent);

    }
    private static void setVehicles(List<Vehicle> vehicles1) {
        vehicles = vehicles1;
    }

    private static boolean containsVehicleInExtent(Vehicle vehicle) {
        for (Vehicle v : extent) {
            if (v.getNr_VIN().equals(vehicle.nr_VIN)) {
                return true;
            }
        }
        return false;
    }

//KOMPOZYCJA-----------------------------------
    public void addSpecification(Specification specification) throws Exception {
        if (this.specification != null && !this.specification.equals(specification)) {
            throw new Exception("Whole already has a part assigned!");
        }
        this.specification = specification;
    }
//Ograniczenie atrybutu-------------------------
public void setMileage(int mileage) throws Exception {
    if(mileage < this.mileage){
        throw new Exception(String.format(
                "The mileage (%d) cannot be decreased! Current mileage: %d", mileage, this.mileage));
    }
    this.mileage = mileage;
}
//Ograniczenie Unique----------------------------
    public void setVIN(String nr_VIN) throws Exception {
        if(!nr_VINs.contains(nr_VIN)){
            this.nr_VIN = nr_VIN;
            nr_VINs.add(nr_VIN);
        }
        else{
            throw new Exception(String.format("VIN %s already exists", nr_VIN));
        }
    }
//Asocjacja z model.Rent---------------------------------
    public void addRent(Rent rent) {
        if (!rents.contains(rent)) {
            rents.add(rent);
            rent.setVehicle(this);
        }
    }

    public List<Rent> getRents() {
        return rents;
    }
//Asocjacja z model.Inspection-------------
    public void addInspection(Inspection inspection) {
        if (!inspections.contains(inspection)) {
            inspections.add(inspection);
            inspection.setVehile(this);
        }
    }
//---------------------------------

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getMileage() { return mileage; }
    public int getYear() { return year; }
    public String getNr_VIN() { return nr_VIN; }
    public Boolean getClean() { return clean; }
    public double getPrice() { return price; }
    public int getRentCount() { return rentCount; }
    public DriverLicenceCategories getCategory() { return category; }
    public void whichCategory(){
        if(this.getClass().getName().equals("model.Car")) setCategory(DriverLicenceCategories.B);
        if(this.getClass().getName().equals("model.Truck")) setCategory(DriverLicenceCategories.C);
    }

    public Inspection getInspection() { return inspection; }
    public Specification getSpecification() { return specification; }
    public List<Inspection> getInspections() { return inspections; }

    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setNr_VIN(String nr_VIN) { this.nr_VIN = nr_VIN; }
    public void setClean(Boolean clean) { this.clean = clean; }
    public void setPrice(double price) { this.price = price; }
    public void setRentCount(int rentCount) { this.rentCount = rentCount; }
    public void setCategory(DriverLicenceCategories category) { this.category = category; }
    public void setInspection(Inspection inspection) { this.inspection = inspection; }
    public void setSpecification(Specification specification) { this.specification = specification; }
    public void setInspectioned(Boolean inspectioned) { isInspectioned = inspectioned; }

    public static List<Vehicle> getVehicles() {
        return vehicles;
    }

    abstract void showVehicleInfo();

    public Boolean getIsRented() { return isRented; }
    public void setIsRented(Boolean isRented) { this.isRented = isRented; }
}
