package model;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {
    private int seats;
    private boolean carHook;

    public Car(String brand, String model, int mileage, int year, String nr_VIN, double price,
               int seats, boolean carHook) throws Exception {
        super(brand, model, mileage, year, nr_VIN, price);
        setCategory(DriverLicenceCategories.B);
        this.seats = seats;
        this.carHook = carHook;
    }

    public int getSeats() { return seats; }
    public boolean isCarHook() { return carHook; }
    public void setSeats(int seats) { this.seats = seats; }
    public void setCarHook(boolean carHook) { this.carHook = carHook; }

    @Override
    public void showVehicleInfo() {
        System.out.println(
                "["+getClass().getName()+"] "+
                getBrand() + " " +
                getModel() + " " +
                getMileage() + "km " +
                getYear() + " " +
                getNr_VIN() + " $" +
                getPrice() + " " +
                getCategory() + " " +
                getSpecification() + " " +
                seats + "-seats " +
                (carHook ? "with-hook" : "no-hook"));
    }

    @Override
    public String toString() {
        return "["+getClass().getName()+"] "+
                getBrand() + " " +
                getModel() + " " +
                getMileage() + "km " +
                getYear() + " " +
                getNr_VIN() + " $" +
                getPrice() + " " +
                getCategory() + " " +
                getSpecification() + " " +
                seats + "-seats " +
                (carHook ? "with-hook" : "no-hook");
    }
}
