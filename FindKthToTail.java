import java.io.Reader;

/**
 * @Author: WSS
 * @Date:
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
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
        public ListNode FindKthToTail(ListNode head,int k) {
            int size = 0;
            ListNode member = head;
            if(head == null){
                return null;
            }
                while (head!=null) {
                    size++;
                    head = head.next;
                }
                if (k>size){
                    return null;
                }
                for (int i = 1;i<=size-k;i++){
                    member = member.next;
                }
                return member;

        }
    }

    public static void main(String[] args) {
        ListNode testNode = creatList(5);
        Solution1 solution1 = new Solution1();
        ListNode result = solution1.FindKthToTail(testNode,1);
        printList(result);
        //输出：5
    }

}

