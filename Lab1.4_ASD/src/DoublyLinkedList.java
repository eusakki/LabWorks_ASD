public class DoublyLinkedList {
    class Node {
        Student data;
        Node prev;
        Node next;

        Node(Student data) {
            this.data = data;
        }
    }

    Node head;

    public void add(Student s) {
        Node newNode = new Node(s);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    //LVL 2 - Insertion Sort for list
    public void insertionSort() {
        if (head == null)
            return;

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            sorted = insertSorted(sorted, current);
            current = next;
        }

        head = sorted;
    }

    private Node insertSorted(Node sorted, Node newNode) {
        if (sorted == null || newNode.data.ratio() < sorted.data.ratio()) {
            newNode.next = sorted;

            if (sorted != null)
                sorted.prev = newNode;

            newNode.prev = null;

            return newNode;
        }

        Node temp = sorted;

        while (temp.next != null &&
        temp.next.data.ratio() < newNode.data.ratio()) {
            temp = temp.next;
        }

        newNode.next = temp.next;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;

        newNode.prev = temp;

        return sorted;
    }
}
