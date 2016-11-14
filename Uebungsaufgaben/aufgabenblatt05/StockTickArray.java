package aufgabenblatt05;

import java.util.Scanner;

public class StockTickArray {

	static StockTickArray[] sta;
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Array-Laenge angeben:");
		int aLength = Integer.parseInt(reader.nextLine());
		
		sta = new StockTickArray[aLength];
		
		
	}
	
	public void sortStockTickArray(){
		
	}
	
}
