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
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int ADD) {
        if (l1 == null && l2 == null) {
            if (ADD != 0) {
                return new ListNode(ADD, null);
            }
            return null;
        }
        int val1 = 0;
        int val2 = 0;
        ListNode nextL1 = null;
        ListNode nextL2 = null;
        if (l1 != null) {
            val1 = l1.val;
            nextL1 = l1.next;
        }
        if (l2 != null) {
            val2 = l2.val;
            nextL2 = l2.next;
        }
        int sum = val1 + val2 + ADD;
        int num = sum % 10;
        ADD = sum / 10;
        ListNode sumListNode = new ListNode(num, addTwoNumbers(nextL1, nextL2, ADD));
        return sumListNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7, null)));

        ListNode l3 = new Solution().addTwoNumbers(l1, l2);
    }
}