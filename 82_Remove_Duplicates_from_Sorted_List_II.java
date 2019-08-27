/*
82_Remove_Duplicates_from_Sorted_List_II
add 3 pointers: new list head, end of new list, current listnode in iteration (for dup checking)
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
        ListNode newHead = new ListNode(-1);
        ListNode newEnd = newHead;
        ListNode cur = head;
        boolean isDup = false;
        if (head == null || head.next == null) {
            return head;
        }
        else {
            cur = head;
        }
        head = head.next;
        while(head != null) {
            if (head.val == cur.val) { //compare with previous node
                isDup = true; //means value in cur is duplicated
            }
            else {
                if (!isDup) { //value in cur is unique
                newEnd.next = cur;
                newEnd = newEnd.next;
                }
                //overcome the duplicated values
                //set cur to new value
                cur = head;
                isDup = false;
            }
            head = head.next;
        }
        //handle last element if unique
        if (!isDup) {
            newEnd.next = cur;
            newEnd = newEnd.next;
        }
        newEnd.next = null;
        return newHead.next;
    }
}