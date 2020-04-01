package daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * P192. 排序数组
 * 方法：桶排序（只实现了正数排序）
*/
public class P912 {
    public static void main(String[] args) {
        P912 test = new P912();
        int[] nums = {11,10543,6,9,1111};
        test.sortArray(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    public int[] sortArray(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length; ++i){
            int t = nums[i];
            int num = 0;
            while(t != 0){
                t/=10;
                num++;
            }
            if(num > n) n = num;
        }
        int k = 0;
        while(k < n){
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < 10; ++i)list.add(new LinkedList<>());
            for(int i = 0; i < nums.length; ++i){
                int times = k;
                int t = nums[i];
                while(times > 0 && t != 0){
                    t /= 10;
                    times--;
                }
                list.get(t % 10).add(nums[i]);
            }
            int ind = 0;
            for(int i = 0; i < list.size(); ++i){
                for(int j = 0; j < list.get(i).size(); ++j){
                    nums[ind] = list.get(i).get(j);
                    ind++;
                }
            }
            k++;
        }
        return nums;
    }
}
