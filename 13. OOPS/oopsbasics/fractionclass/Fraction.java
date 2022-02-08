package oopsbasics.fractionclass;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            // ideally should throw an error
            denominator = 1;
        }
        this.denominator = denominator;
        simplify();
    }

    public void print() {
        System.out.println(this.numerator + "/" + this.denominator);
    }

    public void increment() {
        this.numerator = this.numerator + this.denominator;
        simplify();
    }

    public void add(Fraction f) {
        // in a sense Fraction class is our own defined datatype
        // first fraction is the object on which the function is called
        // second fraction is the one that is passed
        this.numerator = (this.numerator * f.denominator) + (this.denominator * f.numerator);
        this.denominator = this.denominator * f.denominator;
        simplify();
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        int numerator = (f1.numerator * f2.denominator) + (f1.denominator * f2.numerator);
        int denominator = (f1.denominator * f2.denominator);

        Fraction f3 = new Fraction(numerator, denominator);
        return f3;
    }

    private void simplify() {
        int gcd = euclidGcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    private int euclidGcd(int a, int b) {
        if (b == 0)
            return a;

        return euclidGcd(b, a % b);
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0)
            return;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }
}
