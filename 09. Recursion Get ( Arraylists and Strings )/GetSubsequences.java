import java.util.*;

public class GetSubsequences {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		ArrayList<String> result = getss(str);
		System.out.println(result);
	}

	public static ArrayList<String> getss(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		// isolate first character
		char ch = str.charAt(0);
		// get rest of the string
		String restOfString = str.substring(1);

		ArrayList<String> subsequence = getss(restOfString);

		ArrayList<String> result = new ArrayList<>();
		for (String subs : subsequence) {
			result.add("" + subs);
			result.add(ch + subs);
		}

		return result;
	}
}