package componentsofoops.inheritancetemp;

import componentsofoops.inheritance_polymorphism.Vehicle;

public class Truck extends Vehicle {
    int maxLoadingCapacity;

    public Truck() {
        super(100);
        System.out.println("Truck constructor");
    }

    public void print() {
        // can just access maxSpeed because it is protected
        System.out
                .println("Truck print() " + this.getColor() + " " + this.maxSpeed + " " + this.maxLoadingCapacity);
    }

}
