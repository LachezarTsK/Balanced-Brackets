import java.util.Scanner;
import java.util.Stack;

public class Solution {

	private static String isBalanced(String input) {

		String result = "YES";
		Stack<Character> openingBrackets = new Stack<Character>();

		for (int i = 0; i < input.length(); i++) {

			char bracket = input.charAt(i);
			if (bracket == '{' || bracket == '(' || bracket == '[') {
				openingBrackets.push(input.charAt(i));
			} else {
				if (openingBrackets.isEmpty()) {
					result = "NO";
					break;
				}
				char balancingBracket = reverseBracket(openingBrackets.pop());
				if (balancingBracket != bracket) {
					result = "NO";
					break;
				}
			}
		}
		if (!openingBrackets.isEmpty()) {
			result = "NO";
		}
		return result;
	}

	private static char reverseBracket(char bracket) {
		if (bracket == '{') {
			return '}';
		}
		if (bracket == '(') {
			return ')';
		}
		return ']';
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int testCases = reader.nextInt();

		for (int i = 0; i < testCases; i++) {
			String input = reader.next();
			System.out.println(isBalanced(input));
		}
		reader.close();
	}
}
