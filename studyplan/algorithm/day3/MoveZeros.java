package com.seena.studyplan.algorithm.day3;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,0,4,1,3};
        moveZeros(nums);
        Arrays.stream(nums).forEach(i -> System.out.print(" " +i));
    }

    private static void moveZeros(int[] nums) {
        int zp = 0;
        for(int i= 0; i<nums.length; i++) {
            if(nums[i] !=0 ){
                nums[zp++] = nums[i];
            }
        }
        while(zp < nums.length) {
            nums[zp++] = 0;
        }
    }


    public void moveZeros2(int[] nums) {
        int z = 0;
        boolean zp = false;
        for(int i = 0; i<nums.length;i++) {
            if (nums[i] == 0 && !zp) { //Initial setting zp index
                zp = true;
                z = i;
            }
            if (nums[i] != 0 && zp) {
                nums[z++] = nums[i];
                nums[i] = 0;
            }
        }

    }

}
