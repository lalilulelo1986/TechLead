package geek.problem.diameterbinarytree;

class ListNode {
    ListNode next;

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }

    int val;

    @Override
    public String toString() {
        return "ListNode{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}

public class ReverseLinks {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(
                new ListNode(
                        new ListNode(null, 3),
                        2
                ),
                1
        );
        System.out.println(listNode);
        System.out.println(reverse(listNode));
    }

    public static ListNode reverse(ListNode listNode) {
        if (listNode.next == null)
            return listNode;

        ListNode reverse = reverse(listNode.next);
        reverse.next = listNode;

        if (listNode.val == 1)
            listNode.next = null;
        return reverse;
    }
}
