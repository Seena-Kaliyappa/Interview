package com.seena.practise.ds.array;

import java.util.Arrays;

public class SortByParity {
    public static void main(String[] args){
        int[] nums = {3,1,2,4};
        int[] result = sortArrayByParity(nums);
        Arrays.stream(result).forEach(i->System.out.print(" "+i));
    }

    private static int[] sortByParity(int[] A) {
        int low =0;
        int high = A.length-1;
        while(low<high){
            if(A[low]%2==0){
                low++;
            }
            if(A[high]%2!=0){
                high--;
            }
            if(A[low]%2 > 0){
                int tmp = A[low];
                A[low] = A[high];
                A[high] = tmp;
            }

        }
        return A;
    }


    public static int[] sortArrayByParity(int[] nums) {
        if (nums == null) return new int[]{};
        if (nums.length <= 1) return nums;
        int low = 0, high = nums.length-1;
        while (low < high) {
            while (nums[low]%2 == 0 && low <high ) {
                low++;
            }
            while (nums[high]%2 != 0 && high > low) {
                high--;
            }
            if (low <high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }

        }
        return nums;
    }
}
