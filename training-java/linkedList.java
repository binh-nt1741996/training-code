import java.util.Scanner;

class linkedList{
	Node head;

	static class Node {
		int data;
		Node next;

		Node (int d){
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

	public void addFront(int d){
		Node currHead = new Node(d);
		currHead.next = head;
		head = currHead;
	}

	public void addEnd(int d){
		Node tail = new Node(d);
		Node temp = head;
		
		if (head == null){
			head = new Node(d);
			return;
		}
		while (temp != null){
			if (temp.next == null){
				temp.next = tail;
				return;
			}
			temp = temp.next;
		}
	}

	public void addAfterNode(Node prevNode, int d){
		if (prevNode == null){
			System.out.println("The previous node cannot be null");
			return;
		}
		Node newNode = new Node(d);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	public void addAfterValue(int prev_index, int d){
		Node temp = head;
		Node newNode = new Node(d);
		if (head == null){
			head = new Node(d);
			return;
		}
		int count = 0;
		while (temp != null){
			if (count == prev_index){
				newNode.next = temp.next;
				temp.next = newNode;
			}
			temp = temp.next;
			count += 1;
		}
	}
	public static void main(String[] args) {
		linkedList List = new linkedList();
		List.head = new Node(17);
		Node second = new Node(4);
		Node third = new Node(19);
		Node fourth = new Node(96);

		List.head.next = second;
		second.next = third;
		third.next = fourth;

		List.printList();
		
		System.out.println("Start inserting at the front");
		List.addFront(28);
		List.printList();

		System.out.println("Start inserting at the end");
		List.addEnd(99);
		List.printList();

		System.out.println("Start inserting at the given node");
		List.addAfterNode(third, 5);
		List.printList();

		Scanner obj = new Scanner(System.in);
		System.out.print("Enter a new value at given index: ");
		int[] arr = new int[2];
		for (int i = 0; i < 2; i++){
			arr[i] = obj.nextInt();
		}
		System.out.println("Start inserting at the given index");
		List.addAfterValue(arr[0], arr[1]);
		List.printList();
	}
}
