import java.util.Scanner;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MultiplyLinkedList {

    public static LinkedListNode<Integer> takeInput(Scanner s) {
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;

        int data = s.nextInt();

        while(data != -1) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);

            if(head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        LinkedListNode<Integer> head1 = takeInput(s);
        LinkedListNode<Integer> head2 = takeInput(s);


        MultiplyLinkedListSolution.multiply(head1, head2);

        s.close();
    }

}

class MultiplyLinkedListSolution {

    public static LinkedListNode reverseList(LinkedListNode node) {
        if (node == null || node.next == null)
            return node;

        LinkedListNode prev = null;
        LinkedListNode curr = node;
        while (curr != null) {
            LinkedListNode forw = curr.next; // backup.

            curr.next = prev; // connection

            prev = curr; // move forw.
            curr = forw;
        }

        return prev;
    }
    public static void addTwoLinkedList(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode prev = l1;
        int carry = 0;
        while (l2 != null || carry != 0) {
            int sum = carry + (int)(prev.next != null ? prev.next.data : 0) + (int)(l2 != null ? l2.data : 0);

            carry = sum / 10;
            sum = sum % 10;

            if (prev.next != null)
                prev.next.data = sum;
            else
                prev.next = new LinkedListNode(sum);

            if (l2 != null)
                l2 = l2.next;
            prev = prev.next;
        }
    }

    public static LinkedListNode multiplyLinkedListWithDigit(LinkedListNode l1, int digit) {
        LinkedListNode head = new LinkedListNode(-1); // dummy.
        LinkedListNode curr = head;

        int carry = 0;
        while (l1 != null || carry != 0) {
            int sum = carry + (int)(l1 != null ? ((int)l1.data * digit) : 0);

            carry = sum / 10;
            sum = sum % 10;

            curr.next = new LinkedListNode(sum);

            if (l1 != null)
                l1 = l1.next;
            curr = curr.next;
        }

        return head.next;
    }
    public static LinkedListNode multiplyTwoLL(LinkedListNode l1, LinkedListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        LinkedListNode ans = new LinkedListNode(-1); // dummy.
        LinkedListNode ans_itr = ans;
        LinkedListNode l2_itr = l2;

        while (l2_itr != null) {
            LinkedListNode head = multiplyLinkedListWithDigit(l1, (Integer) l2_itr.data);
            l2_itr = l2_itr.next;
            addTwoLinkedList(ans_itr,head);
            ans_itr = ans_itr.next;
        }

        ans = ans.next;
        return reverseList(ans);
    }

    public static void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void multiply(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here
        LinkedListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}