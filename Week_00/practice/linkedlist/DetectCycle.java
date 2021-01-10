package practice.linkedlist;

import java.util.HashMap;
import java.util.HashSet;

// 142 环形链表 II  https://leetcode-cn.com/problems/linked-list-cycle-ii/
public class DetectCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if(set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
