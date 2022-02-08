package oopsbasics.complexnumberclass;

public class ComplexNumberUse {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(4, 5);
        c1.print();
        ComplexNumber c2 = new ComplexNumber(1, 2);
        c1.add(c2);
        c1.print();
        c2.print();

        ComplexNumber c3 = ComplexNumber.add(c1, c2);
        c3.print();

        c1.multiply(c2);
        c1.print();
        c2.print();

    }
}
