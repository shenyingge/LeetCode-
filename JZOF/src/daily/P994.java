package daily;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//994. 腐烂的橘子
/*
    多源广度优先搜索
    最早的腐烂橘子加到队列中，以这些橘子为最早遍历起点，广度优先遍历
 */

public class P994 {
    public int orangesRotting(int[][] grid) {
        int[] indi = {-1,0,1,0};
        int[] indj = {0,-1,0,1};
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    Pair<Integer,Integer> tmp = new Pair<>(i,j);
                    q.add(tmp);
                }else if(grid[i][j] == 1) cnt++;
            }
        }
        if(cnt == 0)return 0;
        else if(q.isEmpty())return -1;
        int step = 0;
        while(!q.isEmpty()){
            step++;
            Queue<Pair<Integer,Integer>> tmp = new LinkedList<>();
            while(!q.isEmpty()){
                Pair<Integer,Integer> p = q.element();
                q.remove();
                for(int k = 0; k < 4; k++){
                    int indexi = p.getKey()+indi[k];
                    int indexj = p.getValue()+indj[k];
                    if(indexi < 0 || indexi >= grid.length ||
                            indexj < 0 || indexj >= grid[0].length)continue;
                    if(grid[indexi][indexj] == 2 || grid[indexi][indexj] == 0)continue;
                    else{
                        tmp.add(new Pair<>(indexi,indexj));
                        grid[indexi][indexj] = 2;
                        cnt--;
                    }
                    if(cnt == 0)return step;
                }
            }
            while(!tmp.isEmpty()){
                Pair<Integer,Integer> p = tmp.element();
                tmp.remove();
                q.add(p);
            }
        }
        return cnt>0 ? -1:step;
    }
}
