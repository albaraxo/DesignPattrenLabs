package lab1;
//Albara abuamsoor 2240096
// Base class
class Vehicle {

    public void start(){
        System.out.println("Start the Vehicle");
    }
}
// Subclass: Car
class Car extends Vehicle{
    @Override
    public void start(){
        System.out.println("Start the Car");
    }
}

// Subclass: Bicycle
class Bicycle extends Vehicle{

    @Override
    public void start() {
        System.out.println("Start the bicycle");
    }
}
// Main class to test
class Main2 {
    public static void main(String[] args) {
        // Create instances
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();

        //array for vehiles which hold
        Vehicle[] vehicles = {car, bicycle};

        // Loop and call start()
        for (Vehicle v : vehicles) {
            v.start();  // Polymorphism in action
        }

    }
}

