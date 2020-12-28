import java.util.*;
/**
 * InnerTest
 */

 class Node{
	 int value;
	 Node left, right;
	 Node(int value){
		 this.value = value;
		 left = right = null;
	 }
 }

public class Test {
	Node root;

	Test(){
		root = null;
	}

	Test(int value){
		root = new Node(value);
	}

	void inOrder(Node root){
		if (root == null){
			return;
		}
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}

	void insert(Node root, int value){
		if (root == null){
			root = new Node(value);
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp = null;
		while(!q.isEmpty()){
			temp = q.peek();
			q.remove();
			if (temp.left == null){
				temp.left = new Node(value);
				break;
			} else{
				q.add(temp.left);
			}
			if (temp.right == null){
				temp.right = new Node(value);
				break;
			} else{
				q.add(temp.right);
			}
		}
	}

	void deleteDeepestNode(Node root, Node delNode){
		if (root == null){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp = null;
		while(!q.isEmpty()){
			temp = q.peek();
			q.remove();
			if (temp == delNode){
				temp = null;
				return;
			}
			if (temp.left != null){
				if (temp.left == delNode){
					temp.left = null;
					return;
				} else{
					q.add(temp.left);
				}
			}
			if (temp.right != null){
				if (temp.right == delNode){
					temp.right = null;
					return;
				} else{
					q.add(temp.right);
				}
			}
		}
	}

	void delete(Node root, int key){
		if (root == null){
			return;
		}
		if (root.left == null && root.right == null){
			if (root.value == key){
				return;
			} else{
				return;
			}
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp = null, keyNode = null;
		while(!q.isEmpty()){
			temp = q.peek();
			q.remove();
			if (temp.value == key){
				keyNode = temp;
			}
			if (temp.left != null){
				q.add(temp.left);
			}
			if (temp.right != null){
				q.add(temp.right);
			}
		}
		if (keyNode != null){
			int x = temp.value;
			deleteDeepestNode(root, temp);
			keyNode.value = x;
		}
	}
	public static void main(String[] args) {
		Test t = new Test(1);
		t.root.left = new Node(7);
		t.root.right = new Node(4);
		t.root.left.left = new Node(9);
		t.root.left.right = new Node(6);
		t.root.right.right = new Node(8);

		System.out.println("Before inserting");
		t.inOrder(t.root);
		
		System.out.println("Inserting 2");
		t.insert(t.root, 2);

		System.out.println("After inserting");
		t.inOrder(t.root);

		System.out.println("Deleting 7");
		t.delete(t.root, 7);

		System.out.println("Aftering deleting 7");
		t.inOrder(t.root);
	}
}