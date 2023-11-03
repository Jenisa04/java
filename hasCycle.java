import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        /* Method 1: 2 pointers */
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false; 
            }

            slow = slow.next; 
            fast = fast.next.next; 
        }
        
        return true; 
        

        /* Method 2: HashSet

        Set<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }

            visited.add(head);
            head = head.next;
        }

        return false;
        */
    }

    public static void main(String[] args) {
        // Initialize the solution object
        Solution solution = new Solution();

        // Test Case 1: linked list with cycle
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head1.next = node2;
        node2.next = node3;
        node3.next = head1; //cycle present

        boolean result1 = solution.hasCycle(head1);
        System.out.println("Test Case 1 Result: " + result1);

        // Test Case 2: linked list without a cycle
        ListNode head2 = new ListNode(23);
        ListNode node4 = new ListNode(24);
        ListNode node5 = new ListNode(25);
        head2.next = node4;
        node4.next = node5;

        boolean result2 = solution.hasCycle(head2);
        System.out.println("Test Case 2 Result: " + result2);

        // Test Case 3: empty list
        ListNode head3 = null;
        boolean result3 = solution.hasCycle(head3);
        System.out.println("Test Case 3 Result: " + result3);
        
        // Test Case 4: linked ist with single node
        ListNode head4 = new ListNode(1);
        boolean result4 = solution.hasCycle(head4);
        System.out.println("Test Case 4 Result: " + result4);

        // Test Case 5: linked list with cycle loop
        ListNode head5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        head5.next = node6;
        node6.next = head5; //cycle present

        boolean result5 = solution.hasCycle(head5);
        System.out.println("Test Case 5 Result: " + result5);

        // Test Case 6: large linked list
        ListNode head6 = new ListNode(11);
        ListNode node7 = new ListNode(12);
        ListNode node8 = new ListNode(13);
        ListNode node9 = new ListNode(14);
        ListNode node10 = new ListNode(15);
        ListNode node11 = new ListNode(13);
        ListNode node12 = new ListNode(17);
        ListNode node13 = new ListNode(12);
        ListNode node14 = new ListNode(19);
        ListNode node15 = new ListNode(20);
        head6.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;
        //cycle present in middle
        // node15.next = node11;
        //cycle present in end
        // node15.next = head6;
        //no cycle present
        node15.next = null; 

        boolean result6 = solution.hasCycle(head6);
        System.out.println("Test Case 6 Result: " + result6);
    }
}
