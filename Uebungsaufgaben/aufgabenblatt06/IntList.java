package aufgabenblatt06;

import java.util.Random;

public class IntList {

	public Node head;
	static int counter = 0;
	static boolean sorted = false;

	public IntList() {
		head = null;
	}

	public static void main(String[] args) {

		Random rand = new Random();
		IntList il1 = new IntList();
		IntList il2 = new IntList();

		Node temp = new Node(rand.nextInt(40) + 20);

		il1.head = temp;

		for (int i = 0; i < 20; i++) {
			temp.next = new Node(rand.nextInt(40) + 20);
			temp = temp.next;
		}

		System.out.println("###################LISTE 1#################");
		il1.ausgeben(il1.head);
		
		listInsert(il1, il2);
		System.out.println("###################LISTE 2#################");
		il2.ausgeben(il2.head);
		System.out.println("Durchläufe: ");
		System.out.println(counter);
	}

	public void ausgeben(Node n) {
		System.out.println(n.value);
		while (n.next != null) {
			System.out.println(n.next.value);

			n = n.next;
		}
	}

	public static void listInsert(IntList list1, IntList list2) {

		Node n = list1.head;

		Node temp = new Node();
		list2.head = new Node(list1.head.value);

		while (n.next != null) {
			counter++;
			temp = n.next;

			if (temp.value < list2.head.value) { //ganz vorne
				Node temp2 = list2.head;
				list2.head = new Node(temp.value);
				list2.head.next = temp2;

			} else if (temp.value >= list2.head.value && list2.head.next == null) { //2. wenn danach nichts
				Node temp3 = new Node(temp.value);
				list2.head.next = temp3;
			}
				else if (temp.value > list2.head.value && temp.value < list2.head.next.value) { //2. wenn 2.schon existiert
					
					Node temp3 = new Node(temp.value);
					Node end = list2.head.next;
					list2.head.next = temp3;
					temp3.next = end;
			} else{ //rest
				

				Node previous = list2.head;
				Node iterate = list2.head.next;
				sorted = false;
				while (temp.value > iterate.value) {
					if (iterate.next == null) {
						
						Node end = new Node(temp.value);
						iterate.next = end;
						sorted = true;
					} else {

						iterate = iterate.next;
						previous = previous.next;
					}
				}
				if(!sorted){
				Node temp123 = new Node(temp.value);
				temp123.next = iterate;
				previous.next = temp123;
				}
				// n3.next = temp123;

			}

			n = n.next;
		}

	}

}