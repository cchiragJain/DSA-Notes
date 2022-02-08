import java.util.*;

public class PrintSubsequences {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		printSS(str, "");
	}

	public static void printSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String restOfQuestion = ques.substring(1);

		printSS(restOfQuestion, ans + ch);
		printSS(restOfQuestion, ans + "");
	}
}