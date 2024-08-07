package com.seena.leetcode.jan2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 *
 * Return a list answer of size 2 where:
 *
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 *
 * Note:
 *
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 *
 *
 * Example 1:
 *
 * Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * Output: [[1,2,10],[4,5,7,8]]
 * Explanation:
 * Players 1, 2, and 10 have not lost any matches.
 * Players 4, 5, 7, and 8 each have lost one match.
 * Players 3, 6, and 9 each have lost two matches.
 * Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
 * Example 2:
 *
 * Input: matches = [[2,3],[1,3],[5,4],[6,4]]
 * Output: [[1,2,5,6],[]]
 * Explanation:
 * Players 1, 2, 5, and 6 have not lost any matches.
 * Players 3 and 4 each have lost two matches.
 * Thus, answer[0] = [1,2,5,6] and answer[1] = [].
 */
public class FindPlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> output = findZeroOrOneLossPlayers(matches);
        output.forEach(System.out ::println);
    }

    private static List<List<Integer>> findZeroOrOneLossPlayers(int[][] matches) {
        Map<Integer, Integer> map = new HashMap(); // player vs loose match count
        Set<Integer> winner = new TreeSet<>();
        Set<Integer> looser = new TreeSet<>();
        for (int[] match : matches) {
            int player1 = match[0];
            int player2 = match[1];
            map.put(player1, map.getOrDefault(player1, 0) + 0); // if player is already present, then player loos count + 0 (winning), else 0+0
            map.put(player2, map.getOrDefault(player2, 0) + 1); // if player is already present, then player loose count + 1 (loose), else 0+1
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                winner.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                looser.add(entry.getKey());
            }
        }

        return List.of(new ArrayList<>(winner), new ArrayList<>(looser));
    }
}
