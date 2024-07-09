package com.seena.practise.ds.queue_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthese {
    public static void main(String[] args){

        String s1 = "{(a+b)-(a*b)-[a/b]}";
        String s2 = "()";
        System.out.println(" Is valid Parenthese : "+isValidParenthese(s2));
        System.out.println("Is Balanced Equation "+ isBalancedEquation(s1));
    }

    private static boolean isValidParenthese(String str) {
        Stack<Character> stack = new Stack();
        char[] ch = str.toCharArray();
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        for(int i=0;i<ch.length;i++){
            if(map.containsKey(ch[i])){
                if(stack.empty() || stack.peek()!=map.get(ch[i])){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(ch[i]);
            }
        }

        return stack.isEmpty();
    }

    private static boolean isBalancedEquation(String str){
        Stack<Character> stack = new Stack();
        char[] ch = str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(ch[i] =='(' || ch[i] =='[' || ch[i] == '{'){
                stack.push(ch[i]);
            }
            if(ch[i] == ')' || ch[i] == ']' || ch[i] == '}'){
                if(stack.isEmpty() || (ch[i] == ')' && stack.peek()!= '(') || (ch[i] == ']' && stack.peek()!='[')  || (ch[i] == '}' && stack.peek()!= '{')){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

       return stack.isEmpty();
    }
}
