package aufgabenblatt03;

public class Stack {

	private char[] stackArray;
	private int top;

	public Stack() {
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

	public static void main(String[] args) {
		Stack s1 = new Stack();
		s1.push('T');

		System.out.println(s1.stackArray[s1.top]);

		s1.push('E');
		System.out.println(s1.stackArray[s1.top]);

		s1.push('S');
		System.out.println(s1.stackArray[s1.top]);

		s1.push('T');
		System.out.println(s1.stackArray[s1.top]);

		s1.pop();
		System.out.println(s1.stackArray[s1.top]);

		for (int i = 0; i < s1.stackArray.length; i++) {
			System.out.println(s1.stackArray[i]);
		}
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
		return false;
	}

}
