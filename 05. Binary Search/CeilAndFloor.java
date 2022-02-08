import java.util.Scanner;

public class CeilAndFloor {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[] arr = takeArrayInput();

        System.out.println("Enter element");
        int x = sc.nextInt();

        printCeilAndFloor(arr, x);
    }

    public static void printCeilAndFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] < x) {
                low = mid + 1;
                floor = arr[mid];
            } else if (arr[mid] > x) {
                high = mid - 1;
                ceil = arr[mid];
            } else {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }
        }

        System.out.println("Floor : " + floor);
        System.out.println("Ceil : " + ceil);
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
