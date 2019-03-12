/**
 * @Author: WSS
 * @Date:
 * @Description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    static class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null){
                return null;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = pHead;
            ListNode fir = dummyHead;
            ListNode sec = pHead;

            while (sec != null){
                if (sec.next != null && sec.next.val == sec.val ){
                    int key = sec.val;
                    ListNode remove = sec;
                    for (;remove.val == key;remove = remove.next){
                        fir.next = remove.next;
                        sec = fir.next;
                        if (remove.next == null){
                            break;
                        }
                    }
                }else {
                    sec = sec.next;
                    fir = fir.next;
                }
            }
            return dummyHead.next;
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

    //建立指定实验链表
    public static ListNode creatList(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(2);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(2);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(3);
        ln4.next = ln5;
        return ln1;
    }

    public static void main(String[] args) {
        ListNode test = creatList();
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplication(test);
        printList(result);//1->3
    }
}
