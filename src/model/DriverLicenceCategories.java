package model;

public enum DriverLicenceCategories {
    A,
    A1(600),
    A2(125),
    B,
    C;

    private int capacity;

    DriverLicenceCategories() {}

    DriverLicenceCategories(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }

}
