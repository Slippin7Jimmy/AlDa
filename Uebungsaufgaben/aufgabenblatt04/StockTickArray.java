package aufgabenblatt04;

import java.util.Arrays;
import java.util.Random;
import java.util.SortedSet;

public class StockTickArray {

	String[] symbols = { "AMZN", "IBM", "CSCO", "HPQ", "GOOG", "ORCL", "BABA", "AAPL", "SAP", "MSFT" };
	Random rand = new Random();
	private final static int MAX = 10;
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
		System.out.println("st1:");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());

		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n\n");

		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st2[i].getSymbol() + "\t" + sta.st2[i].getKurs());

		}

		sta.sortStockTickArray();
		System.out.println("Sortiert");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st[i].getSymbol() + "\t" + sta.st[i].getKurs());

		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++\n\n");
		for (int i = 0; i < MAX; i++) {
			System.out.println(sta.st2[i].getSymbol() + "\t" + sta.st2[i].getKurs());

		}

	}

	public void sortStockTickArray() {
		// System.out.println("*----------------------Nach Kurs
		// sortiert:----------------------*");
//		insertionSortKurs(st);
		// System.out.println("*----------------------Nach Symobl
		// sortiert:----------------------*");
		 insertionSortSymbol(st);
		// System.out.println("*----------------------Nach Kurs
		// sortiert:----------------------*");
//		binSort(st2);
		// System.out.println("*----------------------Nach Symobl
		binSortSymbol(st2);
		// sortiert:----------------------*");
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
		System.out.println(counter);
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
		System.out.println(counter);
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
		
		System.out.println(counter);
	}
}
