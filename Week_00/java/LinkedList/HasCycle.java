package LinkedList;

import java.util.HashSet;

//141 环形指针
public class HasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            }else {
                hashSet.add(head);
            }
            head = head.next;
        }
        return false;

    }
}
