package aufgabenblatt03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StackOld {

	private char[] stackArray;
	private int top;

	public StackOld() {
		stackArray = new char[0];
		this.top = -1;
	}

	public void push(char c) {
		int lengthOld = stackArray.length;
		char[] oldArray = new char[lengthOld];

		System.arraycopy(stackArray, 0, oldArray, 0, stackArray.length);
		stackArray = new char[lengthOld + 1];
		System.arraycopy(oldArray, 0, stackArray, 0, oldArray.length);
		stackArray[stackArray.length - 1] = c;
		this.top = stackArray.length - 1;
	}

	public void solve(String s) {

		for (int i = 0; i < s.length(); i++) {
			// if(s[i] == '(' || ')' || '{' || '}' || '[' || ']'){
			char c = s.charAt(i);
			switch (c) {
			case '(':
				push(c);
				break;
			case '[':
				push(c);
				break;
			case '{':
				push(c);
				break;
			case ')':
				System.out.println(stackArray.length);
				System.out.println("drin");
				if(!isEmpty()){
				if (stackArray[top] == '(') {
//					if (isEmpty()) {
//						System.out.println("Fehler, Klammer(n) zuviel (hinten)");
//					} else {
						pop();
						System.out.println("popped (");
//					}
				} else {
					System.out.println("Klammer fehler ()");
				}
				}else{
					System.out.println("Fehler hinten: (");
				}
				break;
			case ']':
				
				if(!isEmpty()){
				if (stackArray[top] == '[') {
					pop();
					System.out.println("popped [");
				} else {
					System.out.println("Klammer fehler []");
				}
				}else{
					System.out.println("Fehler hinten: [");
				}
				break;
			case '}':
				if(!isEmpty()){
				if (stackArray[top] == '{') {
					pop();
					System.out.println("popped {");
				} else {
					System.out.println("Klammer fehler {}");
				}
				}else{
					System.out.println("Fehler hinten: {");
				}

				break;
			default:
				System.out.println("keine klammer überprungen");
				break;
			}
			// }
		}
		System.out.println("Fin");

	}

	public static void main(String[] args) throws IOException {
		// Stack s1 = new Stack();
		// s1.push('T');
		//
		// System.out.println(s1.stackArray[s1.top]);
		//
		// s1.push('E');
		// System.out.println(s1.stackArray[s1.top]);
		//
		// s1.push('S');
		// System.out.println(s1.stackArray[s1.top]);
		//
		// s1.push('T');
		// System.out.println(s1.stackArray[s1.top]);
		//
		// s1.pop();
		// System.out.println(s1.stackArray[s1.top]);
		//
		// s1.pop();
		// System.out.println(s1.stackArray[s1.top]);
		//
		// for (int i = 0; i < s1.stackArray.length; i++) {
		// System.out.println(s1.stackArray[i]);
		// }

		// FileReader fr = new
		// FileReader("\\AlDa\\Uebungsaufgaben\\aufgabenblatt01\\Main.java");
		FileReader fr = new FileReader("bin\\aufgabenblatt03\\test");
		BufferedReader br = new BufferedReader(fr);

		StackOld s2 = new StackOld();
		String t = br.readLine();
		System.out.println(t);
		s2.solve(t);
		// s2.solve("((((Test)))))");
	}

	public char pop() {
		char rC = stackArray[top];
		char[] tempArray = new char[stackArray.length - 1];
		System.arraycopy(stackArray, 0, tempArray, 0, stackArray.length - 1);
		stackArray = new char[tempArray.length];
		System.arraycopy(tempArray, 0, stackArray, 0, tempArray.length);
		top--;
		return rC;
	}

	public boolean isEmpty() {
		if (stackArray.length <= 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (stackArray[top] != ' ') {
			return true;
		}
		return false;
	}

	
}
