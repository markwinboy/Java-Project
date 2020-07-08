package ru.nsu.project1;
//задание 1 занятие 2
public class Main {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(sum(n));
    }

    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
