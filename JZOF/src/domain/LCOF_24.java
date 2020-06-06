package domain;

import dataStruct.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LCOF_24 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return head;
        else{
            ListNode p = head.next;
            ListNode res = reverseList(head.next);
            head.next = null;
            p.next = head;
            return res;
        }
    }
}
