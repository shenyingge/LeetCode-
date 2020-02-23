package domain;

import utils.InputUtils;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//03. 数组中的重复数字
public class LCOF_03 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] nums = new int[7];
        Scanner scanner = InputUtils.getFileInput("C:\\Users\\sheny\\Desktop\\in.txt");
        for(int i = 0; i < 7; i++){
            nums[i] = scanner.nextInt();
        }
        int num = new LCOF_03().findRepeatNumber(nums);
        System.out.println(num);
    }
    public int findRepeatNumber(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!s.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}
