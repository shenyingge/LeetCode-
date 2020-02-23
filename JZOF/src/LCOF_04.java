public class LCOF_04 {

    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15},
                          {2,   5,  8, 12, 19},
                          {3,   6,  9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}};
        int target = 5;
        new LCOF_04().findNumberIn2DArray(matrix,target);
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0)return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = n-1;
        int mid = 0;
        while (l < r){
            mid = l+(r-l)/2;
            if(matrix[mid][0] < target){
                l = mid+1;
            }else if(matrix[mid][0] > target){
                r = mid-1;
            }else return true;
            System.out.printf(mid+" ");
        }
        System.out.println(mid);
        return false;
    }
}
