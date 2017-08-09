package com.program.dynamic.programming;

/**
 * @author rrohit
 */
public class ConvertIntoPalindrome {
	
	/**
	 * This method will add characters to make the given word a palindrome.
	 * Time : O(n+n) = O(n)
	 * Space: O(n)
	 * @param word
	 * @return
	 */
	public static String convertIntoPalindrome(String word) {
		
		if (word == null || word.isEmpty()) {
			return "a";
		}
		
		int wordlen = word.length();
		if (wordlen == 1){
			return word;
		}
		
		boolean match[] = new boolean[wordlen];
		int left = 0, right = wordlen-1, matchCount = 0;
		
		while (left < right) {

			if (word.charAt(left) == word.charAt(right)) {
				match[left] = match[right] = true;
				matchCount += 2;
				left++;
				right--;
			} else {
				match[right] = false;
				right--;
			}
		}
		
		/**
		 * In case word it self is a palindrome.
		 */
		if (matchCount == wordlen || matchCount == wordlen-1 && match[wordlen-1]) {
			return word;
		}
		int j = wordlen-1;
		StringBuilder sb = new StringBuilder();
		while (j > right) {
			
			if (!match[j]) {
				sb.append(word.charAt(j));
			}
			j--;
		}
		
		String palindrome = sb.append(word).toString();
		
		return palindrome;
		
	}
	
	/**
	 * Condition 1 : If First and Last chars should match.
	 * Condition 2 : Substring (excluding first and last chars) must be palindrome.
	 * @param word
	 * @return
	 */
	public static boolean palindrome(String word) {
		
		if (word == null) {
			return false;
		}
		
		if (word.isEmpty() || word.length() == 1) {
			return true;
		}
		
		if (word.charAt(0) != word.charAt(word.length()-1)){
			return false;
		}
		return palindrome(word.substring(1, word.length()-1));
			
	}
	
	public static void main(String[] args) {

		//System.out.println(convertIntoPalindrome("poaop"));
		System.out.println(convertIntoPalindrome("madam"));
	}

}
