package com.program.dynamic.programming;


/**
 * Time : O(2^n)
 * Number of Subsets : (2^n) - 1;
 * 
 * C (n, k) = C(n-1, k-1) + C(n-1, k) ... with bob and without bob.
 * @author rrohit
 *
 */
public class SubSets {

    public static void printSubset(String input){

        subsets("", input);
    }

    private static void subsets(String output, String input) {

        if (input.equals("")) {
            System.out.println(output);
        }else {
        		//add to subset and remove from input, recur
                subsets(output+input.charAt(0), input.substring(1)); // with bob c (n-1, k-1)
                //do not add to subset and remove from input, recur
                subsets(output, input.substring(1)); // without bob C(n-1, k)
        }
    }

    public static void main(String[] args) {
        SubSets.printSubset("abcd");
    }
}
