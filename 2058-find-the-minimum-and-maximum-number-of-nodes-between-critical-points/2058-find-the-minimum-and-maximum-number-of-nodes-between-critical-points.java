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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prev = -1;
        int min = Integer.MAX_VALUE;
        int last = -1;

        ListNode prevNode = head;
        ListNode curr = head.next;

        int pos = 2;

        while (curr.next != null) {
            ListNode next = curr.next;

            if ((curr.val > prevNode.val && curr.val > next.val) ||
                (curr.val < prevNode.val && curr.val < next.val)) {

                if (first == -1) {
                    first = pos;
                } else {
                    min = Math.min(min, pos - prev);
                }

                prev = pos;
                last = pos;
            }

            prevNode = curr;
            curr = next;
            pos++;
        }

        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        return new int[]{min, last - first};
    }
}