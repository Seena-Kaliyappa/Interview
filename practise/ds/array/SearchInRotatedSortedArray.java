package com.seena.practise.ds.array;

public class SearchInRotatedSortedArray {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2,3,4};
        //int[] arr = {3,1};
        System.out.println(search(arr,7));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low <= high){

            //Perform Binary Search
            mid = low + (high-low)/2;

            //If mid is the target, return mid
            if(nums[mid] == target) return mid;

            //If low <= mid, then check whether target is inbetween low and mid
            //If true, then adjust high to mid-1, else adjust low to mid+1;
            if(nums[low] <= nums[mid]){
                if(target < nums[mid] && target >= nums[low])
                    high = mid-1;
                else
                    low = mid+1;
            }
            //If mid <= high, then check whether target is inbetween mid and high
            //If true then adjust low to mid+1, else adjust high to mid-1;
            if(nums[mid] <= nums[high]){
                if(target > nums[mid] && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}
