//Question : https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder str=new StringBuilder();
        ListNode tem=head;
        while(tem!=null){
             str.append(tem.val);
             tem=tem.next;
        }
        String s=str.toString();
        int n=Integer.parseInt(s,2);
        return n;
    }
}
