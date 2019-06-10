/*
A solution of comparing the next smallest everytime.
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
    public ListNode mergeKLists(ListNode[] lists) {
        int nList = lists.length;
        boolean[] nonNull = new boolean[nList];
        int nulls = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int i=0; i<nList; i++){
            if (lists[i]==null){
                nonNull[i] = false;
                nulls++;
            }else{
                nonNull[i] = true;
            }
        }
        while (nulls<nList){
            Integer minValI = null;
            int minVal = 0;
            for (int i=0; i<nList; i++){
                if (!nonNull[i]){
                    continue;
                }else if (lists[i]==null){
                    nonNull[i] = false;
                    nulls++;
                }else if (minValI==null || lists[i].val<minVal){
                    minValI = i;
                    minVal = lists[i].val;
                }
            }
            if (nulls==nList){
                break;
            }
            cur.next = lists[minValI];
            cur = cur.next;
            lists[minValI] = lists[minValI].next;
        }
        return dummyHead.next;
    }
}

/*
Priority Queue approach:
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode l : lists){
            while (l!=null){
                queue.add(l.val);
                l = l.next;
            }
        }
        while (queue.size()>0){
            int next = queue.poll();
            cur.next = new ListNode(next);
            cur = cur.next;
        }
        return dummyHead.next;
    }
}

/*
Combine by pairs, much faster.
https://leetcode.wang/leetCode-23-Merge-k-Sorted-Lists.html
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
    public ListNode mergeKLists(ListNode[] lists) {
        int nList = lists.length;
        if (nList<1){
            return null;
        }else{
            int newLen = nList;
            boolean isOdd = false;
            while(newLen>1){
                if (newLen%2>0){
                    isOdd = true;
                }else{
                    isOdd = false;
                }
                newLen = newLen/2 + newLen%2;
                for (int i=0; i<newLen; i++){
                    if (!(i==newLen-1 && isOdd)){
                        lists[i] = mergeTwo(lists[i], lists[i+newLen]);
                    }
                }
            }
            return lists[0];
        }
    }
    
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while(l1!=null || l2!=null){
            if (l1==null){
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }else if (l2==null){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else if (l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}