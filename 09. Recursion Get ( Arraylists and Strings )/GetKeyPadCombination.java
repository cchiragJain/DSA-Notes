import java.util.*;

public class GetKeyPadCombination {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		ArrayList<String> words = getkpc(str);

		System.out.println(words);
	}

	static String[] keyMap = {
		".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"
	};

	public static ArrayList<String> getkpc(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}

		char ch = str.charAt(0);
		String remainingString = str.substring(1);

		ArrayList<String> recursionResult = getkpc(remainingString);

		// can also use keyMap[ch - '0'] or keyMap[ch - 48]
		String currentKey = keyMap[Character.getNumericValue(ch)];

		ArrayList<String> result = new ArrayList<>();
		
		/*  for each character in the currentKey add it to the word of recurionResults 
			ex.
			recursionResult = [v,w,x]
			currentKey = tu
			result = [t + [v,w,x] , u + [v,w,x]]
		*/
		for (int i = 0; i < currentKey.length(); i++) {
			char currentCharacter = currentKey.charAt(i);
			for (String word : recursionResult) {
				result.add(currentCharacter + word);
			}
		}

		return result;

	}
}