/*

https://leetcode.com/problems/unique-paths-iii/

On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

*/


class Solution {
int Totalpath = 0;
    public int uniquePathsIII(int[][] grid) {
        int Totalzero = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)Totalzero++;
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,Totalzero);
                }
            }
        }
        return Totalpath;
    }
    
    void dfs(int[][] grid,int i,int j,int Totalzero){


        //Base Condition
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]==-1 ||
          (grid[i][j]==2 && Totalzero!=0) || grid[i][j]==99)return;
        
        if(grid[i][j]==2 && Totalzero==0)Totalpath++;
        if(grid[i][j]==0)Totalzero--;
        
           int temp = grid[i][j];
           grid[i][j]=99;
        
          dfs(grid,i+1,j,Totalzero);
          dfs(grid,i-1,j,Totalzero);
          dfs(grid,i,j+1,Totalzero);
          dfs(grid,i,j-1,Totalzero);
        
          grid[i][j]=temp;
        
    }
}