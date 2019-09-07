/*
pointers: dummyhead (for return), startOfRev(m-1), endOfRev(mth node -> will become nth node), tempRev(record node in reversion)
when counter encounters m, put the node as endOfRev, and make the next node encountered point to it.
when counter encounters n, make startOfRev point to it, and make endOfRev point to the n+1th node.
Note: it's better to write each step on paper/notepad.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        ListNode startOfRev = dummyHead;
        ListNode endOfRev = dummyHead;
        ListNode tempRev = dummyHead;
        ListNode next;
        int counter = 0;
        if (head == null || head.next == null || m == n) {
            return head;
        }
        dummyHead.next = head;
        while (head != null) {
            counter++;
            next = head.next;
            if (counter > n) {
                break;
            } else if (counter == m) {
                endOfRev = head;
                tempRev = head;
            } else if (counter > m && counter < n) {
                head.next = tempRev;
                tempRev = head;
            } else if (counter == n) {
                head.next = tempRev;
                startOfRev.next = head;
                endOfRev.next = next;
            } else {
                startOfRev = head;
            }
            head = next;
        }
        return dummyHead.next;
    }
}