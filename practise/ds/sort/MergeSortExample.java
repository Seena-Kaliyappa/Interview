package com.seena.practise.ds.sort;

/**
 * Author: eklxsnx
 * Email: seena.kali@gmail.com
 * Date: 6/17/2021 3:22 PM
 * Description: ""
 **/
public class MergeSortExample {

    public static void main(String[] args){
        int[] input = {5,10, 55,69,1,34,3,4,100,86};
        mergeSort(input, input.length);

        for(int a: input){
            System.out.print(" "+a);
        }
    }

    private static void mergeSort(int[] input, int length) {
        if(length <2){
            return;
        }
        int mid = length/2;
        int l[] = new int[mid];
        int r[] = new int[length-mid];

        for(int i = 0 ; i<mid;i++){
            l[i] = input[i];
        }
        for(int i = mid;i<length;i++){
            r[i-mid] = input[i];
        }
        mergeSort(l,mid);
        mergeSort(r,length-mid);
        merge(input, l, r,mid,length-mid);
    }

    private static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i=0,j=0,k=0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
