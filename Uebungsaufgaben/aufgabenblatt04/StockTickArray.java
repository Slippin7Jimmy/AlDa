package aufgabenblatt04;

import java.util.Random;
import java.util.Scanner;

public class StockTickArray {

	String[] symbols = { "AMZN", "IBM", "CSCO", "HPQ", "GOOG", "ORCL", "BABA", "AAPL", "SAP", "MSFT" };
	Random rand = new Random();
	private final static int MAX = 10;
	static int averageBin = 0;
	static int counterBin = 0;
	static int averageBinSymbol = 0;
	static int counterBinSymbol = 0;
	static int averageInsertion = 0;
	static int counterInsertion = 0;
	static int averageInsertionSymbol = 0;
	static int counterInsertionSymbol = 0;

	int repeat = 0;
	StockTick[] st;
	StockTick[] st2;
	StockTick[] st3;

	public StockTickArray() {

		st = new StockTick[MAX];

		for (int i = 0; i < st.length; i++) {
			st[i] = new StockTick();
			st[i].setKurs(rand.nextInt(21) + 70);
			st[i].setSymbol(randomizeSymbol());
		}
		st2 = new StockTick[st.length];
		st3 = new StockTick[st.length];

		System.arraycopy(st, 0, st2, 0, st.length);
		System.arraycopy(st, 0, st3, 0, st.length);
	}

	public String randomizeSymbol() {
		int randN = rand.nextInt(10);

		return symbols[randN];

	}

	public static void main(String[] args) {
		StockTickArray sta = new StockTickArray();

		int choice;

		Scanner reader = new Scanner(System.in);

		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());

		}
		System.out.println("Auswählen:");
		System.out.println("1 für Sequentielles Kurs");
		System.out.println("2 für Sequentielles Symbol");
		System.out.println("3 für Binäres Kurs");
		System.out.println("4 für Binäres Symbol");
		System.out.println("5 für S Kurs dann S Symbol");
		choice = Integer.parseInt(reader.nextLine());
		switch (choice) {
		case 1:
			sta.insertionSortKurs(sta.st);
			double realAverageInsertion = averageInsertion / (double) counterInsertion; // InsertionSearch
			// Average
			System.out.println("Durchschnitt InsertionSort Kurs: " + realAverageInsertion);
			break;
		case 2:
			sta.insertionSortSymbol(sta.st);
			double realAverageInsertionSymbol = averageInsertionSymbol / (double) counterInsertionSymbol; // InsertionSearchSymbol
			// Average
			System.out.println("Durchschnitt InsertionSort Symbol: " + realAverageInsertionSymbol);
			break;
		case 3:
			sta.binSort(sta.st);
			break;

		case 4:
			sta.binSortSymbol(sta.st);
			break;
		case 5:
			sta.insertionSortKurs(sta.st);
			sta.insertionSortSymbol(sta.st);
			break;
		default:
			break;
		}
		// unsortiertes array

		System.out.println("Sortiert");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());

		}

	}

	public int binarySearch(StockTick[] st, StockTick temp, int l, int r) {
		int m = 0;
		while (l <= r) {
			m = (l + r) / 2;
			if (temp.getKurs() < st[m].getKurs()) {

				r = m - 1;
			} else {
				l = m + 1;
			}

		}
		return l;
	}

	public void sortStockTickArray() {

		double realAverageBinSymbol = averageBinSymbol / (double) counterBinSymbol; // BinarySearchSymbol
																					// Average

	}

	public void binSort(StockTick[] a) {
		int l, r, m;
		int counter = 0;
		StockTick temp = new StockTick();

		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			l = 0;
			r = i - 1;

			while (l <= r) {
				m = (l + r) / 2;
				if (temp.getKurs() < a[m].getKurs()) {
					counter++;
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
			for (int j = i - 1; j >= l; j--) {
				a[j + 1] = a[j];

			}
			a[l] = temp;

		}
		counterBin++;
		averageBin += counter;

		System.out.println(counter);

		double realAverageBin = averageBin / (double) counterBin; // BinarySearch
	}

	public void binSortSymbol(StockTick[] a) {
		int l, r, m;
		int counter = 0;

		StockTick temp = new StockTick();

		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			l = 0;
			r = i - 1;

			while (l <= r) {
				m = (l + r) / 2;
				if (temp.getSymbol().compareTo(a[m].getSymbol()) <= 0) {
					counter++;
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
			for (int j = i - 1; j >= l; j--) {
				a[j + 1] = a[j];

			}
			a[l] = temp;

		}
		counterBinSymbol++;
		averageBinSymbol += counter;
		System.out.println(counter);

	}

	public void insertionSortSymbol(StockTick[] a) {
		int counter = 0;
		for (int i = 1; i < a.length; i++) {
			StockTick temp = new StockTick();
			temp = a[i];
			// char temp = a[i].getSymbol().charAt(0);
			int j = i;

			while (j > 0 && a[j - 1].getSymbol().compareTo((temp.getSymbol())) >= 0) {
				counter++;
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
		counterInsertionSymbol++;
		averageInsertionSymbol += counter;
		System.out.println(counter);

		while (repeat < 9) {
			StockTick[] st2 = new StockTick[MAX];
			for (int i = 0; i < st2.length; i++) {
				st2[i] = new StockTick();
				st2[i].setKurs(rand.nextInt(21) + 70);
				st2[i].setSymbol(randomizeSymbol());
			}
			repeat++;
			insertionSortSymbol(st2);

		}
	}

	public void insertionSortKurs(StockTick[] a) {
		StockTick temp = new StockTick();

		int counter = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			int j = i;
			while (j > 0 && temp.getKurs() < a[j - 1].getKurs()) {
				counter++;
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
		counterInsertion++;
		averageInsertion += counter;
		System.out.println("Durchläufe: " + counter);

		while (repeat < 9) {
			StockTick[] st2 = new StockTick[MAX];
			for (int i = 0; i < st2.length; i++) {
				st2[i] = new StockTick();
				st2[i].setKurs(rand.nextInt(21) + 70);
				st2[i].setSymbol(randomizeSymbol());
			}
			repeat++;
			insertionSortKurs(st2);

		}

	}
}
