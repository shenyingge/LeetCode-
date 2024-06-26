package domain;

/**
 * 面试题15. 二进制中1的个数
*/
public class LCOF_15 {

    public static void main(String[] args) {
        LCOF_15 test = new LCOF_15();
        int res = test.hammingWeight(11);
        System.out.println(res);
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
