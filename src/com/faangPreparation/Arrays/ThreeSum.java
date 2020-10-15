package com.faangPreparation.Arrays;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an array nums of n integers,
are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.



Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class ThreeSum {
    private static List<List<Integer>> getThreeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;
        for(int i=0; i<nums.length-2; i++){
            int leftIndex = i+1;
            int rightIndex = nums.length - 1;
            int fixedNumber = nums[i];
            while(leftIndex<rightIndex){
                if(fixedNumber + nums[leftIndex] + nums[rightIndex] == target){
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(fixedNumber);
                    innerList.add(nums[leftIndex]);
                    innerList.add(nums[rightIndex]);
                    res.add(innerList);
                    leftIndex = leftIndex + 1;
                    rightIndex = rightIndex - 1;
                }else if(fixedNumber + nums[leftIndex] + nums[rightIndex] < target){
                    leftIndex = leftIndex + 1;
                }else {
                    rightIndex = rightIndex - 1;
                }
            }
        }
        Set<List<Integer>> s = new HashSet<>();
        for (List<Integer> item:res) {
            s.add(item);
        }
        return s.stream().collect(Collectors.toList());
    }
    private static List<List<Integer>> getThreeSumSolution2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> resultArray = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(nums[i]);
                    subResult.add(nums[j]);
                    subResult.add(nums[k]);
                    resultArray.add(subResult);
                    j++;
                    k--;
                }
            }
        }
        return resultArray;
    }

    private static List<List<Integer>> getThreeSumLocation3(int[] nums){
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int negNums = 0;
        int posNums = 0;
        List<List<Integer>> result = new LinkedList<>();
        int zeroNums = 0;
        for(int num : nums) {
            if(num < minVal) {
                minVal = num;
            }
            if(num > maxVal) {
                maxVal = num;
            }
            if(num == 0) {
                zeroNums++;
            } else if (num > 0) {
                posNums++;
            } else {
                negNums++;
            }
        }
        if(zeroNums >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }
        if(minVal >= 0 || maxVal <= 0) {
            return result;
        }
        int[] numMap;
        int[] negNumMap = new int[negNums];
        int[] posNumMap = new int[posNums];
        int posStart = 0;
        if(maxVal + 2 * minVal > 0) {
            maxVal = -2 * minVal;
        }
        if(minVal + 2 * maxVal < 0) {
            minVal = -2 * maxVal;
        }
        numMap = new int[maxVal - minVal + 1];
        negNums = 0;
        posNums = 0;
        for(int num : nums) {
            if (num >= minVal && num <= maxVal) {
                if(numMap[num - minVal]++ == 0) {
                    if (num > 0) {
                        posNumMap[posNums++] = num;
                    } else if (num < 0) {
                        negNumMap[negNums++] = num;
                    }
                }
            }
        }
        Arrays.parallelSort(posNumMap, 0, posNums);
        Arrays.parallelSort(negNumMap, 0, negNums);
        for(int i = negNums - 1; i >= 0; i--) {
            int nv = negNumMap[i];
            int minpv = (-nv) / 2;
            while(posStart < posNums && posNumMap[posStart] < minpv) {
                posStart++;
            }
            for (int j = posStart; j < posNums; j++) {
                int pv = posNumMap[j];
                int ln = 0 - nv - pv;
                if (ln >= nv && ln <= pv) {
                    if(numMap[ln - minVal] == 0) {
                        continue;
                    } else if((ln == pv || ln == nv) && numMap[ln - minVal] > 1) {
                        result.add(Arrays.asList(nv, ln, pv));
                    } else if(ln != nv && ln != pv) {
                        result.add(Arrays.asList(nv, ln, pv));
                    }
                } else if(ln < nv) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> out = getThreeSum(arr);
        for (List<Integer> item:out) {
            for (int i: item) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
