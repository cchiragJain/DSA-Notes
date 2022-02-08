package componentsofoops.inheritance_polymorphism;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Car(4, 100);
        v.print();

        // Vehicle v = new Vehicle(100);

        // v.setColor("Black");
        // v.maxSpeed = 100;

        // v.print();

        // // Bicycle b = new Bicycle();

        // Car c = new Car(4);
        // c.setColor("red"); // inherited from Vehicle 
        // c.maxSpeed = 200; // inherited from Vehicle
        // c.setNumDoor(4); // from Car
        // // c.print(); // inherited from Vehicle

        // c.printCar(); // from Car
        // c.print(); // uses the one from the car()
    }
}
