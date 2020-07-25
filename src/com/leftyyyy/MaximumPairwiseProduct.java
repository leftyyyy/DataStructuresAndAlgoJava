package com.leftyyyy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class MaximumPairwiseProduct {
    public static BigInteger MaxProdArr(int[] arr){
        Map<String, BigInteger> map = getMaxSecondMax(arr);
        BigInteger max = map.get("max1");
        BigInteger secMax = map.get("max2");
        return max.multiply(secMax);
    }
    private static Map<String,BigInteger> getMaxSecondMax(int[] intArr){
        Map<String, BigInteger> map = new HashMap<>();
        int max1 = 0;
        int max2= 0;
        for( int i =0;i<intArr.length;i++){
            if(intArr[i] > max1){
                max2 = max1;
                max1 = intArr[i];

            }else if(intArr[i] > max2){
                max2 = intArr[i];
            }
        }
        //System.out.println("Max 1: "+max1);
        //System.out.println("Max 2: "+max2);
        map.put("max1",BigInteger.valueOf(Long.valueOf(max1)));
        map.put("max2", BigInteger.valueOf(Long.valueOf(max2)));
        return map;

    }
    public static void driverMaxProdArr(){

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] intArr = new int[n];
        for(int i=0; i<n;i++){
            intArr[i] = scanner.nextInt();
        }

        //System.out.println(System.currentTimeMillis());
        System.out.println(MaxProdArr(intArr));
        //System.out.print(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        driverMaxProdArr();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
