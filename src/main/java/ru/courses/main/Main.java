package ru.courses.main;

public class Main {
    public static void main(String[] args) {
        String x = "2";
        String y = "3";
        double pow = StringPow(x,y);
        System.out.println(pow);
    }

    public static double StringPow(String x, String y) {
        int doubleX = parseInt(x);
        int doubleY = parseInt(y);
        return pow(doubleX, doubleY);
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    private static double pow(double a, double b) {
        return Math.pow(a,b);
    }
}