package aufgabenblatt02;

import java.util.Random;

public class Main {

	public static void printKurs(StockTick[] st) {
		for (int i = 0; i < st.length; i++) {
			System.out.print("Tag " + (i + 1) + "\t|");
		}
		System.out.println();
		for (int i = 0; i < st.length; i++) {
			System.out.print(st[i].getKurs() + "\t|");
		}
	}
	
	public static void calcKursWinPercentageV3(StockTick[] st){
		int buyDay = 0;
		int sellDay = 1;
		double mostWin = 0;
		int lowest = 0;
	
		
		
		
		for (int i = 0; i < st.length; i++) {
			if (st[i].getKurs() < st[lowest].getKurs()){
				lowest = i;
			}
			
			double tempWin = (((st[i].getKurs() - st[lowest].getKurs()) / st[lowest].getKurs()) * 100);
			if (tempWin > mostWin) {
				mostWin = tempWin;
				buyDay = lowest+1;
				sellDay = i+1;
			}
			
		}
		System.out.println("Biggest Win NEWNEWNEWNEW: " + mostWin);
//		System.out.println("In €: " + decWin);
		System.out.println("Kaufen an Tag " + buyDay);
		System.out.println("Verkaufen an Tag " + sellDay);
		
	}

	public static void calcKursWinPercentageV2(StockTick[] st) {
		int buyDay = 0;
		int sellDay = 0;
		double mostWin = 0;
		double decWin = 0;
		int i = 0;

		for (int j = i + 1; j < st.length; j++) {
			double tempWin = (((st[j].getKurs() - st[i].getKurs()) / st[i].getKurs()) * 100);
			
			if (tempWin > mostWin) {
				decWin = st[j].getKurs() - st[i].getKurs();
				mostWin = tempWin;
				buyDay = i + 1;
				sellDay = j + 1;
			}

			if (j == st.length - 1) {
				i++;
				j = i;
			}

		}

		System.out.println("Biggest Win (Percentage One Loop): " + mostWin);
		System.out.println("In €: " + decWin);
		System.out.println("Kaufen an Tag " + buyDay);
		System.out.println("Verkaufen an Tag " + sellDay);

	}

	// -------Rechnung proz Gewinn-----------------
	public static void calcKursWinPercentage(StockTick[] st) {
		double mostWin = 0;
		int buyDay = 0;
		int sellDay = 0;
		double decWin = 0;
		for (int i = 0; i < st.length; i++) {
			for (int j = i + 1; j < st.length; j++) {
				if ((((st[j].getKurs() - st[i].getKurs()) / st[i].getKurs()) * 100) > mostWin) {
					mostWin = (((st[j].getKurs() - st[i].getKurs()) / st[i].getKurs()) * 100);
					decWin = st[j].getKurs() - st[i].getKurs();
					buyDay = i + 1;
					sellDay = j + 1;
				}
			}
		}
		System.out.println("Biggest Win (Percentage): " + mostWin);
		System.out.println("In €: " + decWin);
		System.out.println("Kaufen an Tag " + buyDay);
		System.out.println("Verkaufen an Tag " + sellDay);
	}
	// -------Rechnung proz Gewinn-----------------

	// -------Rechnung reiner Gewinn-----------------

	public static void calcKursWinFlatV2(StockTick[] st) {
		int buyDay = 0;
		int sellDay = 0;
		double mostWin = 0;
		double proWin = 0;
		int i = 0;
		
		
		
			for (int j = i + 1; j < st.length; j++) {
				if (st[j].getKurs() - st[i].getKurs() > mostWin) {
					mostWin = st[j].getKurs() - st[i].getKurs();
					proWin = (((st[j].getKurs() - st[i].getKurs()) / st[i].getKurs()) * 100);
					buyDay = i + 1;
					sellDay = j + 1;
				}
			
		

		

			if (j == st.length - 1) {
				i++;
				j = i;
			}

		}

		System.out.println("Biggest Win (FLAT One Loop): " + mostWin);
		System.out.println("In %: " + proWin);
		System.out.println("Kaufen an Tag " + buyDay);
		System.out.println("Verkaufen an Tag " + sellDay);
	}

