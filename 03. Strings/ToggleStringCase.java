public class ToggleStringCase {
    public static void main(String[] args) {
        String str = "aAbBcC";
        System.out.println(toggleCase(str));
    }

    public static StringBuilder toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch -= 32;
                sb.append(ch);
            } else {
                ch += 32;
                sb.append(ch);
            }
        }
        return sb;
    }
}
