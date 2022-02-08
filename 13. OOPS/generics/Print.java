package generics;

public class Print {
    // BOUNDED GENERIC METHOD
    public static <T extends PrintInterface> void printAllWithPrintFunctionInItArray(T[] arr) {
        // now only those T can come that implements the PrintInterface
        // this means that only the classes with print() function can be there
        for (int i = 0; i < arr.length; i++) {
            arr[i].print();
        }
        System.out.println();
    }

    // ONLY VEHICLE SUBCLASSES
    public static <T extends Vehicle> void printVehicleArray(T[] arr) {
        // any class which extends vehicle will also have a print function in it
        // BUT now this function is not useful for other classes with print
        // function and can only be used by vehicle class and its sub classes
        // NEED something in the middle
        for (int i = 0; i < arr.length; i++) {
            arr[i].print();
        }
        System.out.println();
    }

    // GENERIC METHOD
    // will figure it out what data type is passed to it
    public static <T> void printArray(T[] arr) {
        // This function will not be able to use the print function of the Vehicle class
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // public static void printIntArray(int[] arr) {
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    // }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        printArray(arr);

        // For wrapper classes default value is null
        Character[] arrCharacters = new Character[5];
        printArray(arrCharacters);

        Vehicle[] vehicles = new Vehicle[10];

        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i] = new Vehicle(10);
        }

        printArray(vehicles); // will print address of vehicles
        printVehicleArray(vehicles);
        printAllWithPrintFunctionInItArray(vehicles);

        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i + 1);
        }

        // printVehicleArray(students);
        printAllWithPrintFunctionInItArray(students);

    }
}
