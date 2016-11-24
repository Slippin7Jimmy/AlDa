package aufgabenblatt03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.EmptyStackException;

public class Stack {

	private char[] stackArray;
	private final int MAX = 20;
	private int top;

	public Stack() {
		stackArray = new char[0];
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
		if (top < 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (top == stackArray.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	public void solveComments(String s) {

		for (int i = 0; i < stackArray.length; i++) {

			char c = s.charAt(i);

			switch (c) {
			case '/':
				if (i + 1 < stackArray.length) {
					if (s.charAt(i + 1) == '*') {
						push('*');
						System.out.println("Kommentar auf");
						i++;
					}
				}
				break;

			case '*':
				if (i + 1 < stackArray.length) {
					if (s.charAt(i + 1) == '/') {
						if (stackArray[top] == '*') {
							pop();
							System.out.println("Kommentar zu");
						}
						i++;

					}
				}
				break;

			}
		}

		if (isEmpty()) {
			System.out.println("Keine Fehler");
		} else {
			System.out.println("Fehler");
		}

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
				// System.out.println(stackArray.length);
				// System.out.println("drin");
				if (!isEmpty()) {
					if (stackArray[top] == '(') {
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
				// System.out.println("keine klammer übersprungen");
				break;
			}
			// }
		}
		// System.out.println("Fin");

	}
	

	public static void main(String[] args) throws IOException {
		Stack s2 = new Stack();
		File f = new File("D:\\HTWG\\WIN\\AlDa\\Uebungsaufgaben\\aufgabenblatt03\\test");
		// File f = new
		// File("D:\\HTWG\\WIN\\AlDa\\Uebungsaufgaben\\aufgabenblatt01\\Main.java");
		Scanner fileReader = new Scanner(f, "UTF-8");

//		while (fileReader.hasNextLine()) {
//			s2.solve(fileReader.nextLine());
//		}

		Stack s3 = new Stack();
		System.out.println("Rest S3:");
		s3.solveComments("/*ababab/*cdcdcdc*/efef/*ghghgh*/*/");
		for (int i = 0; i < s3.top; i++) {
			System.out.println(s3.stackArray[i]);
		}

//		System.out.println("rest:");
//		for (int i = 0; i < s2.top; i++) {
//			System.out.println(s2.stackArray[i]);
//		}

	}

}