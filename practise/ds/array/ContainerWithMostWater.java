package com.seena.practise.ds.array;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */
//Two pointer approach
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max Rectangle Area " + maxRectacleArea(input));
    }

    private static int maxRectacleArea(int[] height) {
        int first = 0, last = height.length-1;
        int res = 0;
        while (first < last) {
            int min = Math.min(height[first], height[last]);
            int width = last - first;
            res = Math.max(res, min*width);

            if (height[first] < height[last]) {
                first++;
            } else {
                last--;
            }
        }

        return res;
    }
}
