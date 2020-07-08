package ru.nsu.lesson6_1;

public class Matrix {

    public static String[] multiplyVector(int[][] matrix,int[] vector) {
        int count = 0;
        String[] vectorNew = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                count += vector[j] * matrix[i][j];
            }
            vectorNew[i] = String.valueOf(count);
            count = 0;
        }

        return vectorNew;
    }

    public static String[][] multiplyMatrixes(int[][] matrix, int[][] matrix1) {
        int count = 0;
        String[][] matrixNew = new String[matrix.length][matrix1[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                for(int k = 0; k<matrix[0].length;k++){
                    count += matrix[i][k] * matrix1[k][j];
                }
                matrixNew[i][j] = String.valueOf(count);
                count = 0;
            }

        }

        return matrixNew;
    }

    public static String[] multiplyMatrixVector(int[][] matrix,int[] vector, int threadCount) throws InterruptedException {
        String[] result = new String[matrix.length];
        int cellsForThread = (matrix.length) / threadCount;
        int firstIndex = 0;
        MultiplierThreadVector[] multiplierThreadVectors = new MultiplierThreadVector[threadCount];
        for (int threadIndex = threadCount - 1; threadIndex >= 0; --threadIndex) {
            int lastIndex = firstIndex + cellsForThread;
            if (threadIndex == 0) {
                lastIndex = matrix.length;
            }
            multiplierThreadVectors[threadIndex] = new MultiplierThreadVector(matrix, vector, result, firstIndex, lastIndex);
            multiplierThreadVectors[threadIndex].start();
            firstIndex = lastIndex;
        }
        for (MultiplierThreadVector mT : multiplierThreadVectors) {
            mT.join();
        }
        return result;
    }

    public static String[][] multiplyMM(int[][] matrix,int[][] matrix1, int threadCount) throws InterruptedException {
        int row = matrix.length;
        int col = matrix1[0].length;
        String[][] result = new String[row][col];
        int cellsForThread = (row * col) / threadCount;
        int firstIndex = 0;
        MultiplierThreadMatrix[] multiplierThreads = new MultiplierThreadMatrix[threadCount];
        for (int threadIndex = threadCount - 1; threadIndex >= 0; --threadIndex) {
            int lastIndex = firstIndex + cellsForThread;
            if (threadIndex == 0) {
                lastIndex = row*col;
            }
            multiplierThreads[threadIndex] = new MultiplierThreadMatrix(matrix, matrix1, result, firstIndex, lastIndex);
            multiplierThreads[threadIndex].start();
            firstIndex = lastIndex;
        }
        for (MultiplierThreadMatrix mT : multiplierThreads) {
            mT.join();
        }
        return result;

    }
}
