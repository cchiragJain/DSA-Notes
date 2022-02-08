import java.util.Scanner;

public class ArrayAddSubtract {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] a1 = takeArrayInput();
        int[] a2 = takeArrayInput();

        int[] sum = arraySum(a1, a2);
        printArray(sum);

        int[] diff = arrayDifference(a1, a2);
        printArray(diff);
    }

    public static int[] arraySum(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;

        // size of sum will always be equal to the greater of the two elements and if there is a carry it gets printed anyways.
        int[] sum = new int[n1 > n2 ? n1 : n2];

        int carry = 0;
        int i = n1 - 1;
        int j = n2 - 1;
        int k = sum.length - 1;

        while (k >= 0) {
            int digit = carry;

            if (i >= 0) {
                digit += a1[i];
            }
            if (j >= 0) {
                digit += a2[j];
            }

            sum[k] = digit % 10;
            carry = digit / 10;

            i--;
            j--;
            k--;
        }

        return sum;
    }

    public static int[] arrayDifference(int[] a1, int[] a2) {
        // a2 will always be greater according to question

        int n1 = a1.length;
        int n2 = a2.length;
        int[] diff = new int[n2];

        int carry = 0;
        int i = n1 - 1;
        int j = n2 - 1;
        int k = diff.length - 1;

        while (k >= 0) {
            int digit = 0;
            int val = i >= 0 ? a1[i] : 0;

            if (a2[j] + carry >= val) {
                digit = a2[j] + carry - val;
                carry = 0;
            } else {
                digit = a2[j] + carry + 10 - val;
                carry = -1;
            }

            diff[k] = digit;

            i--;
            j--;
            k--;

        }

        return diff;

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
