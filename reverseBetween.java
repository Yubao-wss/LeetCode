/**
 * @Author: WSS
 * @Date: 2019/3/6
 * @Description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *               1 ≤ m ≤ n ≤ 链表长度。
 * eg:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class reverseBetween {

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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode mPre = dummyHead;
            //让 mPre指向 反转起点的前一个位置
            for (int i = 0; i < m - 1; i++) {
                mPre = mPre.next;
            }
            //三指针
            ListNode cur = mPre.next;
            ListNode next = cur.next;
            ListNode nNext = next;
            //反转
            for (int i = 0; i < n - m; i++) {
                nNext = next.next;
                next.next = cur;

                cur = next;
                next = nNext;
            }
            // 反转完毕，需要将两端与 mPre 和 nNext 连接
            mPre.next.next = nNext;
            mPre.next = cur;
            return dummyHead.next;
        }
      }

      static class Solution2{
          public ListNode reverseBetween(ListNode head, int m, int n){
              ListNode dummyHead = new ListNode(-1);
              dummyHead.next = head;
              ListNode startNode = dummyHead;
              for (int i = 0;i<m-1;i++){
                  startNode = startNode.next;
              }
              ListNode f = startNode.next;
              ListNode s = f.next;
              for(int i = 0;i<n-m;i++){
                  f.next = s.next;
                  s.next = startNode.next;
                  startNode.next = s;
                  s = f.next;
              }
              return dummyHead.next;
          }
      }


    public static void main(String[] args) {
        ListNode testNode = creatList(5);
        Solution1 solution1 = new Solution1();
        printList(testNode);//输出：1->2->3->4->5
        solution1.reverseBetween(testNode,2,4);
        printList(testNode);//输出：1->4->3->2->5

        Solution2 solution2 = new Solution2();
        testNode = creatList(5);
        printList(testNode);//结果：1->2->3->4->5
        solution2.reverseBetween(testNode,2,5);
        printList(testNode);//结果：1->5->4->3->2
    }
}
