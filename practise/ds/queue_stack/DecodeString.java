package com.seena.practise.ds.queue_stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args){
        String s1 = "3[a]2[bc]";
        String s2 = "3[a2[c]]";
        String s3 = "2[abc]3[cd]ef";
        String s4 = "abc3[cd]xyz";

        String decode = decodeString(s2);
        System.out.println(" Decoded String : "+decode);
    }

    private static String decodeString(String s) {
        Stack<Integer> count = new Stack();
        Stack<String> result = new Stack();
        int index =0;
        String res = "";
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int digit =0;
                while(Character.isDigit(s.charAt(index))){
                    digit = 10*digit + s.charAt(index)-'0';
                    index++;
                }
                count.push(digit);
            }else if(s.charAt(index) == '['){
                result.push(res);
                res = "";
                index ++;
            }else if(s.charAt(index) == ']'){
                StringBuilder tmp = new StringBuilder(result.pop());
                int n = count.pop();
                for(int i =0; i<n;i++){
                    tmp.append(res);
                }
                index++;
                res = tmp.toString();
            }else{
                res = res+s.charAt(index);
                index++;
            }

        }
        return res;
    }

}
