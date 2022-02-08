import java.util.Scanner;

public class StringDemo {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println(s1);

        // TAKING INPUT
        // next() se space se pehle ka nextLine() puri line ko utha lega
        // String s2 = sc.next();
        // String s3 = sc.next();
        // String s4 = sc.nextLine();

        // SINGLE CHARACTER & LENGTH
        System.out.println(s1.length());
        System.out.println(s1.charAt(2));

        // PRINTING ALL CHARACTERS
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.charAt(i) + " ");
        }

        System.out.println();

        // SUBSTRINGS
        System.out.println(s1.substring(0, 5));
        System.out.println(s1.substring(2, 4));

        // isse 0 se lekar end tak ka saara print ho jaaega
        System.out.println(s1.substring(0));
        System.out.println(s1.substring(3));

        System.out.println();

        // PRINT ALL SUBSTRINGS
        String str = "abcd";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }

        System.out.println();

        // ADDING STRINGS
        // s1 = "hello"
        String s2 = "there";
        String s3 = s1 + " " + s2;
        System.out.println(s3);

        System.out.println();

        // ADDING SINGLE CHARACTERS TO STRING
        s1 += ' ';
        s1 += 't';
        s1 += 'h';
        System.out.println(s1);
        s1 += 10;
        System.out.println(s1);

        System.out.println();

        // STRINGS WITH NUMBERS
        // left to right evaluate hota h
        System.out.println("hello" + 10 + 20); // hello1020
        System.out.println(10 + 20 + "hello" + 10 + 20); // 30hello1020

        System.out.println();

        // SPLIT METHOD
        String s4 = "abc def ghi jkl";

        // this is a array of strings
        String[] partsOfS4 = s4.split(" ");

        for (String strng : partsOfS4)
            System.out.println(strng);
    }
}