package day10;
public class Easy_ReverseLinkedList {
    public static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; curr.next = prev; prev = curr; curr = nextTemp;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode rev = reverseList(new ListNode(1, new ListNode(2, new ListNode(3))));
        assert rev != null && rev.val == 3;
        System.out.println("Reverse Linked List passed!");
    }
}