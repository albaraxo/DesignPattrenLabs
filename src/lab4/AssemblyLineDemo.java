package lab4;

// ====== Domain ======
enum EngineType { PETROL, DIESEL, ELECTRIC, HYBRID }

interface Vehicle {
    String getModel();
    EngineType getEngine();
    String specs();
}

// --- Concrete Products ---
final class Car implements Vehicle {
    private final String model;
    private final int doors;
    private final EngineType engine;

    Car(String model, int doors, EngineType engine) {
        this.model = model;
        this.doors = doors;
        this.engine = engine;
    }
    public String getModel() { return model; }
    public EngineType getEngine() { return engine; }
    public String specs() { return "Car[model=" + model + ", doors=" + doors + ", engine=" + engine + "]"; }
}

final class Truck implements Vehicle {
    private final String model;
    private final double cargoCapacityTons;
    private final EngineType engine;

    Truck(String model, double cargoCapacityTons, EngineType engine) {
        this.model = model;
        this.cargoCapacityTons = cargoCapacityTons;
        this.engine = engine;
    }
    public String getModel() { return model; }
    public EngineType getEngine() { return engine; }
    public String specs() { return "Truck[model=" + model + ", cargo=" + cargoCapacityTons + "t, engine=" + engine + "]"; }
}

final class Motorcycle implements Vehicle {
    private final String model;
    private final boolean hasSidecar;
    private final EngineType engine;

    Motorcycle(String model, boolean hasSidecar, EngineType engine) {
        this.model = model;
        this.hasSidecar = hasSidecar;
        this.engine = engine;
    }
    public String getModel() { return model; }
    public EngineType getEngine() { return engine; }
    public String specs() { return "Motorcycle[model=" + model + ", sidecar=" + hasSidecar + ", engine=" + engine + "]"; }
}

// ====== Factories (Factory Method pattern) ======
// Separate concrete factories per vehicle type.
// Each factory knows exactly which constructor/validation to use.

class CarFactory {
    public Car create(String model, int doors, EngineType engine) {
        if (doors != 2 && doors != 3 && doors != 4 && doors != 5)
            throw new IllegalArgumentException("Car doors must be 2, 3, 4, or 5.");
        return new Car(model, doors, engine);
    }
}

class TruckFactory {
    public Truck create(String model, double cargoCapacityTons, EngineType engine) {
        if (cargoCapacityTons <= 0) throw new IllegalArgumentException("Cargo capacity must be > 0.");
        return new Truck(model, cargoCapacityTons, engine);
    }
}

class MotorcycleFactory {
    public Motorcycle create(String model, boolean hasSidecar, EngineType engine) {
        return new Motorcycle(model, hasSidecar, engine);
    }
}

// ====== Client / Demo ======
public class AssemblyLineDemo {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        TruckFactory truckFactory = new TruckFactory();
        MotorcycleFactory motoFactory = new MotorcycleFactory();

        Vehicle c1 = carFactory.create("Sedan X", 4, EngineType.HYBRID);
        Vehicle t1 = truckFactory.create("Hauler 3000", 12.5, EngineType.DIESEL);
        Vehicle m1 = motoFactory.create("Street 750", false, EngineType.PETROL);

        System.out.println(c1.specs());
        System.out.println(t1.specs());
        System.out.println(m1.specs());
    }
}
