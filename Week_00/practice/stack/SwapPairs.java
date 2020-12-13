package practice.stack;

import java.util.Stack;

// 24 两两交换链表中的节点
public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode head1 = new ListNode(9);
        ListNode head2 = new ListNode(8);
        ListNode head3 = new ListNode(7);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        swapPairs(head);
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        // 初始化栈 , 虚拟头节点 ，指向虚拟头节点的引用（用于结果返回）， 当前指针
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode vhead = new ListNode();
        ListNode res = vhead;
        ListNode cur = head;
        // 循环 入栈， 出栈
        while (cur != null && cur.next != null) {
            stack.push(cur);
            stack.push(cur.next);
            System.out.println(" stack size : " + stack.size());
            cur = cur.next.next;

            vhead.next = stack.pop();
            vhead = vhead.next;
            vhead.next = stack.pop();
            vhead = vhead.next;

            displayNode(vhead);
        }

        if(cur != null) vhead.next = cur;
        else vhead.next = null;

        // 返回虚拟头节点的next节点
        return res.next;
    }

    public static void displayNode(ListNode vhead) {
        while (vhead != null){
            System.out.print(vhead.val + " , ");
            vhead =vhead.next;
        }
        System.out.println(" ");
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}