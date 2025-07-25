import gui.ClientMenuGUI;
import model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDate currentDate = LocalDate.of(2024, 6, 17);

        /*model.Rent.writeExtent();
        model.Person.writeExtent();
        model.Vehicle.writeExtent();
        model.Inspection.writeExtent();*/

        Person.readExtent();
        Vehicle.readExtent();
        Rent.readExtent();
        Inspection.readExtent();

        //createSampleData(currentDate);

        Client c1 = (Client) Client.getPESELIfFromExtent("77722");
        c1.addClientLicences(DriverLicenceCategories.A);
        c1.addClientLicences(DriverLicenceCategories.B);
        c1.addClientLicences(DriverLicenceCategories.C);
        new ClientMenuGUI(c1);

        Person.showExtent();
        Vehicle.showExtent();
        Rent.showExtent();
        Inspection.showExtent();

        Rent.writeExtent();
        Person.writeExtent();
        Vehicle.writeExtent();
        Inspection.writeExtent();
    }
    public static void createSampleData(LocalDate currentDate) throws Exception {
        Client c1 = new Client("Pawel", "Palica", "77722", LocalDate.of(1980, 1, 1),
                "Pjatk", "99", "Warszawa", "12345");
        c1.addClientLicences(DriverLicenceCategories.A);
        c1.addClientLicences(DriverLicenceCategories.B);
        c1.addClientLicences(DriverLicenceCategories.C);
        c1.setBalance(100);
        Client c2 = new Client("Kamil", "Sliwa", "11111", LocalDate.of(1980, 1, 1),
                "Wolna", "1", "Warszawa", "12345");
        c2.addClientLicences(DriverLicenceCategories.A);
        c2.addClientLicences(DriverLicenceCategories.B);
        c2.addClientLicences(DriverLicenceCategories.C);
        Client c3 = new Client("Janusz", "Kuba", "Dziupel", "22222", LocalDate.of(1990, 2, 2),
                "Koszykowa", "2", "Siedlce", "23456");
        c3.addClientLicences(DriverLicenceCategories.B);
        c3.addClientLicences(DriverLicenceCategories.C);
        Client c4 = new Client("Dominik", "Pławiak", "33333", LocalDate.of(1985, 3, 3),
                "Lesna", "3", "Pruszkow", "34567");
        c4.addClientLicences(DriverLicenceCategories.A);
        Client c5 = new Client("Mateusz", "Ziobro", "444444", LocalDate.of(1975, 4, 4),
                "Czarna", "4", "Pruszyn", "45678");
        c5.addClientLicences(DriverLicenceCategories.A1);
        Client c6 = new Client("Adam", "Laski", "555555", LocalDate.of(2000, 5, 5),
                "Piska", "5", "Radom", "56789");
        c6.addClientLicences(DriverLicenceCategories.C);
        MechanicDetailer md1 = new MechanicDetailer(
                "Jaroslaw", "Tusk", "666666", LocalDate.of(1980, 3, 15),
                "Biala", "10A", "Koszalin", "12345",
                EmployeeType.Mechanic, EmployeeType.Detailer
        );
        MechanicDetailer md2 = new MechanicDetailer(
                "Donald", "Jan", "Kaczynski", "777777", LocalDate.of(1992, 7, 21),
                "Piekna", "24B", "Sosnowiec", "54321",
                EmployeeType.Mechanic
        );
        MechanicDetailer md3 = new MechanicDetailer(
                "Mateusz", "Kizownik", "888888", LocalDate.of(1990, 2, 21),
                "Rudego", "11", "Warszawa", "54321",
                EmployeeType.Detailer
        );
        Coordinator coordinator1 = new Coordinator(
                "Piotr", "Koordynator", "98989898", LocalDate.of(1975, 5, 20),
                "Polna", "12", "Opole", "67890", "555-1234"
        );
        Coordinator coordinator2 = new Coordinator(
                "Szymon", "Koordynator", "89898989", LocalDate.of(1988, 12, 30),
                "Polna", "12", "Opole", "67890", "555-5678"
        );
        Car car1 = new Car("Toyota", "Corolla", 50000, 2018, "VIN12345", 500,5, false);
        Specification spec1 = Specification.createSpecification(car1, new Specification.Engine.Gas("das"), new Specification.Gearbox.Manual(6));

        Car car2 = new Car("Honda", "Civic", 30000, 2019, "VIN12346", 200, 5, true);
        Specification spec2 = Specification.createSpecification(car2, new Specification.Engine.Gas("Diesel"), new Specification.Gearbox.Automatic(true));

        Car car3 = new Car("Ford", "Focus", 45000, 2017, "VIN12347", 300, 5, true);
        Specification spec3 = Specification.createSpecification(car3, new Specification.Engine.Electric(250), new Specification.Gearbox.Automatic(false));

        Car car4 = new Car("Nissan", "Leaf", 20000, 2020, "VIN12348", 400, 5, false);
        Specification spec4 = Specification.createSpecification(car4, new Specification.Engine.Electric(300), new Specification.Gearbox.Manual(5));

        Car car5 = new Car("Chevrolet", "Malibu", 35000, 2018, "VIN12349", 300, 5, false);
        Specification spec5 = Specification.createSpecification(car5, new Specification.Engine.Gas("Hybrid"), new Specification.Gearbox.Manual(5));

        Motorbike bike1 = new Motorbike("Yamaha", "YZF-R1", 20000, 2020, "VIN20001", 100, 998); // Example capacities in cc
        Specification specBike1 = Specification.createSpecification(bike1, new Specification.Engine.Gas("Petrol"), new Specification.Gearbox.Manual(6));

        Motorbike bike2 = new Motorbike("Honda", "CBR600RR", 15000, 2019, "VIN20002", 150, 599);
        Specification specBike2 = Specification.createSpecification(bike2, new Specification.Engine.Gas("Petrol"), new Specification.Gearbox.Manual(6));

        Motorbike bike3 = new Motorbike("Ducati", "Panigale V4", 5000, 2021, "VIN20003", 200, 1103);
        Specification specBike3 = Specification.createSpecification(bike3, new Specification.Engine.Gas("Petrol"), new Specification.Gearbox.Manual(6));

        Motorbike bike4 = new Motorbike("Suzuki", "GSX-R750", 10000, 2018, "VIN20004", 150, 750);
        Specification specBike4 = Specification.createSpecification(bike4, new Specification.Engine.Gas("Petrol"), new Specification.Gearbox.Manual(6));

        Motorbike bike5 = new Motorbike("Kawasaki", "Ninja ZX-14R", 8000, 2022, "VIN20005", 100, 1441);
        Specification specBike5 = Specification.createSpecification(bike5, new Specification.Engine.Gas("Petrol"), new Specification.Gearbox.Manual(6));

        Truck truck1 = new Truck("Volvo", "FH16", 100000, 2015, "VIN98765", 1000, 7.5, 2.5, 2.5);
        Specification specTruck1 = Specification.createSpecification(truck1, new Specification.Engine.Gas("Diesel"), new Specification.Gearbox.Automatic(true));

        Truck truck2 = new Truck("Scania", "R450", 85000, 2017, "VIN98766", 1500, 8.0, 2.5, 3.0);
        Specification specTruck2 = Specification.createSpecification(truck2, new Specification.Engine.Gas("Diesel"), new Specification.Gearbox.Manual(8));

        Rent r1 = new Rent(c1, car1, currentDate.minusMonths(12), RentStatus.COMPLETED);
        Rent r2 = new Rent(c1, car2, currentDate.minusMonths(10), RentStatus.COMPLETED);
        Rent r3 = new Rent(c1, car3, currentDate.minusMonths(11), RentStatus.COMPLETED);
        Rent r4 = new Rent(c1, car4, currentDate.minusMonths(9), RentStatus.COMPLETED);
        Rent r5 = new Rent(c1, car5, currentDate.minusMonths(10), RentStatus.COMPLETED);
        Rent r6 = new Rent(c1, bike1, currentDate.minusMonths(7), RentStatus.COMPLETED);
        Rent r7 = new Rent(c1, bike2, currentDate.minusMonths(8), RentStatus.COMPLETED);
        Rent r8 = new Rent(c1, truck1, currentDate.minusMonths(4), RentStatus.COMPLETED);
        Rent r9 = new Rent(c1, truck2, currentDate.minusMonths(5), RentStatus.COMPLETED);
        Rent r10 = new Rent(c1, car1, currentDate.minusMonths(6), RentStatus.COMPLETED);
        Rent r11 = new Rent(c2, car2, currentDate.minusMonths(5), RentStatus.COMPLETED);
        Rent r12 = new Rent(c2, bike1, currentDate.minusMonths(4), RentStatus.COMPLETED);
        Rent r13 = new Rent(c3, car3, currentDate.minusMonths(3), RentStatus.COMPLETED);
        Rent r14 = new Rent(c3, truck1, currentDate.minusMonths(2), RentStatus.COMPLETED);

        Inspection s1_car1 = new Inspection(currentDate.minusMonths(4), car1, md1);
        Inspection s2_car1 = new Inspection(currentDate.minusMonths(3), car1, md2);
        Inspection s3_car1 = new Inspection(currentDate.minusMonths(2), car1, md1);
        Inspection s4_car1 = new Inspection(currentDate.minusMonths(1), car1, md2);
        Inspection s5_car1 = new Inspection(currentDate, car1, md1);

        // Inspekcje dla car2
        Inspection s1_car2 = new Inspection(currentDate.minusMonths(4), car2, md2);
        Inspection s2_car2 = new Inspection(currentDate.minusMonths(3), car2, md1);
        Inspection s3_car2 = new Inspection(currentDate.minusMonths(2), car2, md2);
        Inspection s4_car2 = new Inspection(currentDate.minusMonths(1), car2, md1);
        Inspection s5_car2 = new Inspection(currentDate, car2, md2);

        // Inspekcje dla car3
        Inspection s1_car3 = new Inspection(currentDate.minusMonths(4), car3, md1);
        Inspection s2_car3 = new Inspection(currentDate.minusMonths(3), car3, md2);
        Inspection s3_car3 = new Inspection(currentDate.minusMonths(2), car3, md1);
        Inspection s4_car3 = new Inspection(currentDate.minusMonths(1), car3, md2);
        Inspection s5_car3 = new Inspection(currentDate, car3, md1);

        // Inspekcje dla car4
        Inspection s1_car4 = new Inspection(currentDate.minusMonths(4), car4, md2);
        Inspection s2_car4 = new Inspection(currentDate.minusMonths(3), car4, md1);
        Inspection s3_car4 = new Inspection(currentDate.minusMonths(2), car4, md2);
        Inspection s4_car4 = new Inspection(currentDate.minusMonths(1), car4, md1);
        Inspection s5_car4 = new Inspection(currentDate, car4, md2);

        // Inspekcje dla car5
        Inspection s1_car5 = new Inspection(currentDate.minusMonths(4), car5, md1);
        Inspection s2_car5 = new Inspection(currentDate.minusMonths(3), car5, md2);
        Inspection s3_car5 = new Inspection(currentDate.minusMonths(2), car5, md1);
        Inspection s4_car5 = new Inspection(currentDate.minusMonths(1), car5, md2);
        Inspection s5_car5 = new Inspection(currentDate, car5, md1);

        // Inspekcje dla bike1
        Inspection s1_bike1 = new Inspection(currentDate.minusMonths(4), bike1, md2);
        Inspection s2_bike1 = new Inspection(currentDate.minusMonths(3), bike1, md1);
        Inspection s3_bike1 = new Inspection(currentDate.minusMonths(2), bike1, md2);
        Inspection s4_bike1 = new Inspection(currentDate.minusMonths(1), bike1, md1);
        Inspection s5_bike1 = new Inspection(currentDate, bike1, md2);

        // Inspekcje dla bike2
        Inspection s1_bike2 = new Inspection(currentDate.minusMonths(4), bike2, md1);
        Inspection s2_bike2 = new Inspection(currentDate.minusMonths(3), bike2, md2);
        Inspection s3_bike2 = new Inspection(currentDate.minusMonths(2), bike2, md1);
        Inspection s4_bike2 = new Inspection(currentDate.minusMonths(1), bike2, md2);
        Inspection s5_bike2 = new Inspection(currentDate, bike2, md1);

        // Inspekcje dla bike3
        Inspection s1_bike3 = new Inspection(currentDate.minusMonths(4), bike3, md2);
        Inspection s2_bike3 = new Inspection(currentDate.minusMonths(3), bike3, md1);
        Inspection s3_bike3 = new Inspection(currentDate.minusMonths(2), bike3, md2);
        Inspection s4_bike3 = new Inspection(currentDate.minusMonths(1), bike3, md1);
        Inspection s5_bike3 = new Inspection(currentDate, bike3, md2);

        // Inspekcje dla bike4
        Inspection s1_bike4 = new Inspection(currentDate.minusMonths(4), bike4, md1);
        Inspection s2_bike4 = new Inspection(currentDate.minusMonths(3), bike4, md2);
        Inspection s3_bike4 = new Inspection(currentDate.minusMonths(2), bike4, md1);
        Inspection s4_bike4 = new Inspection(currentDate.minusMonths(1), bike4, md2);
        Inspection s5_bike4 = new Inspection(currentDate, bike4, md1);

        // Inspekcje dla bike5
        Inspection s1_bike5 = new Inspection(currentDate.minusMonths(4), bike5, md2);
        Inspection s2_bike5 = new Inspection(currentDate.minusMonths(3), bike5, md1);
        Inspection s3_bike5 = new Inspection(currentDate.minusMonths(2), bike5, md2);
        Inspection s4_bike5 = new Inspection(currentDate.minusMonths(1), bike5, md1);
        Inspection s5_bike5 = new Inspection(currentDate, bike5, md2);

        // Inspekcje dla truck1
        Inspection s1_truck1 = new Inspection(currentDate.minusMonths(4), truck1, md1);
        Inspection s2_truck1 = new Inspection(currentDate.minusMonths(3), truck1, md2);
        Inspection s3_truck1 = new Inspection(currentDate.minusMonths(2), truck1, md1);
        Inspection s4_truck1 = new Inspection(currentDate.minusMonths(1), truck1, md2);
        Inspection s5_truck1 = new Inspection(currentDate, truck1, md1);

        // Inspekcje dla truck2
        Inspection s1_truck2 = new Inspection(currentDate.minusMonths(4), truck2, md2);
        Inspection s2_truck2 = new Inspection(currentDate.minusMonths(3), truck2, md1);
        Inspection s3_truck2 = new Inspection(currentDate.minusMonths(2), truck2, md2);
        Inspection s4_truck2 = new Inspection(currentDate.minusMonths(1), truck2, md1);
        Inspection s5_truck2 = new Inspection(currentDate, truck2, md2);
    }
}