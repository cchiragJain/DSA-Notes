import java.util.Scanner;

public class GeneratePairs {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("[" + arr[i] + "," + arr[j] + "]");
            }
        }
    }

    public static int[] takeArrayInput() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }
}
