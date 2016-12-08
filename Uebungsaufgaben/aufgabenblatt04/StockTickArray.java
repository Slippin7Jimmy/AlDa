package aufgabenblatt04;

import java.util.Random;

public class StockTickArray {

	Random rand = new Random();
	private final static int MAX = 100;
	StockTick[] st;

	public StockTickArray() {
		
		st = new StockTick[MAX];

		for (int i = 0; i < st.length; i++) {
			st[i] = new StockTick();
			st[i].setKurs(rand.nextInt(21) + 70);
			st[i].setSymbol(randomizeSymbol());
		}

	}

	public String randomizeSymbol() {
		int randN = rand.nextInt(10);

		switch (randN) {
		case 0:
			return "AMZN";

		case 1:

			return "IBM";
		case 2:

			return "CSCO";
		case 3:

			return "HPQ";
		case 4:

			return "GOOG";
		case 5:

			return "ORCL";
		case 6:

			return "BABA";
		case 7:

			return "AAPL";
		case 8:

			return "SAP";
		case 9:

			return "MSFT";
		default:
			return "FEHLER";
		}

	}

	
	
	public static void main(String[] args) {
		StockTickArray sta = new StockTickArray();
		
		for (int i = 0; i < MAX-1; i++) {
			System.out.println(sta.st[i].getSymbol()+ "\t" + sta.st[i].getKurs());
			
		}

		sta.sortStockTickArray();
		System.out.println("Sortiert");
		for (int i = 0; i < MAX-1; i++) {
			System.out.println(sta.st[i].getSymbol()+ "\t" + sta.st[i].getKurs());
			
		}
		
	}

	public void sortStockTickArray() {
		insertionSort(st);
	}
	
	public void binSort(StockTick[] a){
		int j,l,r,m;
		
		for (int i = 0; i < a.length; i++) {
			int temp = a[i].getKurs();
		}
		
		
	}
	
	public void insertionSort(StockTick[] a){
		int i,j;
		for(i = 1; i < a.length; i++){
			int temp = a[i].getKurs();
			j = i;
			while(j > 0 && temp >= a[j-1].getKurs()){
				a[j].setKurs(a[j-1].getKurs());
				j--;
			}
			a[j].setKurs(temp);
		}
	}
}
