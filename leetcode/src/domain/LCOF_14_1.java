package domain;


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
