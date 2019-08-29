/*86_Partition_List
  Create pointer: leftHead, leftTail, rightHead, rightTail
  Everytime encounter a new element, decide it is in the left or in the right
  Concat the left and right half at last
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
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode leftTail = leftHead;
        ListNode rightHead = new ListNode(-1);
        ListNode rightTail = rightHead;
        
        if (head == null || head.next == null) {
            return head;
        }
        
        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            }
            else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = rightHead.next;
        rightTail.next = null;
        return leftHead.next;
    }
}