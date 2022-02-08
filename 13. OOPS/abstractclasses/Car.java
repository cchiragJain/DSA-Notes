package abstractclasses;

// public abstract class Car extends Vehicle {
public abstract class Car extends Vehicle {
    public Car(int maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public boolean isMotorised() {
        return true;
    }

}