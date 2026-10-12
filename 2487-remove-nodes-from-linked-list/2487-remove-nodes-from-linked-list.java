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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        int max = curr.val;
        while (curr.next != null) 
        {
            if (curr.next.val < max)
            {
                curr.next = curr.next.next;
            } else
            {
                curr = curr.next;
                max = curr.val;
            }
        }
        head = reverse(head);
        return head;
    }
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null)
         {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;   
    }
}