public class StringInterningAndImmutability {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true

        System.out.println();

        s1 = "bye";
        System.out.println(s1);
        System.out.println(s2);
    }
}
