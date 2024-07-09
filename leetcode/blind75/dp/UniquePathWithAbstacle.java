package com.seena.leetcode.blind75.dp;

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: obstacleGrid =
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 *
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
public class UniquePathWithAbstacle {
    public static void main(String[] args) {
        System.out.println(uniqueuePathWithAbstacle(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniqueuePathWithAbstacle(new int[][]{{0,0},{1,1}, {0,0}}));
    }

    private static int uniqueuePathWithAbstacle(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for (int row = m-1; row >=0;row--) {
            for (int col = n-1; col >=0; col--) {

                if (row == m-1) {
                    if (obstacleGrid[row][col] == 1 || col<n-1 && dp[row][col+1] == 0) {
                        dp[row][col] = 0;
                    } else {
                        dp[row][col] = 1;
                    }
                    continue;
                }
                if (col == n-1) {
                    if (obstacleGrid[row][col] == 1 || row<m-1&& dp[row+1][col] == 0) {
                        dp[row][col] = 0;
                    } else {
                        dp[row][col] = 1;
                    }
                    continue;
                }

                if (obstacleGrid[row][col] != 1) {
                    dp[row][col] = dp[row+1][col] + dp[row][col+1];
                }
            }
        }
        return dp[0][0];
    }

    private static int uniquePaths2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        for (int row = m-1; row >=0; row--) {
            for (int col = n-1; col >=0; col--) {
                //last row process
                if (row == m-1) { //ex: 00001111
                    // if there was abstacle in previous, ther is no path untill abstacle
                    if (col < n-1 && obstacleGrid[row][col+1] == 0){
                        obstacleGrid[row][col] = 0;
                    } else if (obstacleGrid[row][col] == 0) { // there is path, then update path as 1
                        obstacleGrid[row][col] = 1;
                    }else { //there is abstacle , then update path = 0
                        obstacleGrid[row][col] = 0;
                    }
                    continue;
                }
                //last column process
                if (col == n-1) {
                    // if there was abstacle previous, then there is no path from abstacle
                    if (row <m-1 && obstacleGrid[row+1][col] == 0){
                        obstacleGrid[row][col] = 0;
                    } else if (obstacleGrid[row][col] == 0) { // if there is path, then update path as 1
                        obstacleGrid[row][col] = 1;
                    }else { // if there is abstacle then udpate path as 0
                        obstacleGrid[row][col] = 0;
                    }
                    continue;
                }

                if (obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                } else {
                    obstacleGrid[row][col] = obstacleGrid[row+1][col] + obstacleGrid[row][col+1];
                }

            }
        }
        return obstacleGrid[0][0];
    }



    private static int uniquePaths3(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        //last row process
        for (int i = n-1; i>=0;i--) {
            // if there was abstacle in previous, ther is no path untill abstacle
            if (i < n-1 && obstacleGrid[m-1][i+1] == 0) {//ex: 00001111
                obstacleGrid[m-1][i] = 0;
            } else if (obstacleGrid[m-1][i] == 0){// if there is path, then update path as 1
                obstacleGrid[m-1][i]=1;
            } else{// if there is abstacle then udpate path as 0
                obstacleGrid[m-1][i]=0;
            }
        }
        //last column process
        for (int j = m-2; j>=0;j--) {
            // if there was abstacle in previous, ther is no path untill abstacle
            if (j < m-2 && obstacleGrid[j+1][n-1] == 0 ) {
                obstacleGrid[j][n-1] = 0;
            } else if (obstacleGrid[j][n-1] == 0) {// if there is path, then update path as 1
                obstacleGrid[j][n-1] = 1;
            }else {
                obstacleGrid[j][n-1] = 0;// if there is abstacle then udpate path as 0
            }
        }

        for (int row = m-2; row >=0; row--) {
            for (int col = n-2; col >=0; col--) {

                if (obstacleGrid[row][col] == 1) {
                    obstacleGrid[row][col] = 0;
                } else {
                    obstacleGrid[row][col] = obstacleGrid[row+1][col] + obstacleGrid[row][col+1];
                }

            }
        }
        return obstacleGrid[0][0];
    }



}
