/** Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
*/
public class ReverseLinkedList {
    /** Definition for singly-linked list. */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode remainReversed = reverseList(head.next);
        ListNode second = head.next;
        head.next = null;
        second.next = head;
        return remainReversed;
    }
    public ListNode reverseListIter(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        while (head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }
}
