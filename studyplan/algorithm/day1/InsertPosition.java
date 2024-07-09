package com.seena.studyplan.algorithm.day1;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class InsertPosition {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,8,10};
        System.out.println(searchAndInsert(arr, 9));
    }

    private static int searchAndInsert(int[] arr, int target) {
        int mid, low = 0, high = arr.length-1;
        while (low <= high) {
            mid = (low +high)/2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target < arr[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
