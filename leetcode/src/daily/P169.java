package daily;

/**
 * 169. 多数元素
 * 摩尔投票法、排序、map
*/
public class P169 {
    //摩尔投票法
    public int majorityElement(int[] nums) {
        int res = 0;
        int cnt = 0;
        for(int i : nums){
            if(cnt == 0) {
                res = i;
                cnt++;
            }
            else if(i == res){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        return res;
    }
}
