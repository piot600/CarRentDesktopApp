package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class MechanicDetailer extends Employee implements Serializable {
    private EnumSet<EmployeeType> employeeType;
    private int inspectionCount;
    private int cleanedCount;
    private double salaryAddiction;

    private List<Inspection> inspections;

    public MechanicDetailer(String name, String surname, String PESEL, LocalDate birthDate,
                            String street, String nr, String city, String code,
                            EmployeeType... roles) {
        super(name, surname, PESEL, birthDate, street, nr, city, code);
        this.employeeType = EnumSet.noneOf(EmployeeType.class);
        for (EmployeeType role : roles) {
            this.employeeType.add(role);
        }
        cleanedCount = 0;
        inspectionCount = 0;
        salaryAddiction = 0;
        this.inspections = new ArrayList<>();
        for (EmployeeType role : employeeType) {
            if(role.equals(EmployeeType.Detailer)) setSalary(getSalary()+1000);
            if(role.equals(EmployeeType.Mechanic)){
                if(inspectionCount>50) setSalary(getSalary()+1500);
                else setSalary(getSalary()+500);
            }
        }
    }

    public MechanicDetailer(String name, String secondName, String surname, String PESEL, LocalDate birthDate,
                     String street, String nr, String city, String code,
                     EmployeeType... roles) {
        super(name, secondName, surname, PESEL, birthDate, street, nr, city, code);
        this.employeeType = EnumSet.noneOf(EmployeeType.class);
        for (EmployeeType role : roles) {
            this.employeeType.add(role);
        }
        cleanedCount = 0;
        inspectionCount = 0;
        salaryAddiction = 0;
        this.inspections = new ArrayList<>();
        for (EmployeeType role : employeeType) {
            if(role.equals(EmployeeType.Detailer)) setSalary(getSalary()+1000);
            if(role.equals(EmployeeType.Mechanic)){
                if(inspectionCount>50) setSalary(getSalary()+1500);
                else setSalary(getSalary()+500);
            }
        }
    }
    public int getInspectionCount() { return inspectionCount; }
    public int getCleanedCount() { return cleanedCount; }
    public double getSalaryAddiction() { return salaryAddiction; }
    public List<Inspection> getInspections() { return inspections; }
    public void setInspectionCount(int inspectionCount){ this.inspectionCount = inspectionCount; }
    public void setCleanedCount(int cleanedCount){ this.cleanedCount = cleanedCount; }
    public void setSalaryAddiction(int salaryAddiction){ this.salaryAddiction = salaryAddiction; }

    public void makeVehicleInspection(Vehicle vehicle) throws Exception {
        if(employeeType.contains(EmployeeType.Mechanic)) {
            LocalDate inspectionDate = LocalDate.now();
            new Inspection(inspectionDate, vehicle, this);
        } throw new Exception("To nie jest Serwisant");
    }
    public void updateVehicleMileage(Vehicle vehicle, int mileage) throws Exception {
        if(employeeType.contains(EmployeeType.Mechanic)) {
            vehicle.setMileage(mileage);
        } throw new Exception("To nie jest Serwisant");
    }
    //Dziedziczenie dynamiczne----------------------------------
    public boolean isExperienced() throws Exception {
        if(employeeType.contains(EmployeeType.Mechanic)) {
            if(inspectionCount < 50)
                return false;
            setSalaryAddiction(1500);
            return true;
        } throw new Exception("To nie jest Serwisant");
    }

    public void makeVehicleClean(Vehicle vehicle) throws Exception {
        if(employeeType.contains(EmployeeType.Detailer)) {
            vehicle.setClean(true);
        } throw new Exception("To nie jest Detailer");
    }

    //Asocjacja z model.Inspection------------------
    public void addInspection(Inspection inspection) {
        if (!inspections.contains(inspection)) {
            inspections.add(inspection);
        }
    }
    //--------------------------------------

    @Override
    public String toString() {
        return super.toString() + " {" +
                "employeeType=" + employeeType +
                ", inspectionCount=" + inspectionCount +
                ", cleanedCount=" + cleanedCount +
                ", salary=" + getSalary() +
                '}';
    }
}
