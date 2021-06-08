import java.util.Scanner;

public class firstCode {
	public static void main(String[] args) {
		double totalTokens = 0;
		double totalPalindromes = 0;
		int maximum = 0;
		String longestPalindrome = "null";
		
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String token = input.next().toLowerCase();
			totalTokens++;
			String reverse = "";
			int length = token.length();
			for (int i = length - 1; i >= 0; i--) {
				reverse = reverse + token.charAt(i);
			}
			if (token.equals(reverse) && token.length() > 1) {
				totalPalindromes++;
				if (token.length() > maximum) {
					maximum = token.length();
					longestPalindrome = token;
				}
			}
		}
		if (totalTokens == 1) {
			System.out.println(totalTokens + " token");
		}
		else {
			System.out.println(totalTokens + " tokens");
		}
		if (totalPalindromes == 1) {
			System.out.println(totalPalindromes + " palindrome");
		}
		else {
			System.out.println(totalPalindromes + " palindromes");
		}
		if (totalPalindromes >= 1) {
			System.out.println("Longest palindrome: " + longestPalindrome);
		}
	}		
}
