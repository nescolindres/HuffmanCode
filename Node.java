package cs282sol;

public class Node {
String value;
int count;
Node leftChild;
Node rightChild;
Node next;
Node previous;

Node(String value, int count) {
	this.value = value;
	this.count = count; 
	this.leftChild = null;
	this.rightChild = null;
	this.next = null;
	this.previous = null;
}

}
