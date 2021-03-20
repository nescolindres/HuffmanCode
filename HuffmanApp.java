package cs282sol;

public class HuffmanApp extends Tree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		String message = "CONTINUE";

		// Convert the string to char array

		char[] msgChar = message.toCharArray();

		MyList<Character> characters = new MyList<Character>();

		/*
		 * Get a List of all the chars which are present in the string No
		 * repeating the characters!
		 */
		for (int i = 0; i < msgChar.length; i++) {
			if (!(characters.contains(msgChar[i]))) {
				characters.add(msgChar[i]);
			}
		}

		/* Print out the available characters */
		// System.out.println(characters);

		/* Count the number of occurrences of Characters */
		int[] countOfChar = new int[characters.size()];

		/* Fill The Array Of Counts with one as base value */
		for (int x = 0; x < countOfChar.length; x++) {
			countOfChar[x] = 0;
		}

		/* Do Actual Counting! */
		for (int i = 0; i < characters.size(); i++) {
			char checker = characters.get(i);
			for (int x = 0; x < msgChar.length; x++) {
				if (checker == msgChar[x]) {
					countOfChar[i]++;
				}
			}
		}

		/* Sort the arrays is descending order */
		for (int i = 0; i < countOfChar.length - 1; i++) {
			for (int j = 0; j < countOfChar.length - 1; j++) {
				if (countOfChar[j] < countOfChar[j + 1]) {
					int temp = countOfChar[j];
					countOfChar[j] = countOfChar[j + 1];
					countOfChar[j + 1] = temp;

					char tempChar = characters.get(j);
					characters.set(j, characters.get(j + 1));
					characters.set(j + 1, tempChar);
				}
			}
		}

		/* Print Out The Frequencies of the Characters */
		for (int x = 0; x < countOfChar.length; x++) {
			System.out.println(characters.get(x) + " - " + countOfChar[x]);
		}

		/* Form the Tree! */

		/* Form Leaf Nodes and Arrange them in a linked list */

		Node root = null;
		Node current = null;
		Node end = null;

		for (int i = 0; i < countOfChar.length; i++) {
			Node node = new Node(characters.get(i).toString(), countOfChar[i]);
			if (root == null) {
				root = node;
				end = node;
			} else {
				current = root;
				while (current.next != null) {
					current = current.next;
				}
				current.next = node;
				current.next.previous = current;
				end = node;
			}
		}

		// Recursively add and make nodes!
		tree.Treemaker(root, end);

		// inOrder(root);
		System.out.println();
		tree.inOrder(node);

		// preOrder(root);
		System.out.println();
		preOrder(node);

		// Calculate the ends and the meets! createtable 
		char[] messageArray = message.toCharArray();
		char checker;

		for (int i = 0; i < messageArray.length; i++) {
			current = node;
			checker = messageArray[i];
			String code = "";
			while (true) {
				if (current.leftChild.value.toCharArray()[0] == checker) {
					code += "0";
					break;
				} else {
					code += "1";
					if (current.rightChild != null) {
						if (current.rightChild.value.toCharArray()[0] == characters
								.get(countOfChar.length - 1)) {
							break;
						}
						current = current.rightChild;
					} else {
						break;
					}
				}
			}
			codedString += code;
		}
		System.out.println();
		System.out.println("The coded string is " + codedString);
	}
}