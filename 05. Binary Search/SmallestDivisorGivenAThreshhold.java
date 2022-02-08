import java.util.Scanner;

public class SmallestDivisorGivenAThreshhold {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        System.out.println("Enter threshold");
        int threshold = sc.nextInt();

        System.out.println(smallestDivisor(arr, threshold));

    }

    public static int smallestDivisor(int[] arr, int threshold) {
        int low = 0;
        int high = arrayMax(arr);

        while (low < high) {
            int mid = (low + high) / 2;

            if (arraySumDividedByMid(arr, mid) <= threshold) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    public static int arraySumDividedByMid(int[] arr, int mid) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // can also check if number is not divisible then add 1 for it to the sum or use ceil funciton

            double temp = (double) arr[i] / (double) mid;
            sum += Math.ceil(temp);
        }

        return sum;
    }

    public static int arrayMax(int[] arr) {
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(arr[i], maximum);
        }

        return maximum;
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