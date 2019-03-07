/**
 * @Author: WSS
 * @Date: 2019/3/7
 * @Description: 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *               k 是一个正整数，它的值小于或等于链表的长度。
 *               如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class reverseKGroup {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            int size = 0;
            ListNode testHead = head;
            for (;testHead!=null;testHead = testHead.next){
                size++;
            }
            if(k<0 || k>size) {
                throw new IndexOutOfBoundsException("k值非法！");
                //若要在LeetCode中提交通过，需要将上句改为 return head;
            }


            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode nkNext = head;
            ListNode nkStart = dummyHead;

            while (nkNext != null){
                //逆序一段
                ListNode f = nkStart.next;
                ListNode s = f.next;
                for (int i = 0;i<k-1;i++){
                    f.next = s.next;
                    s.next = nkStart.next;
                    nkStart.next = s;
                    s = f.next;
                }
                //移动双标
                for(int i = 0;i<k;i++){
                    nkStart = nkStart.next;
                }
                nkNext  = nkStart;
                for (int i = 0;i<k;i++){
                    nkNext = nkNext.next;
                    if(nkNext == null){
                        break;
                    }
                }
            }

            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        ListNode testNode = creatList(10);
        printList(testNode);
        ListNode resultNode = solution1.reverseKGroup(testNode,6);
        printList(resultNode);

        //输出结果：1->2->3->4->5
        //        3->2->1->4->5
    }
}

