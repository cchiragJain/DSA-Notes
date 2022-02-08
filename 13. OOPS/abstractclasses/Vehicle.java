package abstractclasses;

public abstract class Vehicle {
    // vehicle class wants any class that inherits from it to have a particular functionality but does not want to implement itself.
    private int maxSpeed;

    public Vehicle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public abstract boolean isMotorised();

    public abstract String getCompany();

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

}
