package com.seena.practise.ds.array;

import java.util.ArrayList;
import java.util.List;

public class FindMissingElements {
    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> res = findMissing(arr);

        res.stream().forEach(i -> System.out.print(" "+i));
    }

    private static List<Integer> findMissing(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        //it makes the number position -ve to track the number
        for (int a : nums) {
            int pos = Math.abs(a) - 1;
            if (nums[pos] > 0) nums[pos] = -1 * nums[pos];
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}
