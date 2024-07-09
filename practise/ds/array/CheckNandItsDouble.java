package com.seena.practise.ds.array;

import java.util.HashSet;

public class CheckNandItsDouble {
    public static void main(String[] args){
        double[] arr = {2,3,88,0,44,99,5,100};
        System.out.println(checkNandItsDouble(arr));
    }

    private static boolean checkNandItsDouble(double[] arr) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        HashSet<Double> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]*2) || set.contains(arr[i]/2)){
                return true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;
    }
}
