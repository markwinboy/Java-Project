package ru.nsu.lesson6_1;

public class MultiplierThreadMatrix extends Thread{
    private int[][] matrix;
    private int[][] matrix2;
    private String[][] result;
    private int firstIndex;
    private int lastIndex;
    private int sumLength;

    public MultiplierThreadMatrix(int[][] matrix, int[][] matrix2, String[][] result, int firstIndex , int lastIndex) {
        this.matrix = matrix;
        this.matrix2 = matrix2;
        this.result = result;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        sumLength = matrix2.length;

    }
    @Override
    public void run() {
        int colCount = matrix2[0].length;
        for (int index = firstIndex; index < lastIndex; ++index)   {
            int sum = 0;
            for (int i = 0; i < sumLength; ++i){
                sum += matrix[index/colCount][i] * matrix2[i][index%colCount];
            }
            result[index/colCount][index%colCount] = String.valueOf(sum);
        }
    }
}
