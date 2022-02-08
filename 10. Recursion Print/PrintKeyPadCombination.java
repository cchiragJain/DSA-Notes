import java.util.*;

public class PrintKeyPadCombination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		printKPC(str, "");
	}

	static String[] keyMap = {
		".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"
	};

	public static void printKPC(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String restOfQuestion = ques.substring(1);

		String currentKey = keyMap[Character.getNumericValue(ch)];

		for (int i = 0; i < currentKey.length(); i++) {
			printKPC(restOfQuestion, ans + currentKey.charAt(i));
		}
	}
}