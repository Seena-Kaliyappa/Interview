package com.seena.practise.ds.queue_stack;

public class NumberOfIsland {
    public static void main(String[] args){
        String[][] grid1 = {
                {"1","1","1","1","0"},
                {"1","1","0","1","0"},
                {"1","1","0","0","0"},
                {"0","0","0","0","0"}
        };

        String[][] grid2 = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        int[][] grid3 = {
                {9999,-1,0,9999,9999},
                {9999,9999,9999,-1},
                {9999,-1,9999, 9999,9999},
                {0,-1,9999,0,9999}
        };
        System.out.println(numIslands(grid1));
        //Walls and Gates
        wallsAndGates(grid3);
    }

    private static void wallsAndGates(int[][] grid) {
        for(int i =0; i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                // if it is gate, then only update
                if(grid[i][j] == 0){
                    dfs(grid, i,j,0);
                }
            }
        }
    }

    public static int numIslands(String[][] grid) {

        int numberOfIsland = 0;
        for(int i =0; i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == "1"){
                    numberOfIsland += dfs(grid, i,j);
                }
            }
        }
        return numberOfIsland;
    }

    private static int dfs(String[][] grid , int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == "0"){
            return 0;
        }
        grid[i][j] = "0";
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid,i,j-1);
        dfs(grid,i, j+1);
        return 1;
    }

    private static void dfs(int [][] grid , int i, int j, int distance) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] < distance){
            return;
        }
        grid[i][j] = distance;
        dfs(grid, i-1, j,distance+1);
        dfs(grid, i+1, j,distance+1);
        dfs(grid,i,j-1,distance+1);
        dfs(grid,i, j+1,distance+1);
    }
}
