import java.io.*;
import java.util.*;

/**
 * problem
 */
class linkedList{
    Node head;

    class Node{
        int value;
        Node next;
        Node(int d){
            value = d;
            next = null;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = new Node(data);
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void append(int data){
        Node temp = head;
        if (head == null){
            head = new Node(data);
            return;
        }
        while (temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
    }
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
public class problem {
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.push(17);
        ll.push(4);
        ll.append(1996);
        ll.display();
    }
}