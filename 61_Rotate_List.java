/*
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
The operation is simply set 3rd node.next to null, and set 5th node.next to head
Therefore get the length of list first and calculate from the left (5-2=3)
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        int length = 0;
        ListNode lenCount = head;
        while (lenCount != null){
            lenCount = lenCount.next;
            length++;
        }
        k = k % length;
        if (k == 0){
            return head;
        }
        int left = length - k; //count from left
        ListNode next = head;
        ListNode incoming = head;
        for (int i = 1; i <= length; i++){
            if (i == left){
                incoming = next.next;
                next.next = null;
                next = incoming;
            }else if (i == length){
                next.next = head;
            }else{
                next = next.next;
            }
        }
        return incoming;
    }
}