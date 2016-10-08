package aufgabenblatt01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Person {
	//test
	
	private String name;
	private String telefonnummer;
	private String geburtsdatum;

	@Override
	public String toString() {
		return "Name: " + getName() + "\nTelefonnummer: " + getTelefonnummer() + "\nGeburtsdatum: " + getGeburtsdatum();
	}

	public boolean dateTest(String gDatum) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(gDatum);
			return true;
		} catch (ParseException e) {
			return false;
		}

	}

	public void read() {
		Scanner reader = new Scanner(System.in);
		boolean valid = false;
		System.out.println("Name eingeben:");
		setName(reader.nextLine());
		System.out.println("Telefonnummer eingeben:");
		setTelefonnummer(reader.nextLine());
		System.out.println("Geburtsdatum eingeben: (TT/MM/JJJJ Format)");

		while (!valid) {
			String gDatum = reader.nextLine();
			if (dateTest(gDatum)) {
				setGeburtsdatum(gDatum);
				valid = true;
			} else {
				System.out.println("Datum falsch eingegeben. Nochmal versuchen");
			}
		}

		// reader.close();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

}
