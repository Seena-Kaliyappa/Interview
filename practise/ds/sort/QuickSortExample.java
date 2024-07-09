package com.seena.practise.ds.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: eklxsnx
 * Email: seena.kali@gmail.com
 * Date: 6/17/2021 11:14 PM
 * Description: ""
 **/
public class QuickSortExample {
    public static void main(String[] args) {
        int[] input = {5, 10, 55, 69, 1, 34, 3, 4, 100, 86};
        quickSort(input, 0, input.length-1);

        for (int a : input) {
            System.out.print(" " + a);
        }
    }


    private static void quickSort(int[] input, int low, int high) {
        if(low<high){
            int pi = partition(input, low, high);
            quickSort(input, 0, pi-1);
            quickSort(input,pi+1, high);
        }
        Map<String, Integer> map = new HashMap<>();
    }

    private static int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int i = low-1;
        for(int j = low;j<high;j++){
            if(input[j] < pivot){
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i+1,high);
        return i+1;
    }

    private static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}

