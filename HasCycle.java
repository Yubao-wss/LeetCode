import java.util.HashSet;
import java.util.Set;

/**
 * @Author: WSS
 * @Date: 2019/3/11
 * @Description: 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class HasCycle {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    //建立环形实验链表
    public static ListNode creatCycleList(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(3);
        ln2.next = ln3;
        ln3.next = ln2;
        return ln1;
    }

    //建立非环形实验链表
    public static ListNode creatList(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(3);
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

    /*快慢针法(赛跑）
    时间复杂度：O(n)
    空间复杂度：O(1)*/
    static class Solution1{
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null){
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast){
                if (fast == null || fast.next == null){
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }

    /*哈希表
    时间复杂度：O(n)
    空间复杂度：O(n)*/
    static class Solution2{
        public boolean hasCycle(ListNode head){
            Set<ListNode> nodesSeen = new HashSet<>();
            while (head != null){
                if (nodesSeen.contains(head)){
                    return true;
                }else {
                    nodesSeen.add(head);
                }
                head = head.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode test1 = creatList();
        ListNode test2 = creatCycleList();
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

        System.out.println(solution1.hasCycle(test1));//false
        System.out.println(solution1.hasCycle(test2));//true
        System.out.println(solution2.hasCycle(test1));//false
        System.out.println(solution2.hasCycle(test2));//true

    }

}

