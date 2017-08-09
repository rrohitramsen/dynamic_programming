package com.program.dynamic.programming;

/**
 * Created by rrohit on 11/10/16.
 */
public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle main = new PascalTriangle();
        main.printPascalTriangle(7);
    }

    public int pascal(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }
        return pascal(i - 1, j - 1) + pascal(i - 1, j);
    }

    /**
     *
     * @param level
     */
    public void printPascalTriangle(int level) {

        for (int i = 0; i < level; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("\t"+pascal(i, j)+" ");
            }
            System.out.println();
        }
    }

}
