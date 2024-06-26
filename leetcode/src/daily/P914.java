package daily;

import java.util.Arrays;

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 方法：求得所有数字对应个数的最大公约数
 *
 * 辗转相除求最大公约数
 *     public int gcd(int a, int b){
 *         return a == 0 ? b : gcd(b%a, a);
 *     }
 *  a作为较小值，b%a的值作为下次相除的除数
 * 若初次比较时，a>b，递归调用gcd(b%a,a)时将交换a，b位置。
 * 若a为0，表示上次的a，b有倍数关系，返回此时的b即为公约数。
*/

public class P914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] cnt = new int[10000];
        Arrays.fill(cnt,0);
        for(int i:deck) cnt[i]++;
        int g = -1;
        for(int i:cnt) {
            if(g == -1) g = i;
            else g = gcd(g,i);
        }
        return g > 1;
    }
    public int gcd(int a, int b){
        return a == 0 ? b : gcd(b%a, a);
    }
}
