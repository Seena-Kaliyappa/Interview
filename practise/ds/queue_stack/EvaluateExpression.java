package com.seena.practise.ds.queue_stack;

import java.util.Stack;

public class EvaluateExpression {
        public static void main(String[] args){
        String[] input = {"2","1","+","3","*"};
        System.out.println(evalRPN(input));
        }
        public static int evalRPN(String[] tokens) {

            Stack<Integer> stack = new Stack();
            for(int i=0;i<tokens.length;i++){
                boolean operator = isOperator(tokens[i]);
                if(operator){
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();
                    stack.push(operation(operand1, operand2,tokens[i]));
                }else{
                    stack.push(Integer.parseInt(tokens[i]));
                }
            }

            return stack.pop();
        }

        private static boolean isOperator(String token){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                return true;
            }
            return false;
        }

        private static int operation(int operand1, int operand2, String operator){
            int result = 0;
            switch(operator){
                case "+" :
                    result = operand1+operand2;
                    break;
                case "-" :
                    result = operand1-operand2;
                    break;
                case "*" :
                    result = operand1*operand2;
                    break;
                case "/" :
                    result = operand1/operand2;
                    break;
            }
            return result;
        }
}
