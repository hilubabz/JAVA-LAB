// Vehicle interface defining required methods
interface Vehicle {
    void displayInfo();
    double calculateFuelEfficiency(); // km per liter
    double calculateDistanceTraveled(double hours, double averageSpeed);
    double getMaxSpeed();
}

// Truck class implementing Vehicle interface
class Truck implements Vehicle {
    private String make;
    private String model;
    private int year;
    private String fuelType;

    public Truck(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck - Make: " + make + ", Model: " + model + ", Year: " + year + ", Fuel Type: " + fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 6.0; // example km/l for truck
    }

    @Override
    public double calculateDistanceTraveled(double hours, double averageSpeed) {
        return hours * averageSpeed;
    }

    @Override
    public double getMaxSpeed() {
        return 110; // example km/h
    }
}

// Car class implementing Vehicle interface
class Car implements Vehicle {
    private String make;
    private String model;
    private int year;
    private String fuelType;

    public Car(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car - Make: " + make + ", Model: " + model + ", Year: " + year + ", Fuel Type: " + fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 16.0; // example km/l for car
    }

    @Override
    public double calculateDistanceTraveled(double hours, double averageSpeed) {
        return hours * averageSpeed;
    }

    @Override
    public double getMaxSpeed() {
        return 180; // example km/h
    }
}

// Motorcycle class implementing Vehicle interface
class Motorcycle implements Vehicle {
    private String make;
    private String model;
    private int year;
    private String fuelType;

    public Motorcycle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Motorcycle - Make: " + make + ", Model: " + model + ", Year: " + year + ", Fuel Type: " + fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 22.0; // example km/l for motorcycle
    }

    @Override
    public double calculateDistanceTraveled(double hours, double averageSpeed) {
        return hours * averageSpeed;
    }

    @Override
    public double getMaxSpeed() {
        return 160; // example km/h
    }
}

// Test class
public class Lab2b {
    public static void main(String[] args) {
        Vehicle truck = new Truck("Volvo", "FH16", 2020, "Diesel");
        Vehicle car = new Car("Toyota", "Corolla", 2021, "Petrol");
        Vehicle motorcycle = new Motorcycle("Honda", "CBR500R", 2022, "Petrol");

        truck.displayInfo();
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " km/l");
        System.out.println("Distance traveled in 3 hours at 70 km/h: " + truck.calculateDistanceTraveled(3, 70) + " km");
        System.out.println("Max Speed: " + truck.getMaxSpeed() + " km/h\n");

        car.displayInfo();
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " km/l");
        System.out.println("Distance traveled in 2.5 hours at 90 km/h: " + car.calculateDistanceTraveled(2.5, 90) + " km");
        System.out.println("Max Speed: " + car.getMaxSpeed() + " km/h\n");

        motorcycle.displayInfo();
        System.out.println("Fuel Efficiency: " + motorcycle.calculateFuelEfficiency() + " km/l");
        System.out.println("Distance traveled in 1.5 hours at 100 km/h: " + motorcycle.calculateDistanceTraveled(1.5, 100) + " km");
        System.out.println("Max Speed: " + motorcycle.getMaxSpeed() + " km/h");
    }
}
