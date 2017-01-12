package aufgabenblatt06;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {

	static int[] p;
	static int bI;
	static int sJ;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Größe angeben:");
		int pLength = Integer.parseInt(reader.nextLine());
		
		p = new int[pLength];
		for (int i = 0; i < p.length; i++) {
			p[i] = i + 1;
			System.out.print(p[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < factorial(pLength)-1; i++) {
			
			bI = getBiggestI();
//			System.out.print(" größtest i: " + bI + " wert: " + p[bI]);
			sJ = getSmallestJ();
//			System.out.print(" kleinstes j: " + sJ + " wert: " + p[sJ]);
			// System.out.println("p[i] und p[j] tauschen");
			int temp = p[bI];
			p[bI] = p[sJ];
			p[sJ] = temp;

			Arrays.sort(p, bI + 1, p.length);

			for (int j = 0; j < p.length; j++) {
				System.out.print(p[j] + " ");

			}
			// System.out.print(" i: " + bI+ " wert: "+p[bI]);
			// System.out.print(" j: " + sJ+ " wert: "+ p[sJ]);
			System.out.println();
		}
		System.out.println(factorial(pLength));
	}
	
	 public static int factorial(int n) {
	        int fact = 1;
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	    }

	public static int getBiggestI() {
		// System.out.println("laenge: "+p.length);
		for (int i = p.length - 2; i >= 0; i--) {
			if (p[i] < p[i + 1]) {

				return i;
			}
		}
		System.out.println("ENDE");
		return 0;
	}

	public static int getSmallestJ() {
		int temp = 100;
		int tempi = 999;
		for (int i = bI + 1; i < p.length; i++) {
			if (p[bI] < p[i]) {
				if (p[i] < temp) {
					temp = p[i];
					tempi = i;
				}
			}

		}
		return tempi;
	}
}
