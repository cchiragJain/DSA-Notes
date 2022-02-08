package componentsofoops.inheritance_polymorphism;

public class Car extends Vehicle {
    private int numDoors;
    int maxSpeed;

    public Car(int numDoors, int maxSpeed) {
        super(maxSpeed); // this needs to be first
        // System.out.println("Car's constructor");
        this.numDoors = numDoors;
    }

    public void printCar() {
        System.out.println("Car " + this.getColor() + " " + this.maxSpeed + " " + this.numDoors);
    }

    public void print() {
        // super.print();
        System.out.println("Car print() " + this.numDoors);
    }

    public void printMaxSpeed() {
        System.out.println(this.maxSpeed + " " + super.maxSpeed);
    }

    public void setNumDoor(int numDoors) {
        this.numDoors = numDoors;
    }

    public int getNumDoor() {
        return this.numDoors;
    }
}
