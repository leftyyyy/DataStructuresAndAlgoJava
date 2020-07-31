package com.leftyyyy;

import java.math.BigInteger;
import java.util.Scanner;

public class LongFibonacciNumberLastDigit {
    private static BigInteger getFibonacci(int n){
        double five = 5;
        double tmp = (1/Math.sqrt(five))*(Math.pow((1+Math.sqrt(five))/2, (double) n) - Math.pow((1-Math.sqrt(five))/2, (double) n));
        return BigInteger.valueOf(Long.valueOf((long) tmp));
    }

    private static int getLastDigit(int n){
        int[] arr = new int[60];
        for(int i=0;i<60;i++){
            arr[i]=getFibonacci(i).mod(BigInteger.valueOf(10)).intValue();
        }
        return arr[n%60];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getLastDigit(n));
    }
}
