import java.util.Scanner;

public class SubsetsOfArray {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = takeArrayInput();

        /*

        */

        // total no of subsets of a set = 2^n
        int limit = (int) (Math.pow(2, arr.length));

        for (int i = 0; i < limit; i++) {
            // convert i to binary and print character only when if there is a 1 present and not if 0 is there.
            // the no. of bits should be equivalent to the array length only

            String set = "";
            int temp = i;
            for (int j = arr.length - 1; j >= 0; j--) {
                int rem = temp % 2;

                if (rem == 0) {
                    set = "_" + set;
                } else {
                    set = arr[j] + set;
                }

                temp /= 2;
            }

            System.out.println(set);
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
