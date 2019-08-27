/*
83_Remove_Duplicates_from_Sorted_List
create 2 pointers: new head for return, new end for record
push to new list everytime when encounter an element with value differernt from previous
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = head;
        ListNode newEnd = newHead;
        if (head == null || head.next == null) {
            return head;
        }
        
        while (head != null) {
            if (head.val != newEnd.val) {
                newEnd.next = head;
                newEnd = newEnd.next;
            }
            head = head.next;
        }
        newEnd.next = null;
        
        return newHead;
    }
}