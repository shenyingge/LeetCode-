package daily;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 方法：动态规划
 * 使用dp数组，记录（结果包含当前元素）的前i个元素中，能构成的最长上升子序列长度
 * 当dp到i时，遍历i之前的所有最长子序列长度
 * 若nums[i] > nums[j]，则增加一个dp[j]+1与当前dp[i]进行比较，取大数
 * 若小，则不进行操作
*/
public class P300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1)return 1;
        int[] dp = new int[nums.length];
        int res = 0;
        //相当于memset
        Arrays.fill(dp,1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
                //System.out.println(dp[i]);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
