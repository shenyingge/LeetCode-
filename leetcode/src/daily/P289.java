package daily;

/**
 * 289. 生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
*/

public class P289 {
    public void gameOfLife(int[][] board) {
        //0 dead
        //1 alive 
        //2 alive->dead 
        //3 dead->alive
        int[] indi = new int[]{-1,-1,-1,0,1,1,1,0};
        int[] indj = new int[]{-1,0,1,1,1,0,-1,-1};
        for(int i = 0 ; i < board.length; ++i){
            for(int j = 0; j < board[i].length; ++j){
                int active = 0;
                for(int k = 0; k < 8; ++k){
                    int tmpi = i+indi[k];
                    int tmpj = j+indj[k];
                    if(tmpi >= 0 && tmpi < board.length &&
                            tmpj >= 0 && tmpj < board[i].length)
                    {
                        if(board[tmpi][tmpj] == 1 ||
                                board[tmpi][tmpj] == 2){
                            ++active;
                        }
                    }
                }
                if(board[i][j] == 1 ||
                        board[i][j] == 3){
                    if(active < 2 || active > 3) board[i][j] = 2;
                }else if(active == 3) board[i][j] = 3;
            }
        }
        for(int i = 0 ; i < board.length; ++i){
            for(int j = 0; j < board[i].length; ++j){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
}
