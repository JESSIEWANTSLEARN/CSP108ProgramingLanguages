package Quiz3CityTrafficManager;

import java.util.ArrayList;
import java.util.Scanner;

// 1. Data Model
class Vehicle {
    private int people;
    private int capacity;

    public Vehicle(int people, int capacity) {
        this.people = people;
        this.capacity = capacity;
    }

    public double getEfficiency() {
        return ((double) people / capacity) * 100;
    }

    public int getPeople() {
        return people;
    }
}

// 2. Composition: TrafficAnalyzer "has-a" list of Vehicles
class TrafficAnalyzer {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(int people, int capacity) {
        vehicles.add(new Vehicle(people, capacity));
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}