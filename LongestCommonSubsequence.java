package com.program.dynamic.programming;
 /*
 * We have two strings X = {"ABCBDAB"}  and Y = {"BDCABA"} 
 * Output must be : LCS(X, Y) = {"BCBA", "BDAB", "BCAB"}  
 * 
 * Solution :
 * i = X.length() and j = Y.lenght()    
 * LCS(i,j), 
 *    if X[i-1] == Y[j-1], then LCS(X[i-1], Y[j-1])
 *    if X[i-1] != Y[j-1], then Max(LCS(X[i-1], Y[j]), LCS(X[i], Y[j-1]))
 * 
 * @author rrohit
 * */
public class LongestCommonSubsequence {
	
	public static int LCSLength(String X, String Y){
		return LCSLength(X.toCharArray(), X.length(), Y.toCharArray(), Y.length());
	}
	
	/*
	 * This is only Recursive Solution, very time consuming O(2^n). Now we need to add memorization
	 * technique convert this into Dynamic Programming. And reduce the time complexity to polynomial instead of
	 * exponential. 
	 */
	private static int LCSLength(char[] X, int i, char[] Y, int j) {
		
		if (i==0 || j==0){
			return 0;
		} else if (X[i-1] == Y[j-1]) {
			return 1 + LCSLength(X, i-1, Y, j-1);
		} else {
			return Math.max(LCSLength(X, i-1, Y, j), LCSLength(X, i, Y, j-1));
		}
	}
	
	/* Dynamic Programming Solution
	 * https://www.youtube.com/watch?v=wJ-rP9hJXO0
	 * 
	 * Using memorization, LCS[][] = new int[m][n]; where m = X.lenth() and n = Y.length()
	 * LCS[0][j] = 0, for all j, coz we are not considering X only taking Y
	 * LCS[i][0] = 0, for all i, coz we are not considering Y only taking X
	 * LCS[i][j] = 1 + LCS(i-1, j-1) if X[i-1] == Y[j-1]
	 * LCS[i][j] = max(LCS(i-1,j), LCS(i, j-1)) if X[i-1] != Y[j-1]
	 * 
	 * Bottom Up Construction
	 * Time : O(m*n)
	 * Space : O(m*n)
	 */
	public static int LCSLengthDP(char[] X, char[] Y) {
		int m = X.length;
		int n = Y.length;
		int [][] LCS = new int[m+1][n+1];
		int i,j;
		for (i=0; i<=m; i++){
			LCS[i][0] = 0;
		}
		
		for (j=0; j<=n; j++){
			LCS[0][j] = 0;
		}
		
		for (i=1; i<=m; i++){
			for (j=1; j<=n; j++){
				if (X[i-1]==Y[j-1]) {
					LCS[i][j] = 1 + LCS[i-1][j-1];
				}else{
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		return LCS[m][n];
	}
	
	public static void main(String[] args) {

		String X = "ABCBDAB";
		String Y = "BDCABA";
		System.out.println(LCSLength(X, Y));
		System.out.println(LCSLengthDP(X.toCharArray(), Y.toCharArray()));
	}
	
	


}
