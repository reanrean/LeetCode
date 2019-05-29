/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode a = l1;
        ListNode b = l2;
        ListNode thisNode = resultHead;
        int addNext = 0;
        while (a!=null || b!=null) {
            int aVal = a==null ? 0 : a.val ;
            int bVal = b==null ? 0 : b.val ;
            int rawResult = aVal + bVal + addNext;
            addNext = 0;
            int thisResult = rawResult;
            if (rawResult>9) {
                addNext++;
                thisResult = rawResult%10;
            }
            if (a!=null) {
                a = a.next;
            }
            if (b!=null) {
                b = b.next;
            }
            thisNode.next = new ListNode(thisResult);
            thisNode = thisNode.next;
        }
        if (addNext>0){
            thisNode.next = new ListNode(1);
        }
        return resultHead.next;
    }
}


/*
A same solution as provided.
Note: 
1) Beware usage of ListNode: node.next and node.val
2) Create a ListNode(0) so that we can refer it outside (return its next)
3) Beware a extra addNext(carry) which made output longer than input
4) Beware different length in l1 and l2 which will cause NullPointer

Follow-up question:
What if the the digits in the linked list are stored in non-reversed order?

1)reverse l1 and l2 using below code:

    ListNode curr = l1;
    ListNode pre = null;
    ListNode incoming = null;
    while(curr != null) {
        incoming = curr.next;   // store incoming item
        curr.next = pre;        // let curr point to items in before
        pre = curr;             // store curr as reversed list
        curr = incoming;        // next loop
    }
    l1 = pre; // pre is the reversed list where curr is null (end of original list)

2) use stack to reverse the list
*/