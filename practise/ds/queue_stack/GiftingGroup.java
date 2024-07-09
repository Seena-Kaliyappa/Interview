package com.seena.practise.ds.queue_stack;

/**
 * Author: eklxsnx
 * Email: seena.kali@gmail.com
 * Date: 6/21/2021 12:14 PM
 * Description: ""
 **/
public class GiftingGroup {

    public static void main(String[] args){
        int[][] input = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        int groups = giftingGroup1(input);
        System.out.println(" Number of groups " + groups);
    }

    private static int giftingGroup1(int[][] input) {
        int numberofGroups = 0;

        for( int i=0;i<input.length;i++){
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 1) {
                    numberofGroups += dfs1(input, i, j);

                }
            }
        }
        return numberofGroups;
    }

    private static int dfs1(int[][] input, int i, int j) {
        if (i <0 || i >= input.length || j < 0 || j >= input[i].length || input[i][j] == 0) {
            return 0;
        }
        input[i][j] = 0;
        dfs1(input ,i+1, j);
        dfs1(input, i-1, j);
        dfs1(input, i, j+1);
        dfs1(input, i, j-1);
        return 1;
    }

    private static int giftingGroup(int[][] input) {
        int[] visited = new int[input.length];
        int numberofGroups = 0;

        for( int i=0;i<input.length;i++){
            if(visited[i] == 0){
                dfs(input,visited,i);
                numberofGroups++;
            }
        }
        return numberofGroups;
    }

    private static void dfs(int[][] input, int[] visited, int i) {
        for(int j=0;j<input.length;j++){
            if(input[i][j] == 1 && visited[j] == 0){
                visited[j] =1;
                dfs(input, visited,j);
            }
        }
    }
}
