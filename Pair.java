package com.program.dynamic.programming;

/**
 * Created by rrohit on 13/10/16.
 */
public class Pair {

    public static int pairCount(int arr[], int target) {

        int pairCount = 0;
        if (arr.length == 0 || arr.length == 1) {
            return pairCount;
        }

        int start = 0, end = arr.length-1;
        int currentSum = 0;

        while (start < end) {

            currentSum = arr[start] + arr[end];
            if (currentSum >= target) {
                pairCount += end - start;
                end--;
            } else {
                start++;
            }


        }
        return pairCount;
    }

    public static void main(String args[]) {
        int arr[] =  {2, 3, 4, 10, 12, 30, 45};
        System.out.println(pairCount(arr, 40));
    }

}
