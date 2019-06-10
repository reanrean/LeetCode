/*
Note: I didn't do it in one pass. Next try.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        int length = 0;
        while(temp.next!=null){
            length +=1;
            temp = temp.next;
        }
        int toRemove = length - n + 1;
        temp = dummyHead;
        ListNode current = dummyHead;
        for (int i = 0; i<toRemove; i++){
            if (i==toRemove-1){
                current = temp;
            }
            temp = temp.next;
        }
        current.next = temp.next;
        return dummyHead.next;
    }
}