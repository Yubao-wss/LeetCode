/**
 * @Author: WSS
 * @Date:
 * @Description: 反转一个单链表
 *              eg:输入: 1->2->3->4->5->NULL
 *                 输出: 5->4->3->2->1->NULL
 *
 */
public class ReverseList {
    static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    static class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null){
                return head;
            }
            ListNode pre = head;
            ListNode curr = head.next;
            ListNode temp = null;
            while (curr != null){
                temp = curr.next;
                curr.next = pre;
                //移动指针
                pre = curr;
                curr = temp;
            }
            head.next = null;
            return pre;
        }

    }

    static class Solution2{
        public ListNode reverseList(ListNode head){
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode fir = new ListNode(-1);
            //从前到后遍历原链表
            for(ListNode temp = dummyHead.next;temp!=null;temp=temp.next){
                //使用头插法插入新链表
                ListNode newNode = new ListNode(temp.val);
                newNode.next = fir.next;
                fir.next = newNode;
            }
            return fir.next;
        }
    }

    static class Solution3{
        public ListNode reverseList(ListNode head){
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            if (head == null || head.next == null){
                return head;
            }else {
                ListNode f = dummyHead.next;
                ListNode s = f.next;
                while (s!=null){
                    //下一次迭代的位置
                    f.next = s.next;
                    s.next = dummyHead.next;
                    dummyHead.next = s;
                    s = f.next;
                }
                return dummyHead.next;
            }
        }
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

    //建立实验链表
    public static ListNode creatList(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(3);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(4);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(5);
        ln4.next = ln5;
        return ln1;
    }

    public static void main(String[] args) {

        ListNode listNode = creatList();

        Solution1 sl1 = new Solution1();
        ListNode result1 = sl1.reverseList(listNode);
        printList(result1);
        //输出：5->4->3->2->1

        listNode = creatList();
        Solution2 sl2 = new Solution2();
        ListNode result2 = sl2.reverseList(listNode);
        printList(result2);
        //输出：5->4->3->2->1

        listNode = creatList();
        Solution3 sl3 = new Solution3();
        ListNode result3 = sl3.reverseList(listNode);
        printList(result3);
        //输出：5->4->3->2->1
    }
}
