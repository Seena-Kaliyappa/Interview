package com.seena.practise.ds.backtracking;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Approach - Backtracking
 * Initialize a Mapping: Create a dictionary that maps each digit from 2 to 9 to their corresponding letters on a telephone's buttons. For example, the digit '2' maps to "abc," '3' maps to "def," and so on.
 *
 * Base Case: Check if the input string digits is empty. If it is, return an empty list, as there are no combinations to generate.
 *
 * Recursive Backtracking:
 *
 * Define Recursive Function: Create a recursive function, backtrack, that will be used to explore all possible combinations. It takes two parameters: combination, which holds the current combination of letters, and next_digits, which holds the remaining digits to be explored.
 * Termination Condition: If next_digits is empty, it means that all digits have been processed, so append the current combination to the result.
 * Exploration: If there are more digits to explore, take the first digit from next_digits and iterate over its corresponding letters in the mapping. For each letter, concatenate it to the current combination and recursively call the backtrack function with the new combination and the remaining digits.
 * Example: If the input is "23", the first recursive call explores all combinations starting with 'a', 'b', and 'c' (from '2'), and the next level of recursive calls explores combinations starting with 'd', 'e', 'f' (from '3'), building combinations like "ad," "ae," "af," "bd," "be," etc.
 * Result: Once the recursive exploration is complete, return the collected combinations as the final result. By using recursion, we ensure that all possible combinations are explored, and the result includes all valid letter combinations that the input digits can represent.
 *
 * Complexity
 * Time complexity: ( O(4^n) ), where ( n ) is the length of the input string. In the worst case, each digit can represent 4 letters, so there will be 4 recursive calls for each digit.
 * Space complexity: ( O(n) ), where ( n ) is the length of the input string. This accounts for the recursion stack space.
 */
public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        String input = "234";
        LetterCombinationOfPhoneNumber letterCombinationOfPhoneNumber = new LetterCombinationOfPhoneNumber();
        System.out.println("Letter Combination of Phone Number == >" + letterCombinationOfPhoneNumber.letterCombinations(input));
    }

    private static final Map<Character, String> map = new HashMap<>();
    private  List<String> letterCombinations(String digits) {
        //Initialize a Mapping
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        backtrack(digits, "", result);
        return result;
    }

    private void backtrack(final String next_digit, final String combination, final List<String> result) {
        if (next_digit.length() == 0) {
            result.add(combination);
            return;
        }
        char digit = next_digit.charAt(0);
        final String letters = map.get(digit);
        for (char ch : letters.toCharArray()) {
            backtrack(next_digit.substring(1), combination + ch, result);
        }
    }
}
