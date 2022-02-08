package componentsofoops.inheritance_polymorphism;

public class Vehicle {
    private String color;

    // making variable protected we can access it outside the package as well if the class extends it
    protected int maxSpeed;

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void print() {
        System.out.println("Vehicle " + this.color + " " + this.maxSpeed);
    }

    public String getColor() {
        return this.color;
    }

    // public int getMaxSpeed() {
    //     return this.maxSpeed;
    // }

    public void setColor(String color) {
        this.color = color;
    }

    // public void setMaxSpeed(int maxSpeed) {
    //     this.maxSpeed = maxSpeed;
    // }

}
