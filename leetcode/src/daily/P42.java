package daily;

/**
 * 42. 接雨水
 * 韦恩图解法
 * 积水面积 = S1 + S2 - 矩形面积 - 柱子面积
*/
public class P42 {
    int trap(int[] height) {
        int m1 = 0, m2 = 0;
        int s1 = 0, s2 = 0;
        int cnt = 0;
        for(int i = 0; i < height.length; ++i){
            m1 = Math.max(m1,height[i]);
            s1 += m1;
            cnt += height[i];
        }
        for(int i = height.length-1; i >= 0; --i){
            m2 = Math.max(m2,height[i]);
            s2 += m2;
        }
        return s1+s2-m1*height.length-cnt;
    }
}
