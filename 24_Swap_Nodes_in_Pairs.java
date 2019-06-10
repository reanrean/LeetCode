/*
Note: to be extremely careful when doing such things! I am not familiar with such operations.
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
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode next = head;
        ListNode cur = dummyHead;
        ListNode incoming = head;
        int count = 0;
        while (head!=null){
            count++;
            next = head.next;
            if (count%2>0){//1st node, need to swap to second
                incoming = head;
            }else{
                cur.next = head;
                head.next = incoming;
                incoming.next = next;
                cur = cur.next;
                cur = cur.next;
            }
            head = next;
        }
        return dummyHead.next;
    }
}