package aufgabenblatt01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Person {
	
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.read();
		
		if(p1.dateTest()){
			System.out.println("richtig");
		}else{
			System.out.println("falsch");
		}
	}

	private String name;
	private String telefonnummer;
	private String geburtsdatum;
	
	public boolean dateTest(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			sdf.parse(geburtsdatum);
			return true;
		}catch(ParseException e){
			return false;
		}
		
	}
	
	public void read(){
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Name eingeben:");
		setName(reader.nextLine());
		System.out.println("Telefonnummer eingeben:");
		setTelefonnummer(reader.nextLine());
		System.out.println("Geburtsdatum eingeben:");
		setGeburtsdatum(reader.nextLine());
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
