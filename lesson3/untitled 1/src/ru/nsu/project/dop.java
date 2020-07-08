package ru.nsu.project;

import java.util.ArrayList;

public class dop {
    public static void main(String[] args) {
        int[][] array = {{0,1,2,3,4,5}, {0,0,0,0,8,1}, {228,9,8,7,6,9},{0,0,0,0,1,1},{0,0,0,0,0,0}};
        System.out.println(longer(array));
    }
    public static int longer(int[][] array) {
        int sum = 0;
        int all = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array[j].length; i++) {
                if (array[j][i] == 0) {
                    sum += 1;
                    if (i + 1 == array[j].length && all<sum) {
                        all = sum;
                        sum = 0;
                    }
                } else {
                    if (all < sum) {
                        all = sum;
                        sum = 0;
                    }
                }
            }
            sum = 0;
        }
        return all;
    }
}
