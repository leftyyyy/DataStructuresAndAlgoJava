package com.dailyInterviewProblems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class SolutionHackerearth {

    static class Pair {
        int min;
        int max;
    }
    static Pair getMinMax(ArrayList<Integer> arr, int n) {
        Pair minmax = new Pair();
        int i;
        if (n % 2 == 0) {
            if (arr.get(0) > arr.get(1)) {
                minmax.max = arr.get(0);
                minmax.min = arr.get(1);
            } else {
                minmax.min = arr.get(0);
                minmax.max = arr.get(1);
            }
            i = 2;
        } else {
            minmax.min = arr.get(0);
            minmax.max = arr.get(0);
            i = 1;
        }
        while (i < n - 1) {
            if (arr.get(i) > arr.get(i+1)) {
                if (arr.get(i) > minmax.max) {
                    minmax.max = arr.get(i);
                }
                if (arr.get(i+1) < minmax.min) {
                    minmax.min = arr.get(i+1);
                }
            } else {
                if (arr.get(i+1) > minmax.max) {
                    minmax.max = arr.get(i+1);
                }
                if (arr.get(i) < minmax.min) {
                    minmax.min = arr.get(i);
                }
            }
            i += 2;
        }
        return minmax;
    }
    private static BigInteger listReduce(ArrayList<Integer> arr, int n, int k){
        for(int i=1;i<=k;i++){
            BigInteger iniSumTmp = BigInteger.valueOf(0);
            for (int item:arr){
                iniSumTmp = iniSumTmp.add(BigInteger.valueOf(item));
            }

            Pair mmx = getMinMax(arr, n);
            int l = mmx.max;
            int s = mmx.min;
            arr.remove(new Integer(mmx.max));
            if(mmx.max%2==0){
                l = l/2;
            }else{
                l = (l/2) + 1;
            }
            arr.add(l);
            arr.remove(new Integer(mmx.min));
            arr.add(s*2);

            BigInteger res_tmp = BigInteger.valueOf(0);
            for (int item:arr){
                res_tmp = res_tmp.add(BigInteger.valueOf(item));
            }

            if(iniSumTmp.compareTo(res_tmp)==-1){
                return iniSumTmp;
            }
        }

        BigInteger res = BigInteger.valueOf(0);
        for (int item:arr){
            res = res.add(BigInteger.valueOf(item));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.nextInt());
        }
        System.out.println(listReduce(arr, n, k));
    }
}
