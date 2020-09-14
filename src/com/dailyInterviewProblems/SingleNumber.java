package com.dailyInterviewProblems;

import java.util.Scanner;

/*
        Hi, here's your problem today. This problem was recently asked by Facebook:

        Given a list of numbers, where every number shows up twice except for one number, find that one number.

        Example:
        Input: [4, 3, 2, 4, 1, 3, 2]
        Output: 1
        Here's the function signature:

        def singleNumber(nums):
        # Fill this in.

        print singleNumber([4, 3, 2, 4, 1, 3, 2])
        # 1

        Challenge: Find a way to do this using O(1) memory.
*/
/*
    we can use XOR operation for this:
    XOR property-->
        1 xor 1 = 0
        0 xor 0 = 0
        x xor x = 0

        i.e.

        xor of any two numbers is 0

        ----
        1 xor 0 = 1
        0 xor 1 = 1
        x xor 0 = x

        i.e.
        XOR of any number with zero is that number itself
        ----

        1 xor 2 = 3 (this compares in binary i.e. 001 xor 010 = 011)
        3 xor 1 = 2

        a xor b = c
        c xor a = b

        i.e. --- a is common so it becomes zero
        ------

        in this problem,

        let's say 1,2,1,2,4

        1 xor 2 xor 1 xor 2 xor 4
        |           |
        |___________|
              |
              0

        2 xor 2 xor 4
        |_____|
           |
           0

        0 xor 4 = 4 (answer)
 */
public class SingleNumber {
    private static int singleNumber(int[] arr){
        int res = 0;
        int i=0;
        while(i<arr.length){
            res=res^arr[i];
            i=i+1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(singleNumber(arr));
    }
}
