package domain;

import java.util.Arrays;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * 方法一：深度优先
 * 方法二：广度优先
*/
public class LCOF_13 {
    int res = 0;
    public int movingCount(int m, int n, int k) {
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(matrix[i],0);
        }
        rec(matrix,0,0,k);
        return res;
    }
    void rec(int[][] matrix, int i, int j, int k){
        if(i < 0 || i >= matrix.length ||
                j < 0 || j >= matrix[0].length ||
                matrix[i][j] == 1) return;
        int ni = 0;
        int nj = 0;
        int t_i = i, t_j = j;
        while(t_i != 0){
            ni += (t_i % 10);
            t_i /= 10;
        }
        while(t_j != 0){
            nj += (t_j % 10);
            t_j /= 10;
        }
        if(ni + nj <= k){
            matrix[i][j] = 1;
            res++;
        }else return;
        rec(matrix,i+1,j,k);
        rec(matrix,i,j+1,k);
        rec(matrix,i-1,j,k);
        rec(matrix,i,j-1,k);
    }
}
