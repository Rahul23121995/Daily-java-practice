package day10;
public class Hard_ReverseNodesKGroup {
    public static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head; int count = 0;
        while (curr != null && count != k) { curr = curr.next; count++; }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next; head.next = curr; curr = head; head = tmp;
            }
            head = curr;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode res = reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), 2);
        assert res != null && res.val == 2;
        System.out.println("Reverse Nodes K-Group passed!");
    }
}