import java.util.Scanner;


class linkedList{
    /**
     * Node
     */
    Node head;
    public class Node {     
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }        
    }

    public void push(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void append(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void deleteByIndex(int index){
        Node temp = head;
        int count = 0;
        if (index == 0){
            head = head.next;
        } else{
            while (temp != null){
                if (count == index - 1){
                    temp.next = temp.next.next;
                    break;
                }
                count++;
                temp = temp.next;
            }
        }
        if (count > index){
            System.out.println("The inserted index is larger than the length of list!");
        }
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
public class linkedlist {
    public static void main(String[] args) {
        linkedList list = new linkedList();
        list.push(17);
        list.push(4);
        list.push(96);
        list.append(28);
        list.deleteByIndex(2);
        list.printList();
    }
}
