package LinkedList;


// 206 反转链表
public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        System.out.println(head);
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }
}
