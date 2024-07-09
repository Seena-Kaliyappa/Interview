package com.seena.practise.ds.array;

public class MountainArrayCheck {
    public static void main(String args[]){
        int[] arr = {0,1,2,3,4};
        System.out.println(isMountainArray(arr));
        int[] nums = {2,1,1,5,6,2,3,1};
        System.out.println(minimumMountainRemovals(nums));
    }

    private static boolean isMountainArray(int[] arr) {
        if(arr==null || arr.length<3){
            return false;
        }
        int N = arr.length-1;
        int i =0;
        while( i < N && arr[i] < arr[i+1]){
            i++;
        }
        if(i==N || i==0){
            return false;
        }
        while(i <N && arr[i]> arr[i+1]){
            i++;
        }
        return i==N;
        }

    public static int minimumMountainRemovals(int[] nums) {
        int count =0;
        int N = nums.length-1;
        int i =0;
        while(i<N && nums[i]>=nums[i+1]){
             count++;
             i++;
        }
        while( i < N && nums[i] < nums[i+1]){
            i++;
        }
        if(i==N || i==0){
            return i;
        }
        while(i<N){
            if(nums[i]<=nums[i+1]){
                count++;
            }
            i++;
        }
        return count;
    }
}
