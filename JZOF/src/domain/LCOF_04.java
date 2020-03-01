package domain;

public class LCOF_04 {

    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15},
                          {2,   5,  8, 12, 19},
                          {3,   6,  9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}};
        int target = 5;
        boolean res = new LCOF_04().findNumberIn2DArray(matrix,target);
        System.out.println(res);
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0)return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m-1;
        while(i>=0&&i<n&&j>=0&&j<m){
            if(matrix[i][j] > target)j--;
            else if(matrix[i][j] < target)i++;
            else return true;
        }
        return false;
    }
}
