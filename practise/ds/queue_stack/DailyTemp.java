package com.seena.practise.ds.queue_stack;

import java.util.Arrays;

public class DailyTemp {
    public static void main(String[] args){
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] output = dailyTemperatures(temp);
        Arrays.stream(output).forEach(i -> System.out.print(" "+i));

    }

    public static int[] dailyTemperatures(int[] T) {
        int[] output = new int[T.length];
        for(int i = 0; i<T.length;i++){
            int count = 0;
            int j = i;
            while(j<T.length-1){
                count++;
                if(T[i]<T[j+1]){
                    break;
                }
                j++;

            }
            output[i] = count;
        }
        return output;
    }
}
