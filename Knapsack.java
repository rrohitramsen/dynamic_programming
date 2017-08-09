package com.program.dynamic.programming;

public class Knapsack {
	
	private static int table[][];
	private static int n;
	/**
	 * Time : O(N * C )
	 * Space : O (N * C)
	 * @param capacity
	 * @param w
	 * @param v
	 * @return
	 */
	public static int knapsackSol(int capacity, int [] w, int v []) {
		
		table = new int[v.length+1][capacity+1];
		n = w.length;
		
		return knapsackDP(0, capacity, w, v);
	}
	 
	static int max(int a, int b) {
	    return a > b ? a : b;
	}

	/**
	 * Recursive Solution.
	 *
	 * Time Complexity : O(2^n).
	 * @param w
	 * @param wt
	 * @param val
	 * @param n
	 * @return
	 */
	public static  int knapsack(int w, int wt[], int val[], int n) {

		if (w == 0 || n == 0) {
			return 0;
		}

		if (wt[n-1] > w) {
			return knapSack(w, wt, val, n-1);
		} else {
			return max(val[n-1] + knapSack(w - wt[n-1], wt, val, n-1),
					knapsack(w, wt, val, n-1));
		}
	}

	static int knapsackDP(int i, int w, int [] wt, int []v){
	    
		if (i >= n) {
	    	table[i][w] = 0;
			return table[i][w];
	    }
	 
	    if (wt[i] > w)
	    	return table[i+1][w] = knapsackDP(i + 1, w, wt, v);
		else
			return table[i+1][w] = max(knapsackDP(i + 1, w, wt, v), knapsackDP(i + 1, w - wt[i], wt, v) + v[i]);
		
	}
	
	// Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n) {
     
    int i, w;
    int table[][] = new int[n+1][W+1];
      
     // Build table K[][] in bottom up manner
     for (i = 0; i <= n; i++) {
         for (w = 0; w <= W; w++)
         {
             if (i==0 || w==0)
            	 table[i][w] = 0;
             else if (wt[i-1] <= w)
            	 table[i][w] = max(val[i-1] + table[i-1][w-wt[i-1]],  table[i-1][w]);
             else
            	 table[i][w] = table[i-1][w];
         }
      }
      
      return table[n][W];
    }
	
	
	
	public static void main(String[] args) {
		int weight[] = new int[7];
		weight[0] = 9;
		weight[1] = 6;
		weight[2] = 1;
		weight[3] = 2;
		weight[4] = 5;
		weight[5] = 4;
		
	    int value[] = new int[7];
	    value[0] = 11;
	    value[1] = 10;
	    value[2] = 5;
	    value[3] = 7;
	    value[4] = 12;
	    value[5] = 8;
	 
	    /*
	     * Set all values of 2D matrix CostTable to Minus 1
	     */
	    int capacity = 10;
	    System.out.println(knapsackSol(capacity, weight, value));
	    
	    System.out.println(knapSack(capacity, weight, value, weight.length));

		System.out.println( knapsack(capacity, weight, value, weight.length-1));
	}

}
