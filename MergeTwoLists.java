/**
 * @Author: WSS
 * @Date: 2019/3/12
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    //填充法（自制）
    static class Solution1 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null){
                return null;
            }else if (l1 == null){
                return l2;
            }else if(l2 == null){
                return l1;
            }

            ListNode head = l1;
            ListNode fir = l1;
            ListNode sec = l2;
            if (l1.val > l2.val){
                fir = l2;
                sec = l1;
                head = l2;
            }

            while (fir != null && sec != null){
                if (fir.val <= sec.val && ( fir.next == null || fir.next.val > sec.val )){
                    ListNode temp = new ListNode(sec.val);
                    if (fir.next != null){
                        temp.next = fir.next;
                    }
                    fir.next = temp;
                    sec = sec.next;
                    fir = fir.next;
                }else {
                    fir = fir.next;
                }
            }
            return head;
        }
    }

    //仿归并排序合并过程
    class Solution2 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
            // 任一为空，直接连接另一条链表
            if (l1 == null) {
                cur.next = l2;
            } else {
                cur.next = l1;
            }
            return dummyHead.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //建立有序链表1
    public static ListNode creatList1(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(4);
        ln2.next = ln3;
        return ln1;
    }

    //建立有序链表2
    public static ListNode creatList2(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(3);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(4);
        ln2.next = ln3;
        return ln1;
    }

    //打印数组
    public static void printList(ListNode result){
        for (ListNode temp = result; temp != null; temp = temp.next) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode test1 = creatList1();
        ListNode test2 = creatList2();
        Solution1 solution1 = new Solution1();
        printList(solution1.mergeTwoLists(test1,test2));//1->1->2->3->4->4
    }
}

