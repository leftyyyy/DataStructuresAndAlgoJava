package com.faangPreparation.dynamicProgramming;
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is
that adjacent houses have security system connected and it will automatically
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.



Example 1:
    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                 Total amount you can rob = 1 + 3 = 4.

Example 2:
    Input: nums = [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                 Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:
    0 <= nums.length <= 100
    0 <= nums[i] <= 400
 */
public class HouseRobber {
    private static int solution(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0){
            return 0;
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int i=2;
        int m=Math.max(first, second);
        while(i<nums.length){
            m = Math.max(second, first + nums[i]);
            first = second;
            second = m;
            i=i+1;
        }
        return m;
    }

    public static void main(String[] args) {
        int[] input = {2,7,9,3,1};
        int out = solution(input);
        System.out.println(out);
    }
}
