package ru.nsu.project1;
//задача 3 занятие 2
public class Ex3 {
    public static void main(String[] args) {
        int n = 4;
        int x = 2;
        System.out.println(degree(x,n));
    }
    public static int degree(int x,int n){
        if (n>0){
            return x*degree(x,n-1);
        }
        return 1;
    }
}
