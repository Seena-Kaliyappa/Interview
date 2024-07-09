package com.seena.practise.ds.array.easy;

/**
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Approach:
 * Initialize Baseline Frequencies:
 *
 * Create a frequency map for the characters in the first word. This map will store each character and how many times it appears in the first word.
 *
 * Process Each Word:
 *
 * For each subsequent word:
 * Create a temporary frequency map to count the characters in the current word.
 * Compare this map with the baseline map:
 * If a character exists in both maps, update the baseline map to hold the minimum of the two
 * frequencies.
 * If a character in the baseline map is not found in the current word's map, set its frequency to zero.
 *
 * Compile Final List:
 *
 * Iterate over the final baseline frequency map.
 * For each character, append it to the result list as many times as its frequency indicates.
 */
public class CommonCharacter {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
        System.out.println(commonCharsWithArray(words));

    }

    private static List<String> commonChars(String[] words) {
        Map<Character, Integer> baseMap = new ConcurrentHashMap();
        //populate base map
        char[] firWord = words[0].toCharArray();
        for (char c : firWord) {
            baseMap.merge(c, 1, Integer::sum);
        }

        if(words.length >1) {
            for (int i = 1; i <words.length; i++) {
                Map<Character, Integer> map = new HashMap();
                char[] word = words[i].toCharArray();
                for (char c : word) {
                    map.merge(c, 1, Integer::sum);
                }
                for (Map.Entry<Character, Integer> entry : baseMap.entrySet()) {
                    if (map.containsKey(entry.getKey())) {
                        baseMap.put(entry.getKey(), Math.min(map.get(entry.getKey()), entry.getValue()));
                    } else {
                        baseMap.remove(entry.getKey());
                    }
                }
            }
        }

        List<Character> res = new ArrayList();
        for (Map.Entry<Character, Integer> entry : baseMap.entrySet()) {
            int freq = entry.getValue();
            for (int i = 0; i<freq; i++) {
                res.add(entry.getKey());
            }
        }
        return res.stream().map(String::valueOf).collect(Collectors.toList());
    }


    private static List<String> commonCharsWithArray(String[] words) {
        int n = words.length;
        int[] commonCharacterCounts = new int[26];
        int[] currentCharacterCounts = new int[26];
        List<String> result = new ArrayList<>();

        for (char ch : words[0].toCharArray()) {
            commonCharacterCounts[ch - 'a']++;
        }

        for (int i = 1; i < n; i++) {
            Arrays.fill(currentCharacterCounts, 0);

            // Count characters in the current word
            for (char ch : words[i].toCharArray()) {
                currentCharacterCounts[ch - 'a']++;
            }

            // Update the common character counts to keep the minimum counts
            for (int letter = 0; letter < 26; letter++) {
                commonCharacterCounts[letter] = Math.min(
                    commonCharacterCounts[letter],
                    currentCharacterCounts[letter]
                );
            }
        }

        for (int letter = 0; letter < 26; letter++) {
            while(commonCharacterCounts[letter]>0){
                result.add(String.valueOf((char) (letter + 'a')));
                commonCharacterCounts[letter]--;
            }
        }

        return result;
    }

}
