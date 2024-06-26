package daily;

/**
 * 面试题 10.01. 合并排序的数组
 *
 * 从后往前放元素。
 * 先准备一个定位指针指向A数组的最后位置。
 * 分别放两个指针，对比A和B的元素，较小值的指针不动，较大值赋值给定位指针，较大值的指针减一
 * 判断完成的标准为B数组
 * 如果B的位置先到了-1，则结束
 * 如果A的位置先到了-1，再把B剩余的元素依次加到A中
 *
 * 作者：shenyingge
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci/solution/he-bing-pai-xu-de-shu-zu-by-shenyingge/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class P10_01 {
    void merge(int[] A, int m, int[] B, int n) {
        if(m == 0){
            System.arraycopy(B,0,A,0,B.length);
            return;
        }
        if(n == 0)return;
        int i = A.length-1;
        n--;
        m--;
        while(n >= 0 && m >= 0){
            if(A[m] > B[n]){
                A[i] = A[m];
                m--;
            }
            else{
                A[i] = B[n];
                n--;
            }
            i--;
        }
        while(n >= 0){
            A[i] = B[n];
            i--;n--;
        }
    }
}
