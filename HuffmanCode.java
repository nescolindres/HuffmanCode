package cs282sol;

public class HuffmanCode {

static Node node;
static Node newRoot;
static String codedString = "";

public static MyList<Character> frequency (String message) {
	char[] msgChar = message.toCharArray();
	MyList<Character> characters = new MyList<Character>();
	
	// getting the frequencys of the chars
	
	for (int i = 0; i < msgChar.length; i ++) {
		if(!(characters.contains(msgChar[i]))) {
			characters.add(msgChar[i]);
		}
	}
	return characters;
}
	

}
