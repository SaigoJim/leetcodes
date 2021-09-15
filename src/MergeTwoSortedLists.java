public class MergeTwoSortedLists {

     /** Definition for singly-linked list. */
     private class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if (l1 == null) {
             return l2;
         } else if (l2 == null) {
             return l1;
         }
         ListNode merged = new ListNode();
         if (l1.val < l2.val) {
             merged = l1;
             l1 = l1.next;
         } else {
             merged = l2;
             l2 = l2.next;
         }
         merged.next = mergeTwoLists(l1, l2);
         return merged;
    }
}
