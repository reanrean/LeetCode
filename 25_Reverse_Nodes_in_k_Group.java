/*
Need to revise and write it in one pass next time.

At first I attempted to write in one pass(no recursion), but alert Memory Exceeded. Why?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null){
            return head;
        }
        
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        ListNode incoming = head;
        ListNode pre = null;
        
        int count = 0;
        while (incoming!=null){
            count++;
            incoming = incoming.next;
        }
        
        incoming = head;
        if (count<k){
            return head;
        }else{
            int i = 0;
            while (head!=null && i<k){
                i++;
                incoming = head.next;
                head.next = pre;
                pre = head;
                head = incoming;
            }
            cur.next = pre;
            for (int j=0; j<k; j++){
                cur = cur.next;
            }
            if (head!=null){
                cur.next = reverseKGroup(incoming, k);
            }
        }
        return dummyHead.next;
    }
}