import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println("Square root : " + sqroot(n));

        sc.close();
    }

    public static int sqroot(int n) {
        int low = 1;
        int high = n;
        int ans = 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // for i'th root can use Math.pow(mid,i) function which will multiply in O(log n)

            // agar milgaya aisa mid toh bada mid bhi ho sakta h usse
            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            }
            // nahi mila toh matlab aage ke toh aur badaege sum ko toh chotta dhund
            else {
                high = mid - 1;
            }

        }
        return ans;
    }
}
