package com.seena.practise.ds.array;


public class DeleteElement {
    public static void main(String[] args){
        int[] arr = {1,2,3,3,3,4,4,5,6};
        //int[] arr1 = {1,2,3,3,3,4,4,5,6};
        int[] arr1 = {1,1,2};
        int len = deleteElement(arr,3);
        for(int i=0;i<len;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
        len = deleteDuplicateElements1(arr1);
        for(int i=0;i<=len;i++){
            System.out.print(" "+arr1[i]);
        }
    }

    private static int deleteDuplicateElements1(int[] nums) {
        int len = nums.length;
        if (len <=1) {
            return len;
        }
        int index = 0;
        for (int i = 0; i <len-1;i++) {
            if(nums[i] != nums[i+1]) {
                nums[index++] = nums[i];
            }
        }

        if (index == len-1 && nums[index-1] != nums[len-1]) {
            //Handlling last element
            nums[index] = nums[len-1];
        } else if (nums[index] != nums[len-1]) {
            nums[index] = nums[len-1];
        }

        if (index == 0) {
            return 1;
        }
        return index;
    }

    private static int deleteDuplicateElements(int[] arr1) {
        int count =0;
        if(arr1.length>0){
            arr1[count] = arr1[0];
        }
        for(int i=1;i<arr1.length;i++){
            if(arr1[count]!= arr1[i]){
                arr1[++count] = arr1[i];
            }else{
                continue;
            }
        }
        return count;
    }

    private static int deleteElement(int[] arr, int val) {
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != val){
               arr[count++] = arr[i] ;
            }
        }
        return count;
    }
}
