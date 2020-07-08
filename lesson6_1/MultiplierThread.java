package ru.nsu.lesson6_1;

public class MultiplierThread extends Thread {
    private int[][] matrix;
    private int[] vector;
    private String[] resultVector;
    private int index;
    private int sumLength;

    public MultiplierThread(int[][] matrix,int[] vector, String[] resultVector, int index) {
        this.matrix  = matrix;
        this.vector = vector;
        this.resultVector = resultVector;
        this.index   = index;
        sumLength = vector.length;
    }
    private void calcValue(int row) {
        int sum = 0;
        for (int i = 0; i < sumLength; ++i){

            sum += matrix[row][i] * vector[i];
        }
        resultVector[row] = String.valueOf(sum);
    }

    @Override
    public void run()
    {
            calcValue(index);
    }

}
