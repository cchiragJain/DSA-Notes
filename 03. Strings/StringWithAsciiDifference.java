import java.util.Scanner;

public class StringWithAsciiDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        printAsciiDiffString(str);

        sc.close();
    }

    public static void printAsciiDiffString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            int gap = curr - prev;

            sb.append(gap);
            sb.append(curr);
        }

        System.out.println(sb);
    }
}
