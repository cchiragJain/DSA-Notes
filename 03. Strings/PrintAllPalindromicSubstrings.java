public class PrintAllPalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abccbc";
        printPalindromicSubstrings(str);
    }

    public static void printPalindromicSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (isStringPlaindrome(str.substring(i, j))) {
                    System.out.println(str.substring(i, j));
                }
            }
        }
    }

    public static boolean isStringPlaindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

}
