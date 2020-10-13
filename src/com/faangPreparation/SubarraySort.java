package com.faangPreparation;

/*
Given an integer array nums,
you need to find one continuous subarray that
if you only sort this subarray in ascending order,
then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.


Example 1:
    Input: nums = [2,6,4,8,10,9,15]
    Output: 5
    Explanation: You need to sort [6, 4, 8, 10, 9]
    in ascending order to make the whole array sorted in ascending order.

Example 2:
    Input: nums = [1,2,3,4]
    Output: 0

Example 3:
    Input: nums = [1]
    Output: 0

Constraints:
    1 <= nums.length <= 10**4
    -10**5 <= nums[i] <= 10**5
 */
public class SubarraySort {
    private static int findUnsortedSubarray(int[] nums){
        if(nums.length<2){
            return 0;
        }
        int i=0;
        int min=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        boolean flag = false;
        while(i<nums.length){
            if(i==0){
                if(nums[i]<=nums[i+1]){
                    i=i+1;
                    continue;
                }else{
                    min = nums[i];
                    max = nums[i];
                    flag = true;
                }
            }else if(i==nums.length-1){
                if(nums[i]>=nums[i-1]){
                    i=i+1;
                    continue;
                }else{
                    if(flag == false){
                        max = nums[i];
                        min = nums[i];
                        flag = true;
                    }else{
                        if(nums[i]>max){
                            max = nums[i];
                        }
                        if(nums[i]<min){
                            min = nums[i];
                        }
                    }
                }
            }else{
                if(nums[i]>=nums[i-1] && nums[i]<=nums[i+1]){
                    i=i+1;
                    continue;
                }else{
                    if(flag == false){
                        max = nums[i];
                        min = nums[i];
                        flag = true;
                    }else{
                        if(nums[i]>max){
                            max = nums[i];
                        }
                        if(nums[i]<min){
                            min = nums[i];
                        }
                    }
                }
            }
            i=i+1;
        }
        if(min==Integer.MIN_VALUE && max==Integer.MIN_VALUE){
            return 0;
        }

        //System.out.println("max-->"+max+" originalMaxIndex-->"+originalMaxIndex);
        //System.out.println("min-->"+min+" originalMinIndex-->"+originalMinIndex);
        //System.out.println();
        int minIndex = -1;
        int maxIndex = -1;
        for(int j=0;j<nums.length;j++){
            if(nums[j]<=min){
                continue;
            }else{
                minIndex = j;
                break;
            }
        }
        for(int j=nums.length-1; j>=0; j--){
            if(nums[j]>=max){
                continue;
            }else{
                maxIndex = j;
                break;
            }
        }
        if(maxIndex==-1 && minIndex==-1){
            return 0;
        }
        if(flag){
            return Math.abs(maxIndex - minIndex) + 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] input = {-1,0,3,2,4};
        int output = findUnsortedSubarray(input);
        System.out.println(output);
        System.out.println();
    }
}
