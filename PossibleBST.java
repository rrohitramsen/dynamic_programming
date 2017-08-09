package com.program.dynamic.programming;

/**
 * @author rrohit
 */
public class PossibleBST {
	
	private static int count = 0;
	
	public static int possibleBst(int n){
		if (n==0 || n==1) {
			return n;
		}
		
		int input[] = new int[n];
		for (int i=0; i<n; i++){
			input[i] = i+1;
		}
		return possibleBst(null, input);
	}
	
	private static int possibleBst(int output[], int [] input) {
		int sum=0;
		
		if (input.length == 0) {
			return isBst(output) ? 1 : 0;
		}
		
		for (int i=0; i<input.length; i++) {
			
			int [] next = null;
		
			if (output != null) {
				next = new int[output.length+1];
				System.arraycopy(output, 0, next, 0, output.length);
				
			}else {
				next = new int[1];
			}
			next[next.length-1] = input[i];
			
			int remain[] = new int [input.length-1];
			System.arraycopy(input, 0, remain, 0, i);
			System.arraycopy(input, i+1, remain, i, input.length - (i +1));
			
			sum += possibleBst(next, remain);
		}
		return sum;
	}
	
	/**
	 * BST(i) = Left->BST(i-1)* Right->BST(n-i)
	 * BST(n) = BST(1) + BST(2) + BST(3)....+BST(n).
	 * 
	 * BST(n) = Summation (i=1 to N) BST(i-1)*BST(n-i);
	 * 
	 * Time Complexity is 2^n with lots of repetition. Lets solve this using DP
	 * @param n
	 * @return
	 */
	public static int bst(int n) {
		
		int sum=0;
		if(n==0 || n==1) {
			count++;
			return 1;
		}
		
		for (int i=1; i<=n; i++) {
			count++;
			sum += bst(i-1)*bst(n-i);
		}
		
		return sum;
	}
	
	/**
	 * Using table complexity will be reduced to linear
	 * 
	 * Time = n*(n+1)/2 , which is O(n^2)
	 * Space = O(n)
	 * @param n
	 * @return
	 */
	public static Long bstDP(int n) {
		if (n==0 || n==1){
			return 1L;
		}
		
		Long table [] = new Long[n];
		
		return bstDP(n, table);
	}
	
	public static Long bstDP(int n, Long [] table) {
		Long sum=0L;
		if (n==0 || n==1) {
			table[0] = table[1] = 1L;
			count++;
			return 1L;
		}
		for (int i=1; i<= n; i++) {
			count++;
			
			if (table[i-1] == null ) {
				table[i-1] = bstDP(i-1, table);
			}
			if (table[n-i] == null) {
				table[n-i] = bstDP(n-i, table);
			}
			
			sum += table[i-1] * table[n-i];
		}
		return sum;
	}

	private static boolean isBst(int[] output) {
		for(int i : output){
			System.out.print(i);
		}
		System.out.println();
		return true;
	}
	
	public static void main(String[] args) {
		//System.out.println(possibleBst(4));
		System.out.println(bstDP(78));
		System.out.println("Count ="+count);
	}

}
