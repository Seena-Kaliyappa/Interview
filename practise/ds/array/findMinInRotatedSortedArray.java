package com.seena.practise.ds.array;

public class findMinInRotatedSortedArray {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] nums) {
        if(nums.length ==1 || nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        int l=0,r=nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }

            if(nums[mid]>nums[r]){
                l= mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
}
