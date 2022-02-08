import java.util.*;

public class PrintPermutations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		printPerm(str, "");
	}

	public static void printPerm(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String remainingString = ques.substring(0, i) + ques.substring(i + 1);
			printPerm(remainingString, ans + ch);
		}
	}
}