package com.seena.studyplan.algorithm.day7dfs;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 *
 * Return the modified image after performing the flood fill.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: image = [
 *                [1,1,1],
 *                [1,1,0],
 *                [1,0,1]
 *                ],
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 *
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * Output: [[2,2,2],[2,2,2]]
 *
 */
public class FloodFillDFSExample {
    public static void main(String[] args) {
        int[][] input = {{1,1,1}, {1,1,0},{1,0,1}};
        int[][] output = floodFill(input, 1, 1, 2);

        for (int i = 0; i< output.length ; i++) {
            for (int j =0; j < output[i].length ; j++) {
                System.out.print(" " + output[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] floodFill(int[][] image, int r, int c, int newColor) {
        if (image[r][c] == newColor) {
            return image;
        }
        DFS(image, r, c, image[r][c], newColor);
        return image;
    }

    private static void DFS(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || r >= image.length || c <0 || c >= image[0].length || image[r][c] != color) {
            return;
        }
        image[r][c] = newColor;
        DFS(image, r+1, c, color, newColor);
        DFS(image, r-1, c, color, newColor);
        DFS(image, r, c+1, color, newColor);
        DFS(image, r, c-1, color, newColor);
    }
}
