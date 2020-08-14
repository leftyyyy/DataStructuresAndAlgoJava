package com.leftyyyy;

import java.math.BigInteger;
import java.util.Scanner;

public class FindLCM {

    private static BigInteger getLcm(BigInteger a, BigInteger b){
        return (a.multiply(b)).divide(getGcd(a, b));
    }
    private static BigInteger getGcd(BigInteger a, BigInteger b){
        if(b.compareTo(BigInteger.ZERO)==0){
            return a;
        }
        BigInteger res = new BigInteger(String.valueOf(getGcd(b, a.mod(b))));
        return res;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = new BigInteger(String.valueOf(scanner.nextBigInteger()));
        BigInteger b = new BigInteger(String.valueOf(scanner.nextBigInteger()));
        System.out.println(getLcm(a, b));
        
    }
}