import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // default capacity 10 hoti hain
        // ArrayList<Integer> list = new ArrayList<>(5); value pass kardege toh default change ho jaaega to 5

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.size());

        list.add(10);
        System.out.println(list.size());

        list.add(15);
        list.add(25);
        System.out.println(list.size());

        // System.out.println(list[1]);
        System.out.println(list.get(1));

        // out of bounds error
        // System.out.println(list.get(5));
        // list.add(4, 10);
        // System.out.println(list.get(4));

        System.out.println();

        // index par add karne se shift ho jaate h elements
        list.add(2, 50);
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println();

        // PRINTING WHOLE ARRAY LIST
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();

        // using enhanced for loop
        for (int elem : list)
            System.out.print(elem + " ");

        System.out.println();

        // printing list
        System.out.println(list);

        // REMOVING ELEMENTS
        list.remove(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();

        // ASSIGNING VALUES
        // add se toh us index pe add ho jaata hain and aage ke shift ho jaate hain
        list.set(1, 1111);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
