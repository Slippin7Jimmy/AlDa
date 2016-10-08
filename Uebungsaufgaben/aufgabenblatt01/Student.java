package aufgabenblatt01;

import java.util.Scanner;

public class Student extends Person {

	private String matrikelnummer;

	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	@Override
	public void read() {
		super.read();
		Scanner reader = new Scanner(System.in);
		System.out.println("Matrikelnummer eingeben: ");
		setMatrikelnummer(reader.nextLine());
//		reader.close();
		System.out.println("OK");
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nMatrikelnummer: " + getMatrikelnummer();
	}

}
