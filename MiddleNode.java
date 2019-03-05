/**
 * @Author: WSS
 * @Date: 2019/3/5
 * @Description: 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *              如果有两个中间结点，则返回第二个中间结点。
 *              eg：输入：[1,2,3,4,5]
 *                 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 *                返回的结点值为 3 。
 *
 *               输入：[1,2,3,4,5,6]
 *               输出：此列表中的结点 4 (序列化形式：[4,5,6])
 */
public class MiddleNode {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /***
     * 建立实验链表
     *  若size=5
     *  则建立一个1->2->3->4->5的链表
     *  返回表头索引
     * @param size ：链表长度
     * @return 表头
     */
    public static ListNode creatList(int size){
        ListNode preNode = new ListNode(1);
        ListNode member = preNode;
        for (int i = 2;i<size+1;i++){
            ListNode newNode = new ListNode(i);
            member.next = newNode;
            member = member.next;
        }
        return preNode;
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

    static class Solution1 {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode low = head;
            while (fast != null&&low != null&&fast.next != null){
                fast = fast.next.next;
                low = low.next;
            }
            return low;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = creatList(5);
        Solution1 solution1 = new Solution1();
        ListNode result1 = solution1.middleNode(listNode);
        printList(result1);//结果：3->4->5

    }
}
