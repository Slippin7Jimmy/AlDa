package aufgabenblatt01;

import java.util.ArrayList;
import java.util.Scanner;



public class Student extends Person {

	static ArrayList<String> maS = new ArrayList<>();
	
	private String matrikelnummer;
	
	
	int counter = 0;

	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}

	@Override
	public void read() {
		super.read();
		boolean valid = false;
		Scanner reader = new Scanner(System.in);
		do{
		System.out.println("Matrikelnummer eingeben: ");
		String matrTemp = reader.nextLine();
		if(!maS.contains(matrTemp)){
			maS.add(matrTemp);
			setMatrikelnummer(matrTemp);
			valid = true;
		}else{
			System.out.println("Fehler. Matrikelnummer gibt es schon.");
		}
		}while(!valid);
		
//		reader.close();
		System.out.println("OK");
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nMatrikelnummer: " + getMatrikelnummer();
	}

}