	public static void calcKursWinFlat(StockTick[] st) {
		double mostWin = 0;
		int buyDay = 0;
		int sellDay = 0;
		double proWin = 0;
		for (int i = 0; i < st.length - 1; i++) {
			for (int j = i + 1; j < st.length; j++) {
				if (st[j].getKurs() - st[i].getKurs() > mostWin) {
					mostWin = st[j].getKurs() - st[i].getKurs();
					proWin = (((st[j].getKurs() - st[i].getKurs()) / st[i].getKurs()) * 100);
					buyDay = i + 1;
					sellDay = j + 1;
				}
			}
		}

		System.out.println("Biggest Win (FLAT): " + mostWin);
		System.out.println("In %: " + proWin);
		System.out.println("Kaufen an Tag " + buyDay);
		System.out.println("Verkaufen an Tag " + sellDay);
	}
	// -------Rechnung reiner Gewinn-----------------

	public static void main(String[] args) {

		// ----------------------------TestCase---------------------------------------
		StockTick[] st1 = new StockTick[21];

		for (int i = 0; i < st1.length; i++) {
			st1[i] = new StockTick();
		}

		st1[0].setKurs(127.5, 0);
		st1[1].setKurs(st1[0].getKurs(), -0.5f);
		st1[2].setKurs(st1[1].getKurs(), 2f);
		st1[3].setKurs(st1[2].getKurs(), -1f);
		st1[4].setKurs(st1[3].getKurs(), 1f);
		st1[5].setKurs(st1[4].getKurs(), 3.5f);
		st1[6].setKurs(st1[5].getKurs(), -13f);
		st1[7].setKurs(st1[6].getKurs(), 7f);
		st1[8].setKurs(st1[7].getKurs(), -2f);
		st1[9].setKurs(st1[8].getKurs(), -6f);
		st1[10].setKurs(st1[9].getKurs(), -9f);
		st1[11].setKurs(st1[10].getKurs(), -21f);
		st1[12].setKurs(st1[11].getKurs(), -17f);
		st1[13].setKurs(st1[12].getKurs(), -5f);
		st1[14].setKurs(st1[13].getKurs(), 0.5f);
		st1[15].setKurs(st1[14].getKurs(), 4f);
		st1[16].setKurs(st1[15].getKurs(), -7f);
		st1[17].setKurs(st1[16].getKurs(), -12f);
		st1[18].setKurs(st1[17].getKurs(), 2.5f);
		st1[19].setKurs(st1[18].getKurs(), -3f);
		st1[20].setKurs(st1[19].getKurs(), 2f);
		System.out.println("----------------Beispiel-Aufgabe--------------------");
		printKurs(st1);
		System.out.println();
		calcKursWinFlat(st1);
		System.out.println("------------------------");
		calcKursWinPercentage(st1);
		// ----------------------------TestCase---------------------------------------

		// Random

		Random rand = new Random();
		StockTick[] st2 = new StockTick[21];

		for (int i = 0; i < st2.length; i++) {
			st2[i] = new StockTick();
		}
		st2[0].setKurs(rand.nextInt(101) + 700, 0);
		for (int i = 1; i < st2.length; i++) {
			st2[i].setKurs(st2[i - 1].getKurs(), rand.nextInt(80) - 40);
		}
//		System.out.println("----------------Random-Aufgabe----------------------");
		printKurs(st2);
		System.out.println();
//		calcKursWinFlat(st2);
//		System.out.println("------------------------");
		calcKursWinPercentage(st2);
//		System.out.println("----------OneLoop Percentage---------");
//		calcKursWinPercentageV2(st2);
//		System.out.println("----------OneLoop Flat---------");
//		calcKursWinFlatV2(st2);
		System.out.println("---------------------------");
		calcKursWinPercentageV3(st2);
		
	}

}
