package com.dailyInterviewProblems;
/*
Hi, here's your problem today. This problem was recently asked by Microsoft:

You are given an array of integers in an arbitrary order. Return whether or not it is possible to make the array non-decreasing by modifying at most 1 element to any value.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example:

[13, 4, 7] should return true, since we can modify 13 to any value 4 or less, to make it non-decreasing.

[13, 4, 1] however, should return false, since there is no way to modify just one element to make the array non-decreasing.

Here is the function signature:

def check(lst):
  # Fill this in.

print check([13, 4, 7])
# True
print check([5,1,3,2,5])
# False

Can you find a solution in O(n) time?
 */

import java.util.Scanner;
/*
approach-->
    if len of array is less than 2--->return true... we can easily make it increasing in just 1 modification.

    now when we need to do modification?
    when the first element of array is bigger than second element of array (arr[i]<arr[i-1]) -- we're starting indexing from 1
    now again, there is two case, whether we wanna modify first element or second element (arr[i-1] or arr[i])
    for example: [2,1,3] we can make 2-->0 or we can make 1-->2
    now again one more case, [1,2,0]--> in such case we have to move arr[i+1] up because arr[i+1] is smaller than arr[i-1]
    so this becomes [1,2,0]-->[1,2,2]
    now what happens if arr[i-1] is smaller than arr[i+1] i.e [0,2,1]
    now we can move the arr[i] down and make it [0,1,1] or we can move arr[i+1] up and make it [0,2,2]-->both of the cases looks good
    so what we do?
    so in this case, we'll go with moving arr[i] down because we don't know what number we will encounter later in the array
    in above given case it works in both cases, but it might not every-time.
    for example--> [0,4,1,2] ---> in this case if we'll move up arr[i+1] and make it [0,4,4,2] well it works till [0,4,4] but in next iteration this fails,
    so to be safe side every-time. we'll always move arr[i] down, for this case, [0,1,1,2]

 */

public class NonDecreasingArrayWithSingleModification {
    private static boolean solutionStrictlyDecreasing(int[] arr){
        if(arr.length<=2){
            return true;
        }
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                if(i==1 || arr[i-2]<=arr[i]){
                    arr[i-1]=arr[i];
                    count = count + 1;
                }else {
                    arr[i] = arr[i - 1];
                    count = count + 1;
                }
            }
        }
        return count<=1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        if(solutionStrictlyDecreasing(arr)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
