package com.seena.studyplan.algorithm.day4;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 */

public class ReverseWordInString {
    // Two pointer approach
    public static void main(String[] arg) {
        String s = "Hello Seena How are you buddy";
        char[] input = s.toCharArray();
        int begin=0, left=0, right=input.length-1;
        while(left < right) {
            if (input[left] == ' ') {
                swap(input, begin, left-1);
                begin = left+1;
            }
            left++;
        }
        swap(input,begin,right);

        System.out.println("after swap==>" + new String(input));
    }

    private static void swap(char[] input, int begin, int end) {
        while(begin<end) {
            char tmp = input[begin];
            input[begin++] = input[end];
            input[end--] = tmp;
        }
    }
}
