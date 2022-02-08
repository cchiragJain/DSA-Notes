package abstractclasses;

public class BMW extends Car {
    public BMW(int maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public String getCompany() {
        return "BMW";
    }
}
