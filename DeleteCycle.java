import java.util.HashSet;
import java.util.Set;

/**
 * @Author: WSS
 * @Date: 2019/3/13
 * @Description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 */
public class DeleteCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //哈希表
    static class Solution1 {
        public ListNode detectCycle(ListNode head) {
            if(head == null || head.next == null){
                return null;
            }
            Set<ListNode> nodeSeen = new HashSet<>();
            while(head != null){
                if(nodeSeen.contains(head)){
                    return head;
                }else {
                    nodeSeen.add(head);
                }
                head = head.next;
            }
            return null;
        }
    }

    //快慢指针
    // 解题思路：分两个步骤，首先通过快慢指针的方法判断链表是否有环；接下来如果有环，则寻找入环的第一个节点。
    // 具体的方法为，首先假定链表起点到入环的第一个节点A的长度为a【未知】，到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】。
    // 现在我们想知道a的值，注意到快指针p2始终是慢指针p走过长度的2倍，所以慢指针p从B继续走（a + b）又能回到B点，
    // 如果只走a个长度就能回到节点A。但是a的值是不知道的，解决思路是曲线救国，注意到起点到A的长度是a，
    // 那么可以用一个从起点开始的新指针q和从节点B开始的慢指针p同步走，相遇的地方必然是入环的第一个节点A。
    static class Solution2{
        public ListNode detectCycle(ListNode head){
            if(head == null || head.next == null){
                return null;
            }

            //先判断链表是否有环
            boolean flag = false;
            ListNode slow = head;
            ListNode fast = head;
            while(true){
                if (fast.next == null || fast.next.next == null){
                    break;
                }
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast){
                    flag = true;
                    break;
                }
            }

            //如果有环则找出入环节点
            if (flag){
                ListNode q = head;
                while (q != slow){
                    slow = slow.next;
                    q = q.next;
                }
                return q;
            }else {
                return null;
            }

        }
    }

    //建立环链表
    public static ListNode creatList(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(3);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(4);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(5);
        //环的入口设定为ln2,值为2
        ln4.next = ln2;
        return ln1;
    }

    public static void main(String[] args) {
        ListNode test = creatList();
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.detectCycle(test).val);// 2
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.detectCycle(test).val);// 2
    }
}

