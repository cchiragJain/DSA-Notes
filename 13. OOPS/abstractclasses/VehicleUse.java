package abstractclasses;

public class VehicleUse {
    public static void main(String[] args) {
        // VEHICLE CLASS KA OBJECT NAHI BAN SAKTA ABH BECAUSE VEHICLE IS NOW AN ABSTRACT CLASS OR A Incomplete class
        // Vehicle v = new Vehicle(10);
        // Car c = new Car(50); car bhi incomplete h abstract likhne ke baad

        // After removing the incompleteness we can create a object of Car type

        // Car ko abstract banane ke baad abh yeh nahi kar sakte
        // Car c = new Car(100);
        // Vehicle v = new Car(100); // can do this since object toh car type ka h
        // v.isMotorised(); can access vehicle things as well

        BMW bmw = new BMW(100);
        Car c = new BMW(100);
        Vehicle v = new BMW(100);
    }
}
