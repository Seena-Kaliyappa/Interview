package com.seena.practise.ds.array;

import java.util.*;

public class FindNMaxNumber {
    public static void main(String[] args){
        //int[] arr = {3,4,5,2,2,1,1,6,7,4,4};
        int[] arr = {1,2,2,5,3,5};
        System.out.println(" "+ findNMaxNumber(arr, 3));
    }

    private static int findNMaxNumber(int[] arr, int n) {
        int res = 0;
        TreeSet<Integer> t = new TreeSet<>();
        for(int i=0;i<arr.length;i++){
                t.add(arr[i]);
        }
        if(t.size()<n){
            return t.pollLast();
        }
        for(int i=1;i<=n;i++){
            res = t.pollLast();
        }
        return res;
    }
}
