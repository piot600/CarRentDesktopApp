package model;

import java.io.Serializable;

public class Motorbike extends Vehicle implements Serializable {
    double engineCapacity;

    public Motorbike(String brand, String model, int mileage, int year, String nr_VIN, double price,
                     double engineCapacity) throws Exception {
        super(brand, model, mileage, year, nr_VIN, price);
        if(engineCapacity > DriverLicenceCategories.A1.getCapacity() )
            setCategory(DriverLicenceCategories.A);
        else if(engineCapacity > DriverLicenceCategories.A2.getCapacity())
            setCategory(DriverLicenceCategories.A1);
        else setCategory(DriverLicenceCategories.A2);
    }

    @Override
    void showVehicleInfo() {
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
                engineCapacity + "cc");
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
                engineCapacity + "cc";
    }
}
