public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb);

        System.out.println(sb.charAt(0));

        sb.setCharAt(0, 'd');
        System.out.println(sb);

        sb.insert(2, 'y');
        System.out.println(sb);

        sb.deleteCharAt(2);
        System.out.println(sb);

        sb.append('g');
        System.out.println(sb);

        sb.append("hello");
        System.out.println(sb);

    }
}
