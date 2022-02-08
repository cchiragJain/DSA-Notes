package generics;

public class Student implements PrintInterface {
    private int rollNumber;

    public Student(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public void print() {
        System.out.println(this.rollNumber);
    }
}
