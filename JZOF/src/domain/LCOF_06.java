package domain;

import dataStruct.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LCOF_06 {
    public static void main(String[] args) {
        LCOF_06 instance = new LCOF_06();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        int[] ints = instance.reversePrint2(listNode1);
        for(int i = 0; i < ints.length; i++){
            System.out.println(ints[i]);
        }
    }
    //方法一：list
    public static int[] reversePrint1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] is = new int[list.size()];
        int index = 0;
        for(int i = list.size()-1; i >= 0; i--){
            is[index++] = list.get(i);
        }
        return is;
    }

    //方法二：递归
    public int[] reversePrint2(ListNode head){
        List<Integer> list = new ArrayList<>();
        recur(head,list);
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
    void recur(ListNode head, List<Integer> list){
        if(head == null){
            return;
        }else{
            recur(head.next,list);
            list.add(head.val);
        }
    }
}