package oopsbasics.complexnumberclass;

public class ComplexNumber {
    // setters getters
    // add both variants
    // multiply
    // print

    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void print() {
        System.out.println(this.real + " + " + "i" + this.imaginary);
    }

    public void multiply(ComplexNumber c) {
        int real = (this.real * c.real) - (this.imaginary * c.imaginary);
        int imaginary = (this.real * c.imaginary) + (this.imaginary * c.real);
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(ComplexNumber c) {
        this.real = this.real + c.real;
        this.imaginary = this.imaginary + c.imaginary;
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        int real = c1.real + c2.real;
        int imaginary = c1.imaginary + c2.imaginary;

        return new ComplexNumber(real, imaginary);
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public int getReal() {
        return this.real;
    }

    public int getImaginary() {
        return this.imaginary;
    }
}
