package componentsofoops.inheritancetemp;

import componentsofoops.inheritance_polymorphism.Vehicle;

public class VehicleUse2 {
    public static void main(String[] args) {
        Vehicle v = new Vehicle(100);
        // maxSpeed can't be accessed here since it is not a derived class of Vehicle
    }
}
