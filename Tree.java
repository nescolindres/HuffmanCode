package cs282sol;

public class Tree {
	static Node node;
	static Node newRoot;
	static String codedString = "";
	
	public static void Treemaker(Node root, Node end) {
		node = new Node(end.previous.value + end.value, end.previous.count + end.count);
		node.leftChild = end.previous;
		node.rightChild = end;
		end.previous.previous.next = node;
		node.previous = end.previous.previous;
		end = node;
		end.next = null;
		Node current = root;
		
		while (current.next != null) {
			System.out.print(current.value + "-->");
			current = current.next;
		}
		System.out.println(current.value);
		if (root.next == end) {
			node = new Node(root.value + end.value, root.count + end.count);
			node.leftChild = root;
			node.rightChild = end;
			node.next = null;
			node.previous = null;
			System.out.println(node.value);
			newRoot = node;
		}
		else {
			Treemaker(root,end);
		}
	}
	
	public static void inOrder(Node root) {
		if(root != null) {
			inOrder(root.leftChild);
			System.out.print(root.value + "-->");
			inOrder(root.rightChild);
		}
	}
	
	public static void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.value + "-->");
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}
	
}
