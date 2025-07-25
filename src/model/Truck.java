package model;

import java.io.Serializable;

public class Truck extends Vehicle implements Serializable {
    double cargoLength;
    double cargoWidth;
    double cargoHeight;
    double cargoCapacity; //length*width*height*1000;

    public Truck(String brand, String model, int mileage, int year, String nr_VIN, double price,
                 double cargoLength, double cargoWidth, double cargoHeight) throws Exception {
        super(brand, model, mileage, year, nr_VIN, price);
        this.cargoLength = cargoLength;
        this.cargoWidth = cargoWidth;
        this.cargoHeight = cargoHeight;
        cargoCapacity = cargoLength*cargoWidth*cargoHeight*1000;
        setCategory(DriverLicenceCategories.C);
    }

    @Override
    void showVehicleInfo() {
        System.out.println(
                "["+getClass().getName()+"] "+
                getBrand() + " " +
                getModel() + " " +
                getMileage() + "km " +
                getYear() + " " +
                getNr_VIN() + " " +
                getPrice() + " $" +
                getCategory() + " " +
                getSpecification() + " " +
                cargoLength + "m " +
                cargoWidth + "m " +
                cargoHeight + "m " +
                cargoCapacity + "l");
    }

    @Override
    public String toString() {
        return "["+getClass().getName()+"] "+
                getBrand() + " " +
                getModel() + " " +
                getMileage() + "km " +
                getYear() + " " +
                getNr_VIN() + " " +
                getPrice() + " $" +
                getCategory() + " " +
                getSpecification() + " " +
                cargoLength + "m " +
                cargoWidth + "m " +
                cargoHeight + "m " +
                cargoCapacity + "l";
    }
}
