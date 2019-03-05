import java.io.Reader;
import java.util.List;

/**
 * @Author: WSS
 * @Date:
 * @Description: 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 *               给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 *
 *               eg:1->2->2->1
 *                 返回：true
 */
public class chkPalindrome {

static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    static class PalindromeList {
        public boolean chkPalindrome(ListNode A) {
            if(A == null){
                return false;
            }
            //链表倒序
            ListNode reverseList = new ListNode(-1);
            for (ListNode temp = A;temp != null;temp = temp.next){
                ListNode newNode = new ListNode(temp.val);
                newNode.next = reverseList.next;
                reverseList.next = newNode;
            }
            //比较
            while (A != null && reverseList.next.val == A.val ){
                reverseList.next = reverseList.next.next;
                A = A.next;
            }
            if (A == null){
                return true;
            }else {
                return false;
            }
        }
    }
    //建立普通链表
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

    //建立回文结构链表
    public static ListNode creatList(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(2);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(1);
        ln3.next = ln4;
        return ln1;
    }

    public static void main(String[] args) {

        PalindromeList palindromeList = new PalindromeList();
        //普通链表
        ListNode common =  creatList(5);
        System.out.println(palindromeList.chkPalindrome(common));//false
        //回文链表
        ListNode drome = creatList();
        System.out.println(palindromeList.chkPalindrome(drome));//true

    }
}
