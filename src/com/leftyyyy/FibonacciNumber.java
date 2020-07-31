package com.leftyyyy;
import java.lang.Math;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciNumber {
    private static BigInteger getFibonacci(int n){
        double five = 5;
        double tmp = (1/Math.sqrt(five))*(Math.pow((1+Math.sqrt(five))/2, (double) n) - Math.pow((1-Math.sqrt(five))/2, (double) n));
        return BigInteger.valueOf(Long.valueOf((long) tmp));
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getFibonacci(n));
    }
}
