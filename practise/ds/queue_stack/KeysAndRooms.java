package com.seena.practise.ds.queue_stack;

import java.util.*;

/**
 * Author: eklxsnx
 * Email: seena.kali@gmail.com
 * Date: 5/24/2021 5:47 PM
 * Description: ""
 **/
public class KeysAndRooms {

    public static void main(String[] args){
        List<Integer> input = new ArrayList<>();
        input.add(1);
        List<List<Integer>> rooms = new ArrayList<>();
                rooms.add(input);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while(!stack.isEmpty()){
            List<Integer> keys = rooms.get(stack.pop());
            for(Integer key :keys){
                if(!visited.contains(key)){
                    visited.add(key);
                    stack.add(key);
                }
            }
        }
        //return visited.size() == rooms.size();
    }
}
