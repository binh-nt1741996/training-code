import java.util.*;
import java.util.HashSet;

/**
 * removeDups
 */
public class removeDups {
    Node head;
    static class Node{
        Node next;
        int data;
        public Node(int d){
            this.data = d;
            this.next = null;
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
        //System.out.println(tail.data);
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = tail;
        }

    public void removeDup(){
        HashSet<Integer> set = new HashSet<Integer>();
        Node temp = head;
        Node prev = head;
        while (temp != null){
            if (set.contains(temp.data)){
                prev.next = temp.next;
                temp = temp.next;
            }
            else{
                set.add(temp.data);
                prev = temp;
                temp = temp.next;
            }
        }
    }

    public void returnKthtoLast(int k){
        Node temp = head;
        int counter = 0;
        while (temp != null){
            counter++;
            if (counter >= k){
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    public void returnKthtoLast(Node temp, int n, int k, int i){
        if ((n - k) <= i){
            System.out.println(temp.data);
        } 
        else{
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        removeDups ll = new removeDups();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a linked list: ");
        String[] strArr = in.nextLine().split(" ", -1);
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++){
           arr[i] = Integer.parseInt(strArr[i]);
        }
        ll.head = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++){
           ll.push(arr[i]);
        }
        ll.printList();
        System.out.println("Return kth to last elements");
        ll.returnKthtoLast(4);
    }
}