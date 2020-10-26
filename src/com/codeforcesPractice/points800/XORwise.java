package com.codeforcesPractice.points800;

import java.util.Scanner;

public class XORwise {
    private static int findX(int A, int B){
        int j = 0, x = 0;
        while (A != 0 || B != 0) {
            if ((A % 2 == 1) && (B % 2 == 1)) {
                x += (1 << j);
            }
            A >>= 1;
            B >>= 1;
            j += 1;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int j=0;
        int[] res = new int[t];
        while(j<t){
            int i = 0;
            int[] numbers = new int[2];
            while(i<2){
                numbers[i] = sc.nextInt();
                i=i+1;
            }
            int x = findX(numbers[0], numbers[1]);
            res[j] = ((numbers[0]^x) + (numbers[1]^x));
            j=j+1;
        }

        for(int k=0; k<t; k++){
            System.out.println(res[k]);
        }
    }
}
