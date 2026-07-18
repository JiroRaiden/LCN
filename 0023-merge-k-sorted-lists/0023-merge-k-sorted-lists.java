/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length==0)
        return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a,b)->Integer.compare(a.val,b.val));

        for(ListNode head : lists)
        {
            if(head!=null)
            pq.offer(head);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!(pq.isEmpty()))
        {
            ListNode smallest = pq.poll();

            tail.next = smallest;
            tail = tail.next;

            if(smallest.next!=null)
            pq.offer(smallest.next);
        }

        return dummy.next;
    }
}