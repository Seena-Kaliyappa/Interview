package com.seena.practise.ds.graph;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],
 *                       [1,1,0],
 *                       [0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],
 *                       [0,1,0],
 *                       [0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * Accepted
 * 405,339
 * Submissions
 * 648,880
 */
public class NumberOfProvince {

    public static void main (String[] args) {
        int[][] input = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        //System.out.println("Number of province or connected friends " + findNumberOfProvince(input));
        System.out.println("Number of province or connected friends " + numberOfIsland(input));

    }

    private static int findNumberOfProvince(int[][] isConnected) {
        int province = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int city = 0; city< isConnected.length ; city++) {
            if(!visited[city]) {
                dfs(isConnected, visited, city);
                province++;
            }
        }
        return province;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int city) {
        for(int otherCity = 0; otherCity< isConnected[city].length ; otherCity++) {
            if(isConnected[city][otherCity] == 1 && !visited[otherCity]) {
                visited[otherCity] = true;
                dfs(isConnected, visited, otherCity);
            }
        }
    }

    private static int numberOfIsland(int[][] input) {
        int islandCount = 0;
        for(int i =0; i<input.length; i++) {
            for(int j =0; j< input[i].length; j++) {
                if(input[i][j] == 1) {
                    islandCount += findIsland(input, i, j);
                }
            }
        }
        return islandCount;
    }

    private static int findIsland(int[][] input, int i, int j) {
        if (i < 0 || i>=input.length || j <0 || j >= input[i].length || input[i][j] == 0) {
            return 0;
        }
        input[i][j] = 0;
        findIsland(input, i+1, j);
        findIsland(input, i-1, j);
        findIsland(input, i, j+1);
        findIsland(input, i, j-1);
        return 1;
    }
}
