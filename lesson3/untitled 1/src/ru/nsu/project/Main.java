package ru.nsu.project;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        int[][] array = {{10, 20, 1, 2}, {11, 12, 1, 1},{10, 11, 14, 0}, {1, 0, 0, 0}, {21, 12, 0, 0},{0, 2, 0, 0}};
        int i;
        System.out.println(longer(array));
    }

    public static int longer(int[][] array) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int sum = 0;
        int all = 0;
        for (int j=0;j<array.length;j++){
            for (int i=0; i<array[j].length;i++ ){
                if (array[j][i]==0) {
                    sum += 1;
                }
                if(i!=0){
                    if(array[j][i]!=0 && array[j][i-1]==0){
                        if(all<sum){
                            all=sum;
                            sum=0;
                            break;
                        }
                    }
                }else{
                    if(array[j][i]!=0 && array[j][i+1]==0){
                        if(all<sum){
                            all=sum;
                            sum=0;
                            break;
                        }
                    }
                }
                if (sum==array[j].length){
                    all=sum;
                    sum=0;}

            }
        }
        return all;
    }
}

