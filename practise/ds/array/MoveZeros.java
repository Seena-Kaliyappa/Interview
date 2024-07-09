package com.seena.practise.ds.array;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args){
        int[] arr = {0,1,0,3,12};
        int[] arr1 = {0,0,1};
        int[] arr3 = {1,3,12,0,0};

        moveZerosToEnd1(arr);
        System.out.println();
        Arrays.stream(arr).forEach(i-> System.out.print(" "+i));
        System.out.println();
        moveZerosToBeg1(arr3);
        Arrays.stream(arr3).forEach(i-> System.out.print(" "+i));
    }

    private static void moveZerosToEnd1(int[] arr) {
        int zCount = 0, index = 0;
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            } else {
                zCount++;
            }
            if (index + zCount == arr.length) {
                break;
            }
        }
        for (int i = arr.length - zCount; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    private static void moveZerosToBeg1(int[] arr) {
        int zCount = 0, index = arr.length-1;
        for (int i = arr.length-1 ; i >=0; i--) {
            if (arr[i] != 0) {
                arr[index--] = arr[i];
            } else {
                zCount++;
            }

        }
        for (int j = 0 ; j < zCount; j++) {
            arr[j] = 0;
        }
    }

    private static void moveZerosToBeg(int[] nums) {
        int zp = nums.length-1;
        boolean z = false;
        for ( int i = nums.length-1; i >= 0; i--) {
            if (nums[i] == 0 && !z) {
                z = true;
                zp = i;
            }
            if (nums[i] != 0 && z) {
                nums[zp] = nums[i];
                nums[i] = 0;
                zp --;
            }
        }
        Arrays.stream(nums).forEach(i-> System.out.print(" "+i));
    }

    private static void moveZeros(int[] nums) {
        int np_index = 0;
        for ( int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                np_index ++;
            }
            if (nums[i] == 0 && i > np_index) {
                nums[np_index] = nums[i];
                nums[i] = 0;
            }
        }
        Arrays.stream(nums).forEach(i-> System.out.print(" "+i));
    }

    private static void moveZerosToEnd(int[] nums) {
        boolean zp = false;
        int zp_index = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0 && !zp) {
                zp = true;
                zp_index = i;
            }

            if (nums[i] !=0  && zp_index < i){
                nums[zp_index] = nums[i];
                nums[i] = 0;
                zp_index++;

            }
        }
        Arrays.stream(nums).forEach(i-> System.out.print(" "+i));
    }
}
