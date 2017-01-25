package aufgabenblatt05;

import java.util.Random;
import java.util.Scanner;

import aufgabenblatt04.StockTick;

public class StockTickArray {

	String[] symbols = { "AMZN", "IBM", "CSCO", "HPQ", "GOOG", "ORCL", "BABA", "AAPL", "SAP", "MSFT" };
	Random rand = new Random();
	private final static int MAX = 100;
	StockTick[] st;
	StockTick[] st2;
	public static int qsc = 0;
	public static int qscr = 0;

	public StockTickArray() {

		st = new StockTick[MAX];

		for (int i = 0; i < st.length; i++) {
			st[i] = new StockTick();
			st[i].setKurs(rand.nextInt(21) + 70);
			st[i].setSymbol(randomizeSymbol());
		}
		
		st2 = new StockTick[st.length];
		
		for (int i = 0; i < st.length; i++) {
			st2[i] = st[i];
		}
	}

	public String randomizeSymbol() {
		int randN = rand.nextInt(10);

		return symbols[randN];

	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.println("Welche Aufgabe? 1 2 oder 3");
		int option = Integer.parseInt(reader.nextLine());

		switch (option) {
		case 1:
			execA1();
			break;
		case 2:
			execA2();
			break;
		case 3:
			execA3();
			break;
		default:
			break;
		}
	}

	public static void execA1() {
		StockTickArray sta = new StockTickArray();

		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());
		}

		sta.quickSort(sta.st, 0, sta.st.length - 1);

		System.out.println("###########################SORTIERT###########################");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());
		}

		sta.quickSortSymbol(sta.st, 0, sta.st.length - 1);

		System.out.println("###########################SORTIERT###########################");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());
		}
	}

	public static void execA2() {
		StockTickArray sta = new StockTickArray();
		System.out.println("UNSORTIERT");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());
		}
		System.out.println("###########");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st2[i].getSymbol() + "\t" + sta.st2[i].getKurs());
		}

		sta.quickSort(sta.st, 0, sta.st.length - 1);
		System.out.println("####################SORTIERT QS###################");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());
		}
		
		sta.quickSortRandom(sta.st2, 0, sta.st2.length - 1);
		System.out.println("####################SORTIERT QS RANDOM#############");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st2[i].getSymbol() + "\t" + sta.st2[i].getKurs());
		}
		
		System.out.println("Quicksort Durchläufe: "+qsc);
		System.out.println("Quicksort Random Durchläufe: " + qscr);
		
		

	}
	
	public static void execA3(){
		StockTickArray sta = new StockTickArray();
		System.out.println("UNSORTIERT");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());
		}
		System.out.println("###########");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st2[i].getSymbol() + "\t" + sta.st2[i].getKurs());
		}
		
		sta.quickSortA3(sta.st, 0, sta.st.length-1);
		System.out.println("################SORTIERT?#################");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());
		}
		
	}
	
	public void quickSortA3(StockTick[] st, int left, int right){
		
		StockTick pivot = st[(left + right) / 2];
		int i = left, j = right;
		// --- Partition ---
		while (i <= j) {
			
			
			
			while (st[i].getKurs() < pivot.getKurs()) {
				i++;
			}
			while (pivot.getKurs() < st[j].getKurs()) {
				j--;
			}
			if (i <= j) {
				qsc++;
				StockTick temp = new StockTick();
				temp = st[i];
				st[i] = st[j];
				st[j] = temp;
				i++;
				j--;
			}
		} // es gilt nun i > j
			// --- Rekursion ---
		if(j-left<=10){
			insertionSort(st, left, j);
		}else if (left < j)
			quickSortA3(st, left, j);
		if(right-i<=10){
			insertionSort(st,i,right);
		}else if (i < right)
			quickSortA3(st, i, right);
		
	}
	
	public static void insertionSort(StockTick[] st, int left, int right){
		StockTick temp = new StockTick();
		for (int i = left+1; i < right; i++) {
			temp = st[i];
			int j = i;
			while (j > 0 && temp.getKurs() < st[j - 1].getKurs()) {
				
				st[j] = st[j - 1];
				j--;
			}
			st[j] = temp;
		}
		
	}

	public void quickSortRandom(StockTick[] st, int left, int right) {
		Random rand = new Random();
		int pivotint = rand.nextInt(MAX);
		StockTick pivot = st[pivotint];
		int i = left, j = right;
		// --- Partition ---
		while (i <= j) {
			
			
			
			while (st[i].getKurs() < pivot.getKurs()) {
				i++;
			}
			while (pivot.getKurs() < st[j].getKurs()) {
				j--;
			}
			if (i <= j) {
				qscr++;
				StockTick temp = new StockTick();
				temp = st[i];
				st[i] = st[j];
				st[j] = temp;
				i++;
				j--;
			}
		} // es gilt nun i > j

		// --- Rekursion ---
		if (left < j)
			quickSortRandom(st, left, j);
		if (i < right)
			quickSortRandom(st, i, right);
	}

	void quickSort(StockTick[] st, int left, int right) {
		StockTick pivot = st[(left + right) / 2];
		int i = left, j = right;
		// --- Partition ---
		while (i <= j) {
			
			
			
			while (st[i].getKurs() < pivot.getKurs()) {
				i++;
			}
			while (pivot.getKurs() < st[j].getKurs()) {
				j--;
			}
			if (i <= j) {
				qsc++;
				StockTick temp = new StockTick();
				temp = st[i];
				st[i] = st[j];
				st[j] = temp;
				i++;
				j--;
			}
		} // es gilt nun i > j
			// --- Rekursion ---
		if (left < j)
			quickSort(st, left, j);
		if (i < right)
			quickSort(st, i, right);
	}

	void quickSortSymbol(StockTick[] st, int left, int right) {
		StockTick pivot = st[(left + right) / 2];
		int i = left, j = right;
		// --- Partition ---
		while (i <= j) {

			while (st[i].getSymbol().compareTo(pivot.getSymbol()) < 0) {
				i++;
			}
			while (pivot.getSymbol().compareTo(st[j].getSymbol()) < 0) {
				j--;
			}
			if (i <= j) {

				StockTick temp = new StockTick();
				temp = st[i];
				st[i] = st[j];
				st[j] = temp;
				i++;
				j--;
			}
		} // es gilt nun i > j
			// --- Rekursion ---
		if (left < j)
			quickSortSymbol(st, left, j);
		if (i < right)
			quickSortSymbol(st, i, right);
	}

}
