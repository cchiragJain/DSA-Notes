package interfaces;

// can implement multiple interfaces but can only inherit a single class
// since CarInterface already extends VehicleInterface already no need to implement both here
public class Car extends Vehicle implements CarInterface {
    @Override
    public void print() {
    }

    @Override
    public int getMaxSpeed() {
        return 10;
    }

    @Override
    public String getCompanyName() {
        return null;
    }
}
