package com.seena.practise.ds.strings.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 */
public class IsoMhorpic {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphicWithMap(s, t));

    }

    private static boolean isIsomorphicWithMap(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Character value = t.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) != value){
                    return false;
                }
            } else {
                if (map.containsValue(value)) {
                    return false;
                }
                map.put(key, value);
            }

        }
        return true;
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] first = new int[200];
        int[] sec = new int[200];
        for (int i=0; i<s.length(); i++) {
            int sIndex = s.charAt(i);
            int tIndex = t.charAt(i);
            if (first[sIndex] != sec[tIndex]) {
                return false;
            }
            first[sIndex]= i+1;
            sec[tIndex]= i+1;
        }

        return true;
    }
}
