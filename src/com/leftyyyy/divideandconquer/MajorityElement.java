package com.leftyyyy.divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MajorityElement {
    private static int getMajorityElement(Integer[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        /*
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int c : a) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            }
            else {
                countMap.put(c, 1);
            }
        }
        int maxElement = Collections.max(countMap.values());
        if(maxElement>((right+1)/2)){
            return 1;
        }

        this will give TLE
         */
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(a));
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int index = 0; index < A.size(); index++){
            int key = A.get(index);
            hashMap.put(key, hashMap.getOrDefault(key, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if(entry.getValue() > A.size()/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if ((getMajorityElement(a, 0, a.length-1) != -1) || n==1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
