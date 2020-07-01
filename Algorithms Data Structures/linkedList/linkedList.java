/**
 * linkedList
 */
import java.util.*;

public class linkedList {
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void push(int d){
        Node tail = new Node(d);
        Node temp = this.head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = tail;
    }
    //Only access to specific Node, not Node head
    public boolean deleteMiddleNode(Node n){
        if (n == null | n.next == null){
            return false;
        }
        else{
            Node nextNode = n.next;
            n.data = nextNode.data;
            n.next = nextNode.next;
            return true;
        }
    }

    public void partition(int x){
        Node temp = head;
        Node before_head = null;
        Node before_tail = null;
        Node after_head = null;
        Node after_tail = null;
        while (temp != null){
            Node next = temp.next;
            temp.next = null;
            if (temp.data < x){
                if (before_head == null){
                    before_head = temp;
                    before_tail = temp;
                }
                else{
                    before_tail.next = temp;
                    before_tail = temp;
                }
            }
            else {
                if (after_head == null){
                    after_head = temp;
                    after_tail = temp;
                }
                else{
                    after_tail.next = temp;
                    after_tail = temp;
                }
            }
            temp = next;
        }
        before_tail.next = after_head;
    }

    public Node sumList(Node n1, Node n2){
        int c = 0;
        Node ll3_head = null;
        Node ll3_tail = null;
        Node n3 = null;
        while (n1 != null & n2 != null){
            int sum = (n1.data + n2.data)%10 + c;
            c = (int)(n1.data + n2.data)/10;
            n3 = new Node(sum);
            if (ll3_head == null){
                ll3_head = n3;
                ll3_tail = n3;
            }
            else{
                ll3_tail.next = n3;
                ll3_tail = n3;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return ll3_head;
    }

    public Node sumListAdvance(Node n1, Node n2){
        int c = 0;
        Node ll3_head = null;
        Node ll3_tail = null;
        Node n3 = null;
        while (n1 != null & n2 != null){
            if (n1.next == null & n2.next == null){
                sum = n1.data + n2.data + c;
            }
            int sum = (n1.data + n2.data)%10 + c;
            c = (int)(n1.data + n2.data)/10;
            n3 = new Node(sum);
            if (ll3_head == null){
                ll3_head = n3;
                ll3_tail = n3;
            }
            else{
                ll3_tail.next = n3;
                ll3_tail = n3;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return ll3_head;
    }

    public void getLinkedList(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an array of integer: ");
        //Getting input from an array of integer and convert to Linked List
        String[] strArr = in.nextLine().split(" ", -1);
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        this.head = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++){
            this.push(arr[i]);
        }
    }
    public static void main(String[] args) {

        //Convert array to linked list
        linkedList ll1 = new linkedList();
        ll1.getLinkedList();
        linkedList ll2 = new linkedList();
        ll2.getLinkedList();
        linkedList ll3 = new linkedList();
        
        //start to accumulate list 1 and list 2
        ll3.head = ll3.sumList(ll1.head, ll2.head);
        System.out.println("After summing list 1 and list 2");
        ll3.printList();

        //This is for deleting Middle Node exercise
        /*
        Node second = new Node(44);
        Node third = new Node(19);
        Node fourth = new Node(6);
        Node fifth = new Node(84);
        ll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        */
        
        //DELETING MIDDLE NODE
        /*System.out.println("Before deleting Middle Node");
        ll.printList();
        System.out.println("After deleting random Middle Node, in this case, delete third node");
        ll.deleteMiddleNode(third);
        ll.printList();*/
        //PARTITIONING
        /*
        ll.partition(19);
        ll2.partition(30);
        System.out.println("After partitioning with 19");
        ll.printList();
        System.out.println("-------------------");
        ll2.printList();
        */
    }
}