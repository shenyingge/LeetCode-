package domain;

/**
 * 面试题12. 矩阵中的路径
 * java中二维数组在函数中的传递是引用传递，是浅拷贝，改变的是内存中的数据而不是值
 * 重点：
 *             boolean t1 = exist_str(board, tmp1, word, i+1, j, ind + 1);
 *             boolean t2 = exist_str(board, tmp2, word, i, j+1, ind + 1);
 *             boolean t3 = exist_str(board, tmp3, word, i-1, j, ind + 1);
 *             boolean t4 = exist_str(board, tmp4, word, i, j-1, ind + 1);
 * 这种写法造成大量内存占用
 *
 * 需改为：
 *             boolean res = exist_str(board, words, i+1, j, ind + 1)||
 *                     exist_str(board, words, i, j+1, ind + 1)||
 *                     exist_str(board, words, i-1, j, ind + 1)||
 *                     exist_str(board, words, i, j-1, ind + 1);
 */
public class LCOF_12 {
    //一
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        boolean res = exist(board, word);
        System.out.println(res);
    }

    public static boolean exist(char[][] board, String word) {
        if(board.length == 0)return false;
        else if(board[0].length == 0)return false;
        if(word.length() == 0)return true;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    int[][] t = new int[m][n];
                    for (int t_i = 0; t_i < m; t_i++) {
                        for (int t_j = 0; t_j < n; t_j++) {
                            t[t_i][t_j] = 0;
                        }
                    }
                    boolean res = exist_str(board, t, word, i, j, 0);
                    if(res)return true;
                }
            }
        }
        return false;
    }
    public static boolean exist_str(char[][] board, int[][] t, String word, int i, int j, int ind){
        if(ind >= word.length())return true;
        else {
            if(i < 0 || i >= board.length ||
                    j < 0 || j >= board[0].length)return false;
            if(board[i][j] != word.charAt(ind) || t[i][j] == 1){
                return false;
            }
            t[i][j] = 1;
            int[][] tmp1 = copyArray(t);
            int[][] tmp2 = copyArray(t);
            int[][] tmp3 = copyArray(t);
            int[][] tmp4 = copyArray(t);
            boolean t1 = exist_str(board, tmp1, word, i+1, j, ind + 1);
            boolean t2 = exist_str(board, tmp2, word, i, j+1, ind + 1);
            boolean t3 = exist_str(board, tmp3, word, i-1, j, ind + 1);
            boolean t4 = exist_str(board, tmp4, word, i, j-1, ind + 1);
            return t1||t2||t3||t4;
        }
    }
    public static int[][] copyArray(int[][] t){
        int[][] temp = new int[t.length][];
        for(int i = 0; i < t.length; i++){
            temp[i] = t[i].clone();
        }
        return temp;
    }

    //二
    public boolean exist1(char[][] board, String word) {
        if(board.length == 0)return false;
        else if(board[0].length == 0)return false;
        if(word.length() == 0)return true;
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(words[0] == board[i][j]){
                    boolean res = exist_str(board, words, i, j, 0);
                    if(res)return true;
                }
            }
        }
        return false;
    }
    public boolean exist_str(char[][] board, char[] words, int i, int j, int ind){
        if(i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length || board[i][j] != words[ind] || board[i][j] == '!')return false;
        else {
            if(ind == words.length-1)return true;
            char tmp = board[i][j];
            board[i][j] = '!';
            boolean res = exist_str(board, words, i+1, j, ind + 1)||
                    exist_str(board, words, i, j+1, ind + 1)||
                    exist_str(board, words, i-1, j, ind + 1)||
                    exist_str(board, words, i, j-1, ind + 1);
            board[i][j] = tmp;
            return res;
        }
    }

}
