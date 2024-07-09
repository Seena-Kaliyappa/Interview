package com.seena.practise.ds.array;

public class MinSwapCount {
    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 2, 4, 5, 6};
        System.out.println(minimumSwaps(arr));
    }
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int index = 0;
        while (index < arr.length-1){
            int currentValue = arr[index];

            if (currentValue == index+1) {
                index++;
            } else {
                arr[index] = arr[currentValue-1];
                arr[currentValue-1] = currentValue;
                swaps++;
            }
        }
        return swaps;
    }
}

