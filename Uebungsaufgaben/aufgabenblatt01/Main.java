package aufgabenblatt01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Student[] students = new Student[4];

		for (int i = 0; i < students.length; i++) {
			students[i] = new Student();
			students[i].read();
		}

		System.out.println("Zu suchende Matrikelnummer eingeben: ");
		Scanner reader = new Scanner(System.in);
		String searchMn = reader.nextLine();
		reader.close();
		boolean found = false;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getMatrikelnummer().equals(searchMn)) {
				System.out.println(students[i].toString());
				found=true;
			}

		}
		if (!found) {
			System.out.println("Matrikelnummer " + searchMn + " existiert nicht.");
		}
	}
}
