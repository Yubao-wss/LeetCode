/**
 * @Author: WSS
 * @Date: 2019/3/12
 * @Description: 编写一个程序，找到两个单链表相交的起始节点。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/
 */
public class GetIntersectionNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //指针比较
    static class Solution1 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null){
                return null;
            }

            ListNode fir = headA;
            ListNode sec = headB;
            while (fir != sec){
                fir = fir == null ? headB : fir.next;
                sec = sec == null ? headA : sec.next;
            }
            return fir;
        }
    }

    //等长比较
    static class Solution2{
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null){
                return null;
            }

            //先使两个链表等长
            int len1 = getListLength(headA);
            int len2 = getListLength(headB);
            while(len1 > len2){
                headA = headA.next;
                len1--;
            }
            while (len1 < len2){
                headB = headB.next;
                len2--;
            }

            //比较后续元素
            while (headA != null){
                if (headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }
        //获取链表长度
        private int getListLength(ListNode head){
            int length = 0;
            for(ListNode temp = head;temp != null;temp = temp.next){
                length++;
            }
            return length;
        }
    }

    //打印数组
    public static void printList(ListNode result){
        if (result == null){
            System.out.println("null");
        }
        for (ListNode temp = result; temp != null; temp = temp.next) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //建立测试情况A
        ListNode fir1 = new ListNode(4);
        ListNode fir2 = new ListNode(1);
        ListNode fir3 = new ListNode(8);
        ListNode fir4 = new ListNode(5);
        fir1.next = fir2;
        fir2.next = fir3;
        fir3.next = fir4;

        ListNode sec1 = new ListNode(5);
        ListNode sec2 = new ListNode(0);
        ListNode sec3 = new ListNode(1);
        sec1.next = sec2;
        sec2.next = sec3;
        sec3.next = fir3;

        //建立测试情况B
        ListNode thi1 = new ListNode(2);
        ListNode thi2 = new ListNode(6);
        ListNode thi3 = new ListNode(4);
        thi1.next = thi2;
        thi2.next = thi3;

        ListNode fou1 = new ListNode(1);
        ListNode fou2 = new ListNode(5);
        fou1.next = fou2;

        //测试函数
        Solution1 solution1 = new Solution1();
        printList(solution1.getIntersectionNode(fir1,sec1));// 8->5
        printList(solution1.getIntersectionNode(thi1,fou1));// null

        Solution2 solution2 = new Solution2();
        printList(solution2.getIntersectionNode(fir1,sec1));// 8->5
        printList(solution2.getIntersectionNode(thi1,fou1));// null

    }
}

