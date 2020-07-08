package ru.nsu;

import org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.ArrayUtils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodBraunaRobinson {
    public static ArrayList<Double> vList=new ArrayList<Double>();

    private int[][] matrix;
    private int[] vector1;
    private int[] vector2;

    public MethodBraunaRobinson(int[][] matrix,int[]vector1,int[] vector2) {
        this.matrix = matrix;
        this.vector1=vector1;
        this.vector2=vector2;

    }

//    public int[][] getMatrix() {
//        return matrix;
//    }

    public int[] getVector1() {
        return vector1;
    }

    public int[] getVector2() {
        return vector2;
    }

    public void setVector1(int[] vector1) {
        this.vector1 = vector1;
    }

    public void setVector2(int[] vector2) {
        this.vector2 = vector2;
    }

    //    Матрица U от i
    public int[] UI(int rowNumber){
        for (int i =0; i<this.vector2.length;i++){
            this.vector2[i]+=matrix[rowNumber][i];
//            System.out.print(this.vector2[i]+"|");
        }
//        System.out.println();
        return vector2;
    }

    //  Матрица U от j
    public int[] UJ(int rowNumber){
        for (int i =0; i<vector1.length;i++){
            this.vector1[i]+=matrix[i][rowNumber];
//            System.out.print(this.vector1[i]+"|");
        }
//        System.out.println();

        return vector1;
    }


    public double alpha(double k){
        return vector2[j()]/k;
    }

    public int j(){
        int minim = min(vector2);
//         System.out.println(ArrayUtils.indexOf(vector2,minim)+"min");
        return ArrayUtils.indexOf(vector2,minim);
    }


    public double beta(double k){
        return vector1[i()]/k;
    }

    public int i(){
        int maxim = max(vector1);
//        System.out.println(ArrayUtils.indexOf(vector1,maxim)+"max");
        return ArrayUtils.indexOf(vector1,maxim);
    }


    public double v(int k){
        vList.add((beta(k)+alpha(k))/2);
        return (beta(k)+alpha(k))/2;
    }

    public double delta(int k){
//        if (k>1){
        return Math.abs(vList.get(k-2)- vList.get(k-1));
//        }
//        return 0;
    }

    public double epsilon(int k){
        return delta(k)*100/vList.get(k-1);
    }

    public static int max(int[] vec){
        int max = vec[0];
        for (int ktr = 0; ktr < vec.length; ktr++) {
            if (vec[ktr] > max) {
                max = vec[ktr];
            }
        }
        return max;
    }
    public static int min(int[] vec){
        int min = vec[0];
        for (int ktr = 0; ktr < vec.length; ktr++) {
            if (vec[ktr] < min) {
                min = vec[ktr];
            }
        }
        return min;
    }
}
