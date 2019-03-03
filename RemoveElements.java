# Leetcode
Leetcode练习题
/**
 * @Author: WSS
 * @Date: 2019/3/3
 * @Description: 203.移除链表元素 eg:
 *              输入1->2->6->6->3 ,将6移除
 *              返回1->2->3
 */
public class RemoveElements{
    public static void main(String[] args) {

        //建立链表
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(6);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(3);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(4);
        ln4.next = ln5;
        ListNode ln6 = new ListNode(5);
        ln5.next = ln6;
        ListNode ln7 = new ListNode(6);
        ln6.next = ln7;


        Solution1 sl1 = new Solution1();
        ListNode result = sl1.removeElements(ln1, 6);
        for (ListNode temp = result; temp != null; temp = temp.next) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            }
        }
        //输出结果：1->2->3->4->5

        System.out.println();

        Solution2 sl2 = new Solution2();
        ListNode result2 = sl2.removeElements(ln1, 2);
        for (ListNode temp = result2; temp != null; temp = temp.next) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            }
        }
        //输出结果：1->3->4->5
    }

    static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
      }
    }


static class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        //给定值恰好为头节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            //当前链表已无节点
            return null;
        }
        //当前链表不为空且第一个节点绝对不是给定的值
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}

static class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        //建立虚节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //此时链表中所有节点都有前驱节点
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
    }
}
