package com.faangPreparation.dynamicProgramming;
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected,
and it will automatically contact the police if two adjacent
houses were broken into on the same night.

Given a list of non-negative integers nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.



Example 1:
    Input: nums = [2,3,2]
    Output: 3
    Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
                 because they are adjacent houses.

Example 2:
    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

Example 3:
    Input: nums = [0]
    Output: 0

Example 4:
    Input: nums = [1,3,1,3,100]
    Output: 103
    Explantation: 3 (index 1) + 100

Constraints:
    1 <= nums.length <= 100
    0 <= nums[i] <= 1000
 */
public class HouseRobberII {
    private static int solution(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0){
            return 0;
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int i=2;
        int m=Math.max(first, second);
        while(i<nums.length-1){
            m = Math.max(second, first + nums[i]);
            first = second;
            second = m;
            i=i+1;
        }


        int f = nums[1];
        int s = Math.max(nums[1],nums[2]);
        int j = 3;
        int mx = Math.max(f, s);
        while(j<nums.length){
            mx = Math.max(s, f+nums[j]);
            f = s;
            s = mx;
            j = j+1;
        }
        return Math.max(m, mx);
    }

    public static void main(String[] args) {
        int[] input = {1,3,1,3,100};
        int out = solution(input);
        System.out.println(out);
    }
}
