package com.seena.studyplan.algorithm.day3;

import java.util.Arrays;

public class TwoNumberSumIndexInSortedArray_SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {2,5,6,8,12};
        int[] resultIndex = twoNumberSumIndex(nums, 13);
        System.out.print(" Seena...");
        Arrays.stream(resultIndex).forEach(i -> System.out.print( " "+i));
    }

    private static int[] twoNumberSumIndex(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[]{left, right};
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
