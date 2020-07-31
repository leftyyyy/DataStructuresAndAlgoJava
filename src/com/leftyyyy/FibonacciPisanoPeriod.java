package com.leftyyyy;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciPisanoPeriod {
    //add a -- first number of fibo and b-- second number of fibo and make it equal to c.
    //when you'll enter the loop c will be mod of that number (m), pisano number.
    //make a=b and b=c; then compare if you hit 01 sequence, if yes return that index+1, i.e length of pisano
    private static int getPisano(int m){
        BigInteger a, b, c;
        a = BigInteger.valueOf(0);
        b = BigInteger.valueOf(1);
        c = a.add(b);
        for(int i=0; i<m*m; i++){
            c = (a.add(b)).mod(BigInteger.valueOf(m));
            a = b;
            b = c;
            if(a.compareTo(BigInteger.ZERO)==0 && b.compareTo(BigInteger.ONE)==0){
                return i+1;
            }
        }
        return -1;
    }

    //algo for this is given in the question
    private static BigInteger pisanoFibo(BigInteger n, int m){
        BigInteger remainder = new BigInteger(String.valueOf(n.mod(BigInteger.valueOf(getPisano(m)))));
        BigInteger first = new BigInteger(String.valueOf(0));
        BigInteger second = new BigInteger(String.valueOf(1));
        BigInteger res = remainder;
        for (BigInteger i = BigInteger.valueOf(0);i.compareTo(remainder) < 0;i = i.add(BigInteger.ONE)){
            res = (first.add(second)).mod(BigInteger.valueOf(m));
            first = second;
            second = res;
        }
        return res.mod(BigInteger.valueOf(m));
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BigInteger n = new BigInteger(String.valueOf(scanner.nextBigInteger()));
        int m = scanner.nextInt();
        System.out.println(pisanoFibo(n, m));
    }
}
