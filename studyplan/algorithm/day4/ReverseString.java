package com.seena.studyplan.algorithm.day4;

public class ReverseString {
    public static void main(String[] args) {
        char[] input = {'h', 'e', 'l','l','o','1','s','e','e','n','a'};

        int l = 0, r=input.length-1;
        while (l<r) {
            char tmp = input[l];
            input[l] = input[r];
            input[r] = tmp;
            l++;
            r--;
        }
    System.out.println(input);
    }
}
