package com.program.dynamic.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rrohit
 */
public class SubsetSum {
	
	/**
	 * Time : O(n-log-n)
	 * Space : O(1)
	 * @param arr
	 * @param sum
	 * @return
	 */
	public static boolean subsetSum(int arr[], int sum){
		
		if (sum == 0 | arr.length == 0) {
			return true;
		}
		
		if (arr.length == 1) {
			return arr[0] == sum;
		}
		
		Arrays.sort(arr);
		
		int tempSum=0;
		int left = 0, right = arr.length-1;
		
		while(left <= right){
			tempSum = arr[left] + arr[right];
			if (tempSum == sum) {
				System.out.println("Arr = [ "+arr[left]+" ] ["+arr[right]+"]  = "+tempSum);
				return true;
			}else if (tempSum > sum) {
				right--;
			}else {
				left++;
			}
		}
		return false;
	}
	
	
	/**
	 * Time : O(n)
	 * Space : O(n)
	 * @param arr
	 * @param sum
	 * @return
	 */
	public static boolean subsetSumMap(int arr[], int sum) {
		
		if (arr.length == 0 || sum == 0) {
			return true;
		}
		
		if (arr.length == 1) {
			return arr[0] == sum;
		}
		
		Map<Integer, Integer> pairMap = new HashMap<>();
		
		for (int i=0; i<arr.length; i++) {
			
			if (pairMap.containsKey(arr[i])) {
				return true;
			}
			pairMap.put(sum-arr[i], arr[i]);
		}
		
		return false;
	}
	
	/**
	 * Time : O(n-log-n)
	 * Space : O(1)
	 * @param arr
	 * @param sum
	 * @return
	 */
	public static void subsetSumPairs(int arr[], int sum){
		
		if (arr.length == 0) {
			System.out.println("Empty Array");
			return;
		}
		
		if (arr.length == 1 && arr[0] == sum) {
			System.out.println("Pair = "+arr[0]);
			return;
		}
		
		Arrays.sort(arr);
		
		int tempSum = 0;
		int left = 0, right = arr.length-1;
		
		while (left <= right) {
			tempSum = arr[left] + arr[right];
			if (tempSum == sum) {
				System.out.println("Arr = [ "+arr[left]+" ] ["+arr[right]+"]  = "+tempSum);
				left++;
				right--;
			} else if (tempSum > sum) {
				right--;
			} else {
				left++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int input1[] = {1};
		int input2[] = {1,3,9,2};
		int input3[] = {8,8,12,9,7};
		//System.out.println(subsetSum(input2,5));
		subsetSumPairs(input3, 16);
	}

}
