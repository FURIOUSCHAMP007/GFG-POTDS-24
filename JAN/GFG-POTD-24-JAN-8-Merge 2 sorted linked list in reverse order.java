class GfG {
    Node mergeResult(Node node1, Node node2) {
        // Merge two sorted lists
        Node merged = mergeLists(node1, node2);
        
        // Reverse the merged list
        Node reversed = reverseList(merged);
        
        return reversed;
    }

    // Helper function to merge two sorted lists
    private Node mergeLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.data < l2.data) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }

    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

