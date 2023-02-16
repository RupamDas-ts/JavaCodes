import java.util.Scanner;

class Nodee<T> {
    public T data;
    public Nodee<T> next;
    public Nodee(T data) {
        this.data=data;
    }
}

public class MoveToLast {

    static Scanner s=new Scanner(System.in);

    public static Nodee<Integer> createlist() {
        Nodee<Integer> head = null;
        Nodee<Integer> rear = null;
        int data = s.nextInt();
        while(data != -1) {
            Nodee<Integer> newnode = new Nodee<Integer>(data);
            if(head == null) {
                head = newnode;
                rear = head;
            }
            else {
                rear.next = newnode;
                rear = rear.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void print(Nodee<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Nodee<Integer> head1 = createlist();
        int n = s.nextInt();
        print(MoveToLastSolution.func(head1,n));
    }

}

class MoveToLastSolution {
    public static Nodee<Integer> func(Nodee<Integer> head,int n) {
//        int count = 0;
//        while(head.data == n){
//            head = head.next;
//            count++;
//        }
//        Nodee<Integer> temp = head;
//        while(temp != null){
//
//        }
        Nodee<Integer> newHead = null, newTail = null, temp = head;
        int count = 0;
        while (temp != null){
            if(temp.data != n){
                Nodee<Integer> newNode = new Nodee<>(temp.data);
                if(newHead == null){
                    newHead = newNode;
                }else {
                    newTail.next = newNode;
                }
                newTail = newNode;
            }
            else{
                count++;
            }
            temp = temp.next;
        }
        while(count > 0){
            Nodee<Integer> newNode = new Nodee<>(n);
            if(head == null){
                head = newNode;
            }else{
                newTail.next = newNode;
            }
            newTail = newNode;
            count--;
        }
        return newHead;
    }

}


