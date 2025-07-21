class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String fuelType;

    public Vehicle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    public void displayInfo() {
        System.out.println("Make: " + make + ", Model: " + model +
                ", Year: " + year + ", Fuel Type: " + fuelType);
    }

    // Default implementations (can be overridden)
    public double calculateFuelEfficiency() {
        return 0;
    }

    public double calculateDistanceTraveled(double hours, double averageSpeed) {
        return hours * averageSpeed;
    }

    public double getMaxSpeed() {
        return 0;
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 6.0; // Example km/l for trucks
    }

    @Override
    public double getMaxSpeed() {
        return 110; // Example max speed for trucks
    }
}

class Car extends Vehicle {
    public Car(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 16.0; // Example km/l for cars
    }

    @Override
    public double getMaxSpeed() {
        return 180; // Example max speed for cars
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 22.0; // Example km/l for motorcycles
    }

    @Override
    public double getMaxSpeed() {
        return 160; // Example max speed for motorcycles
    }
}

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
