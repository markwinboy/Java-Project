package ru.nsu.lesson6_1;

public class MultiplierThreadVector extends Thread {
    private int[][] matrix;
    private int[] vector;
    private String[] resultVector;
    private int firstIndex;
    private int lastIndex;
    private int sumLength;

    public MultiplierThreadVector(int[][] matrix, int[] vector, String[] resultVector, int firstIndex , int lastIndex) {
        this.matrix  = matrix;
        this.vector = vector;
        this.resultVector = resultVector;
        this.firstIndex   = firstIndex;
        this.lastIndex   = lastIndex;
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
        int colCount = vector.length;
        for (int index = firstIndex; index < lastIndex; ++index)   {
            calcValue(index%colCount);
        }
    }

}
