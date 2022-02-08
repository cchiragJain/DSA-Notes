import java.util.*;

public class PrintEncodings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		printEnc(str, "");
	}

	public static void printEnc(String ques, String ans) {
		// code quality can be improved
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		int firstPart = Integer.parseInt(ques.substring(0, 1));

		if (firstPart > 0) {
			char ch = (char)(96 + firstPart);
			printEnc(ques.substring(1), ans + ch);

			if (ques.length() > 1) {
				int secondPart = Integer.parseInt(ques.substring(0, 2));
				if (secondPart >= 1 && secondPart <= 26) {
					char ch2 = (char)(96 + secondPart);
					printEnc(ques.substring(2), ans + ch2);
				}
			}
		}
	}
}