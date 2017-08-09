package com.program.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Time : O(n!), its a factorial, and factorial far bigger then O(2^n)
 * Number of Permutations = (n!)
 * @author rrohit
 *
 */
public class Permute {
	
	private static int COUNT = 0;
	
	public static void permute(String input){
		permutR("", input);
	}
	
	private static void permutR(String output, String input){
		if (input.equals("")) {
			System.out.println(output);
		}else {
			for (int i=0; i<input.length(); i++) {
				String next = output + input.charAt(i);
				String remain = input.substring(0, i) + input.substring(i+1);
				permutR(next, remain);
			}
		}
	}
	
	/**
	 * Here String contains duplicates as well we have to print unique perms.
	 */
	public static void printPerms(String word) {
		
		if (word == null || word.isEmpty()) {
			System.out.println(word);
		}
		
		Map<Character, Integer> map = new HashMap<>();
		buildMap(map, word);
		
		printPerms(map, "", word.length());
	}
	
	private static void printPerms(Map<Character, Integer> map, String output, int remaining) {
		
		if (remaining == 0) {
			COUNT++;
			System.out.println(output);
			return;
		}
		
		for (Character chr : map.keySet()) {
			COUNT++;
			int count = map.get(chr);
			if (count > 0) {
				map.put(chr, count-1);
				printPerms(map, output + chr, remaining-1);
				map.put(chr, count);
			}
		}
		
	}

	private static void buildMap(Map<Character, Integer> map, String word) {
		
		int i=0, len = word.length();
		while (i<len) {
			char key = word.charAt(i);
			if (!map.containsKey(key)) {
				map.put(key, 0);
			}
			map.put(key, map.get(key)+1);
			i++;
		}
	}

	public static void main(String[] args) {
		//Permute.permute("abcd");
		
		Permute.printPerms("aaabbb");
		System.out.println("COUNT = "+COUNT);
	}

}
