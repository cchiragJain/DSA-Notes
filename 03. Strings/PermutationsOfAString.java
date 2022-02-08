import java.util.Scanner;

public class PermutationsOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printPermutationsIterative(str);
        sc.close();
    }

    public static void printPermutationsIterative(String str) {
        // this does not work in cases of repeated characters
        // aab will also generate 6 permutations but has only 3 (factorial/no. of repeated characters)

        int n = str.length();
        int fact = fact(n);

        for (int i = 0; i < fact; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for (int div = n; div >= 1; div--) {
                int rem = temp % div;

                System.out.print(sb.charAt(rem));
                sb.deleteCharAt(rem);

                temp = temp / div;
            }
            System.out.println();
        }
    }

    public static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
