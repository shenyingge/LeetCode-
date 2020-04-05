package domain;



/**
 * 面试题14- I. 剪绳子
 * 动态规划
 * 使用数组v记录每个结点
 * 结点first记录当前数值未拆分时能达到的最大值，可用于动态规划计算，不可用于答案
 * 结点second记录当前数值已拆分时能达到的最大值，即可用于计算，也可用于答案
 * v[i].first = i;
 * v[i].second = max((i-j)*v[j].first,(i-j)*v[j].second);
*/
class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class LCOF_14_1 {
    int cuttingRope(int n) {
        Pair[] v = new Pair[n+1];
        //first 未拆分
        //second已拆分
        v[1] = new Pair(1,0);
        for(int i = 2; i <= n; ++i){
            int m = 1;
            for(int j = i-1; j > 0; --j){
                m = Math.max((i-j)*v[j].first,m);
                m = Math.max((i-j)*v[j].second,m);
            }
            v[i] = new Pair(i,m);
        }
        return v[n].second;
    }
}
