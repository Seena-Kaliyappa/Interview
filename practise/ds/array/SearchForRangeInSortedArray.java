package com.seena.practise.ds.array;

import java.util.Arrays;

public class SearchForRangeInSortedArray {

    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,10};
        int[] result = searchRange(arr,8);
        Arrays.stream(result).forEach(i-> System.out.print(" "+i));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] range = {-1,-1};
        if(nums.length==0){
            return range;
        }
        if(nums.length==1 && target==nums[0]){
            range[0] = 0;
            range[1] = 0;
            return range;
        }
        if( nums.length==1 && target!=nums[0]){
            return range;
        }
        int l=0, r=nums.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(target == nums[mid]){
                int low = mid;
                int high = mid;
                while(low>l && target== nums[low-1] ){
                    low--;
                }
                while(high<r && target== nums[high+1]){
                    high++;
                }
                range[0]=low;
                range[1]= high;
                return range;
            }
            if(target> nums[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return range;

    }
}
