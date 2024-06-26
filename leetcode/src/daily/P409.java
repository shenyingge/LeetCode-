package daily;

import java.util.Arrays;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
*/
public class P409 {
    public int longestPalindrome(String s) {
        int[] nums = new int[52];
        Arrays.fill(nums,0);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                nums[c-'A']++;
            }else{
                nums[c-'a'+26]++;
            }
        }
        int cnt = 0;
        int odd = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0) cnt += nums[i];
            else{
                cnt += nums[i]-1;
                odd = 1;
            }
        }
        return cnt+odd;
    }
}
