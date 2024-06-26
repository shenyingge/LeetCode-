package daily;

/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * 方法：先遍历，再递归，递归过程中改变已遍历的岛屿值为-1，防止下次遍历继续计数
*/
public class P695 {
    static int res = 0;

    public static void main(String[] args) {
        P695 instance = new P695();
        int[][] grid = {{1,0,1,1},{1,0,1,1}};
        instance.maxAreaOfIsland(grid);
        System.out.println(res);
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0)return 0;
        if(grid[0].length == 0)return 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int n = dfs(grid,i,j);
                    res = Math.max(n,res);
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length ||
                grid[i][j] != 1){
            return 0;
        }else{
            grid[i][j] = -1;
            int r = dfs(grid,i+1,j)+
                    dfs(grid,i,j+1)+
                    dfs(grid,i-1,j)+
                    dfs(grid,i,j-1);
            return r+1;
        }
    }
}
