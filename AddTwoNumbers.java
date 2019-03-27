/**
 * @Author: WSS
 * @Date: 2019/3/26 16:40
 * @Description: 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    //创建指定单链表
    public static ListNode creatAssignList(int[] data){
        assert (data.length > 0);
        ListNode head = new ListNode(-1);
        ListNode result = head;
        for (int i = 0;i < data.length;i++){
            ListNode listNode = new ListNode(data[i]);
            head.next = listNode;
            head = head.next;
        }
            return result.next;
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
}


public class AddTwoNumbers { 
    /*
    就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1 和 l2 的表头开始相加。
    由于每位数字都应当处于 0 … 9 的范围内，我们计算两个数字的和时可能会出现“溢出”。
    例如，5 + 7 = 5+7 = 12。在这种情况下，我们会将当前位的数值设置为 2，并将进位 carry = 1 带入下一次迭代。
    进位 carry 必定是 0 或 1，这是因为两个数字相加（考虑到进位）可能出现的最大和为 9 + 9 + 1 = 9+9+1=19。
*/
/*
    特别注意以下情况：
    当一个列表比另一个列表长时
    当一个列表为空时，即出现空列表
    求和运算最后可能出现额外的进位，这一点很容易被遗忘
*/
    static class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1);
            ListNode q = l1, p = l2, curr = dummyHead;
            int carry = 0;

            while (p != null || q != null){
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;

                int sum = carry + x + y;
                curr.next = new ListNode(sum % 10);
                carry = sum / 10;
                curr = curr.next;

                if (p != null){ p = p.next; }
                if (q != null){ q = q.next; }
            }

            if (carry != 0){
                curr.next = new ListNode(1);
            }

            return dummyHead.next;
        }
    }
    public static void main(String[] args) {
        ListNode test1 = ListNode.creatAssignList(new int[]{2,4,3});
        ListNode test2 = ListNode.creatAssignList(new int[]{5,6,4});
        AddTwoNumbers.Solution1 solution1 = new Solution1();
        ListNode.printList(solution1.addTwoNumbers(test1,test2));
        /*
            结果：7->0->8
        */
        ListNode test3 = ListNode.creatAssignList(new int[]{9,9});
        ListNode test4 = ListNode.creatAssignList(new int[]{1});
        ListNode.printList(solution1.addTwoNumbers(test3,test4));
        /*
            结果：0->0->1
        */
    }
}
