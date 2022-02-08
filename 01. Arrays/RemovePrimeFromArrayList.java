import java.util.ArrayList;
import java.util.Scanner;

public class RemovePrimeFromArrayList {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> list = takeArrayListInput();
        removePrimes(list);
        printArrayList(list);
    }

    public static void removePrimes(ArrayList<Integer> list) {
        // remove anything from arraylist based on condition better to traverse from the end
        int n = list.size() - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (isPrime(list.get(i))) {
                list.remove(i);
            }
        }
    }

    public static boolean isPrime(int n) {

        if (n <= 1)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i < n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    public static ArrayList<Integer> takeArrayListInput() {
        ArrayList<Integer> arraylist = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arraylist.add(sc.nextInt());
        }
        return arraylist;
    }

    public static void printArrayList(ArrayList<Integer> arrayList) {
        for (int val : arrayList)
            System.out.print(val + " ");
        System.out.println();
    }
}
