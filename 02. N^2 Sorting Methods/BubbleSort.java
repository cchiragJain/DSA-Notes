import java.util.Scanner;

public class BubbleSort {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();
        bubbleSort(arr);
        printArray(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swapArrayElements(arr, j + 1, j);
                }
            }
        }
    }

    public static void swapArrayElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
