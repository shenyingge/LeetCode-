package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35. 复杂链表的复制
 * 思路1：存储复制结点的映射关系，来找到对应的next、random结点
 * 思路2：在每个结点后复制对应结点，通过位置来确定对应的映射关系。
 *       1 -> 2 -> 3，复制后 1 -> 1' -> 2 -> 2' -> 3 -> 3'
 *       然后分离1'->2'->3'
 */

public class LCOF_35 {
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        Node new_head = map.get(head);
        Node new_cur = new_head;

        while(cur != null) {
            new_cur.next = map.get(cur.next);
            new_cur.random = map.get(cur.random);
            cur = cur.next;
            new_cur = new_cur.next;
        }
        return new_head;
    }
}