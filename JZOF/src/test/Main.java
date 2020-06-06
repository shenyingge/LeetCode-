package test;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> lists = new  ArrayList<>();
        for(int i = 0; i < n; ++i){
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }
        lists.get(0).add(1);
        for(int i = 1; i < n; ++i){
            for(int j = 0; j <= i; ++j){
                if(j == 0 || j == i)lists.get(i).add(1);
                else {
                    int num = lists.get(i-1).get(j-1)+lists.get(i-1).get(j);
                    lists.get(i).add(num);
                }
            }
        }
        for(int i = 0; i < n; ++i) {
            int block_cnt = n - i - 1;
            for (int j = 0; j < block_cnt; ++j) {
                System.out.printf(" ");
            }
            for (int j = 0; j <= i; ++j) {
                System.out.printf(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

