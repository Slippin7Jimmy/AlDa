package aufgabenblatt03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;

public class Stack {

	private char[] stackArray;
	private final int MAX = 20;
	private int top;

	public Stack() {
		stackArray = new char[MAX];
		this.top = -1;
	}

	public void push(char c) {
		if (top < MAX - 1) {
			top++;
			stackArray[top] = c;
		}
	}

	public char pop() {
		char temp = stackArray[top];
		top--;
		return temp;
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
				if (!isEmpty()) {
					if (stackArray[top] == '(') {
						// if (isEmpty()) {
						// System.out.println("Fehler, Klammer(n) zuviel
						// (hinten)");
						// } else {
						pop();
						System.out.println("popped (");
						// }
					} else {
						System.out.println("Klammer fehler ()");
					}
				} else {
					System.out.println("Fehler hinten: (");
				}
				break;
			case ']':

				if (!isEmpty()) {
					if (stackArray[top] == '[') {
						pop();
						System.out.println("popped [");
					} else {
						System.out.println("Klammer fehler []");
					}
				} else {
					System.out.println("Fehler hinten: [");
				}
				break;
			case '}':
				if (!isEmpty()) {
					if (stackArray[top] == '{') {
						pop();
						System.out.println("popped {");
					} else {
						System.out.println("Klammer fehler {}");
					}
				} else {
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
		FileReader fr = new FileReader("bin\\aufgabenblatt03\\test");
		BufferedReader br = new BufferedReader(fr);

		Stack s2 = new Stack();
		String t = br.readLine();
		System.out.println(t);
		s2.solve(t);
		// s2.solve("((((Test)))))");
	}

}
