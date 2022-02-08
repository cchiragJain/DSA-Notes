public class StringCompression {
    public static void main(String[] args) {
        String str = "aaabbcccddaeef";
        StringBuilder sb = compression1(str);
        System.out.println(sb);

        sb = compression2(str);
        System.out.println(sb);

    }

    public static StringBuilder compression1(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                sb.append(str.charAt(i));
            }
        }
        return sb;
    }

    public static StringBuilder compression2(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(count);
                    count = 1;
                }
                sb.append(str.charAt(i));
            }
        }

        if (count > 1) {
            sb.append(count);
        }
        return sb;
    }

}