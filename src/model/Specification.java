package model;

import java.io.Serializable;

public class Specification implements Serializable {
    private Engine engine;
    private Gearbox gearbox;

    private Vehicle vehicle;

    public Specification(Vehicle vehicle, Engine engine, Gearbox gearbox){
        this.vehicle = vehicle;
        this.engine = engine;
        this.gearbox = gearbox;
    }
//KOMPOZYCJA-----
    public static Specification createSpecification(Vehicle vehicle, Engine engine, Gearbox gearbox) throws Exception {
        if(vehicle == null){
            throw new Exception("This model.Vehicle does not exist");
        }
        Specification specification = new Specification(vehicle, engine, gearbox);
        vehicle.addSpecification(specification);
        return specification;
    }
//-----------------


    public Engine getEngine() { return engine; }
    public void setEngine(Engine engine) { this.engine = engine; }
    public Gearbox getGearbox() { return gearbox;}
    public void setGearbox(Gearbox gearbox) { this.gearbox = gearbox; }

    public static class Engine implements Serializable{
        public static class Electric extends Engine{
            int batteryCapacity;
            public Electric(int batteryCapacity) {
                this.batteryCapacity = batteryCapacity;
            }
            public int getBatteryCapacity() { return batteryCapacity; }
            public void setBatteryCapacity(int batteryCapacity) { this.batteryCapacity = batteryCapacity; }
        }
        public static class Gas extends Engine{
            String fuelType;
            public Gas(String fuelType) { this.fuelType = fuelType; }
            public String getFuelType() { return fuelType; }
            public void setFuelType(String fuelType) { this.fuelType = fuelType; }
        }
    }

    public static class Gearbox implements Serializable{
        public static class Manual extends Gearbox{
            int gearsNumber;
            public Manual(int gearsNumber){ this.gearsNumber = gearsNumber;}
            public int getGearsNumber() { return gearsNumber; }
            public void setGearsNumber(int gearsNumber) { this.gearsNumber = gearsNumber; }
        }
        public static class Automatic extends Gearbox{
             boolean singleStage;
             public Automatic(boolean singleStage){ this.singleStage = singleStage; }
            public boolean isSingleStage() { return singleStage; }
            public void setSingleStage(boolean singleStage) { this.singleStage = singleStage; }
        }
    }

    @Override
    public String toString() {
        return "{" +
                engine.getClass().getSimpleName() + " " +
                gearbox.getClass().getSimpleName() +
                '}';
    }
}
