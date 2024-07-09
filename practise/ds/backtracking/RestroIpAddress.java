package com.seena.practise.ds.backtracking;

/**
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Use an additional input to the function that is index, which says the function where the string starts from, it is as good as forgetting the already dotted part of the string.
 *
 * Additional Improvement: Check if the string length is greater than 12, than its completely invalid, Similarly if already 2 dots inserted and the remaining string length is 7 its invalid as well.
 */
public class RestroIpAddress {
    static List<String> ans = new ArrayList<>();
    String str = "25525511135";
    public static void main(String[] args) {
        RestroIpAddress restroIpAddress = new RestroIpAddress();
        restroIpAddress.magical("", 0, 0);
        ans.forEach(System.out::println);
    }

    void magical( String path, int index, int dots) {
        if (dots > 4) return;
        if (dots == 4 && index >= str.length()) {
            ans.add(path.substring(0,path.length()-1));
            return;
        }
        for (int length = 1; length <= 3 && index + length <= str.length(); length++) {
            String num = str.substring(index, index + length);
            if (num.charAt(0) == '0' && length != 1) break;
            else if (Integer.parseInt(num) <= 255) {
                magical( path + num + ".", index + length,dots + 1);
            }
        }
    }
}
