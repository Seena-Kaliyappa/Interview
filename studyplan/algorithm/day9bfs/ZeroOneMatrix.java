package com.seena.studyplan.algorithm.day9bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 Question
 Given a matrix consists of 0 and 1, find the distance of the nearest
 0 for each cell.

 The distance between two adjacent cells is 1.

 Thoughts Before Coding
 - The brute force approach is to perform a breath first search
 from all of the cells which contains a '1'
 - This approach will cost us O(n^2) time complexity because
 the breath first search cost O(n)
 - Then we perform each BFS on each cell which will give O(n^2)
 - For each of the cell at 'r, c', which contains a '1'
 - If the cell above row 'r - 1' is 'x' distance away from a 0
 - Then we know the current cell is 'x + 1' distance away
 from a 0
 - But, we should note that this applies to all 4 directions
 - Since, we want the minimum distance to a 0
 - We will want to pick the minimum distance from all 4 directions

 Answer
 - Create a 'distance' matrix, which will keep track of the
 distances to the nearest 0
 - We will first fill the 'distance' matrix with 10,000
 - We will first find the minimum distance to the cell above and
 to the left
 - Iterate through from top left to bottom right, denoted as 'r, c'
 - If 'matrix[r][c]' is equal to 0
 - Set 'distance[r][c]' to 0
 - continue to next iteration
 - If 'r' is greater than 0, then we can find the minimum distance
 to a 0 from the cell above up
 - Update 'distance[r][c]' if 'distance[r - 1][c] + 1' is smaller
 - If 'c' is greater than 0, then we can find the minimum distance
 to a 0 from the cell to the left
 - Update 'distance[r][c]' if 'distance[r][c - 1] + 1' is smaller
 - We will find the minimum distance to the cell to the right and below
 - Iterate through from bottom right to top left, denoted as 'r, c'
 - If 'r' is not at the last row, then we can find the minimum distance
 to a 0 from the cell below
 - Update 'distance[r][c]' if 'distance[r + 1][c] + 1' is smaller
 - If 'c' is not at the last column, then we can find the minimum distance
 to a 0 from the cell to the right
 - Update 'distance[r][c]' if 'distance[r][c + 1] + 1' is smaller
 - Return 'distance'

 What is the Time and Space Complexity?
 - Time Complexity = O(3*n) = O(n), where 'n' is the total number of cells
 - O(3*n), fill 'distance' with max distance + 2 iterations
 - Space Complexity = O(n), where 'n' is the total number of cells
 - O(n), distance matrix

 Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

 The distance between two adjacent cells is 1.



 Example 1:

 Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 Output: [[0,0,0],[0,1,0],[0,0,0]]
 Example 2:


 Input: mat = [[0,0,0],
               [0,1,0],
               [1,1,1]]
 Output: [[0,0,0],
          [0,1,0],
          [1,2,1]]
 */
public class ZeroOneMatrix {
    private static final int MAX_DISTANCE = 10000;
    public static void main (String[] args ){
        int[][] matrix = {
                {1,1,1},
                {0,1,0},
                {1,1,1}
        };
        int[][] output = updateMatrixBFS(matrix);
        for(int i =0 ; i<output.length ; i++ ) {
            for (int j=0; j<output[0].length;j++) {
                System.out.print(" "+output[i][j]);
            }
            System.out.println();
        }
    }
    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] distance = new int[m][n];

        for (int r = 0; r < m; r++) {
            Arrays.fill(distance[r], MAX_DISTANCE);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    distance[r][c] = 0;
                    continue;
                }

                if (r > 0) distance[r][c] = Math.min(distance[r][c], distance[r - 1][c] + 1);
                if (c > 0) distance[r][c] = Math.min(distance[r][c], distance[r][c - 1] + 1);
            }
        }

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r != m - 1) distance[r][c] = Math.min(distance[r][c], distance[r + 1][c] + 1);
                if (c != n - 1) distance[r][c] = Math.min(distance[r][c], distance[r][c + 1] + 1);
            }
        }

        return distance;
    }



    /**
     *
     * 1. apply bfs on zero values and store -1 for other matrix data to denote they
     * are not visited yet.
     *
     * 2. traverse level order wise and for each level update distance only of those
     * indexes who has -1 assigned and currently neighbor of queue.poll.
     *
     * 3. add such element to back of queue also for next level traversal.
     *
     * 4. in this way those who are not reachable to any zero in first attempt (i.e.
     * first level), for them new level is checked and hence length counter will
     * increased by 1
     *
     * 5. now for those new queue element length will be set to updated length if
     * that cell has -1.
     *
     * @param mat
     * @return updated matrix with distance
     */
    public static int[][] updateMatrixBFS(int[][] mat) {
        // Queue to hold the co-ordinates
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    // only those added to queue who has 0 value.
                    queue.add(new int[] { i, j });
                } else {
                    // else set value to -1 to indicate length needed to be updated here.
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // hold level count
            length++;
            // traverse level order wise
            while (size-- > 0) {
                int[] rc = queue.poll();
                // for each element in queue try all 4 directions
                for (int[] dir : dirs) {
                    int r = rc[0] + dir[0];
                    int c = rc[1] + dir[1];
                    // if out of range or -1 it means no need to process it.
                    if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == -1) {
                        // if not already -1. update length
                        mat[r][c] = length;
                        // add element to queue for processing
                        queue.add(new int[] { r, c });
                    }
                }
            }
        }

        return mat;
    }
}