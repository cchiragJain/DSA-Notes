package generics;

public class Vehicle implements PrintInterface {
    private String color;

    // making variable protected we can access it outside the package as well if the class extends it
    protected int maxSpeed;

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void print() {
        System.out.println("Vehicle " + this.maxSpeed);
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
