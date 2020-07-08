package ru.nsu.project1;
//задаие 2 занятие 2
public class Ex2 {
    public static void main(String[] args) {
        int[] array = {10, 20, 1, 13, 30, 36, 100, 50, 21, 12};
        int num = 0;
        System.out.println(sort(array));
        int[] a = sort(array);
        for(int i =0;i<array.length;i++){
            System.out.println(a[i]);
        }
    }

    public static int[] sort(int[] array) {
            for(int j = 0; j < array.length; j++){
                for (int i = j+1; i < array.length; i++) {
                    if (array[j] > array[i]) {
                        int a=array[i];
                        array[i]=array[j];
                        array[j] = a;
                    }
                }
            }
        return array;
    }
}

