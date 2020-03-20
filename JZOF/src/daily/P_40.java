package daily;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
*/

public class P_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for(int i : arr){
            queue.add(i);
        }
        int[] res = new int[k];
        while(!queue.isEmpty() && k > 0){
            res[k-1] = queue.poll();
            k--;
        }
        return res;
    }
}
