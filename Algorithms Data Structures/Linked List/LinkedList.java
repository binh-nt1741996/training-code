import java.util.Scanner;

class list{
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    void push(int d){
        Node newNode = new Node(d);
        if (head == null){
            head = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
    }

    void pushToTail(int d){
        Node newNode = new Node(d);
        Node temp = head;
        if (head == null){
            head = newNode;
        } else{
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void printList(){
        Node temp = head;
        if (head == null){
            System.out.println("List is empty");
        } else{
            while (temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    void deleteNode(int d){
        Node temp = head;
        if (head == null){
            System.out.println("List is empty");
        } else{
            while (temp != null){
                if (temp.next.data == d){
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        
    }    
}
