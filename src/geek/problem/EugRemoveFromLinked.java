package geek.problem;

public class EugRemoveFromLinked {
    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        list.head = new Node1(1);
        list.head.next = new Node1(2);
        list.head.next.next = new Node1(3);

        list.remove(3);
        System.out.println(list);
        System.out.println(list.tail);
    }
}

class Node1 {
    Node1 prev;
    Node1 next;

    public Node1(Integer value) {
        this.value = value;
    }

    Integer value;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node1 curr = this;
        while (curr != null) {
            stringBuilder.append(curr.value.toString());
            curr = curr.next;
        }
        return stringBuilder.toString();
    }
}

class LinkedList1 {
    Node1 head;
    Node1 tail;

    void remove(Integer value) {
        if (head.value.equals(value)) {
            head = head.next;
            head.prev = null;
            return;
        }

        Node1 current = head.next;
        Node1 prev = head;
        while (current != null) {
            if (current.value.equals(value)) {
                prev.next = current.next;
                if (current.next != null)
                    current.next.prev = prev;
                if (current.next == null)
                    tail = prev;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    @Override
    public String toString() {
        String sdf = "sdf";
        sdf.charAt(1);
        return this.head.toString();
    }
}