package exceptionhandling;

public class ExceptionDemo {
    // THE MAIN FUNCTION CAN THROW THE EXCEPTION OR WE CAN USE TRY CATCH BLOCKS
    // public static void main(String[] args) throws DivideByZeroException {
    public static void main(String[] args) {
        // WILL THROW NullPointerException
        // String str = null;
        // System.out.println(str.length());

        // ArithmeticException
        // System.out.println(4 / 0);

        // will try doing the thing and if that throws a exception catch it in the catch block
        try {
            divide(4, 2);
            fact(-1);
            // if an exception is raised the line below will not run and the code will go into the catch part
            System.out.println("within try");
        } catch (DivideByZeroException e) {
            System.out.println("Divide by zero exception");
        } catch (NegativeNumberException e) {
            System.out.println("Negative Number exception");
        } catch (Exception e) {
            System.out.println("Generic Exception");
        } finally {
            // will always be executed irrespective of wheter an exception has occured or not
            System.out.println("Finally");
        }

        System.out.println("Main");

    }

    // the function needs to throw as well since it is a checked exception
    public static int divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            // throw new ArithmeticException();
            throw new DivideByZeroException();
        }
        return a / b;
    }

    public static int fact(int n) throws NegativeNumberException {
        if (n < 0) {
            throw new NegativeNumberException();
        }

        int f = 1;

        for (int i = 2; i <= n; i++) {
            f = f * i;
        }

        return f;
    }

}
