package daily;

import dataStruct.ListNode;

/**
 * P206 反转链表
*/
public class P206 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }else{
            if(head.next == null)return head;
            else{
                ListNode next = head.next;
                ListNode newHead = reverseList(next);
                head.next.next = head;
                head.next = null;
                return newHead;
            }
        }
    }
}
