import java.util.Scanner;
import javax.swing.*;

/**
 * <p style="font-family:Trebuchet MS">
 * Kjo klase permbane metoden <i>Levenshtein</i> qe llogarit ngjashmerine
 * ndermjet dy Stringjeve.
 * </p>
 * <p style="font-family: Trebuchet MS">
 * Inputin e mer nga konsola permes objektit Scanner.
 * </p>
 * <p style="font-family: Trebuchet MS">
 * Per te punuar sic duhet, ju duhet te jepni nje fjale ne nje rresht.
 * </p>
 * <p style="font-family:Trebuchet MS">
 * Kjo klase kerkon Java 7.0 ose me lart.
 * </p>
 * 
 * @author Sahadete Jashari
 *
 */

public class LV {

	/**
	 * <ul>
	 * <li>
	 * <p style ="font-family:Trebuchet MS">
	 * Metoda main merr inputin nga perdoruesi dhe e therret metoden
	 * Levenshtein.
	 * 
	 * @param args
	 *            vargu i objekteve String
	 *            </p>
	 *            </li>
	 *            </ul>
	 * 
	 */
	public static void main(String args[]) {
		
		String s = JOptionPane.showInputDialog(null, "Jepni fjalen e pare.");
		String t = JOptionPane.showInputDialog(null, "Jepni fjalen e dyte.");

		/*Scanner input = new Scanner(System.in);
		System.out.print("Shkruani fjalen e pare: ");
		String a = input.nextLine();
		System.out.print("\nShkruani fjalen e dyte: ");
		String b = input.nextLine();
		input.close();
	*/
		int ndryshimet = Levenshtein(s, t);

		//System.out.println("\nNe keto dy fjale duhet te behen " + ndryshimet + " ndryshime, qe te behen te njejta!");
		
		JOptionPane.showMessageDialog(null,"Ne keto dy fjale duhet te behen " + ndryshimet + " ndryshime, qe te behen te njejta!");

	}

	/**
	 * <ul>
	 * <li>
	 * <p style="font-family: Trebuchet MS">
	 * Kjo metode llogarit ngjashmerine ndermjet dy fjaleve. Deklaron nje varg
	 * dy dimensional dhe pastaj popullon anetaret e tij.
	 * </p>
	 * </li>
	 * </ul>
	 * 
	 * @param s1
	 *            fjala e pare e tipit String
	 * @param s2
	 *            fjala e dyte e tipit String
	 * 
	 * @return Kthen nje numer te plote qe tregon numrin e ndryshimeve qe duhet
	 *         bere.
	 */
	public static int Levenshtein(String s1, String s2) {
		int ndryshimi;

		int gjatsia1 = s1.length();
		int gjatsia2 = s2.length();

		int v[][] = new int[gjatsia1 + 1][gjatsia2 + 1];

		for (int i = 0; i <= gjatsia1; i++) {

			v[i][0] = i;
		}
		for (int j = 0; j <= gjatsia2; j++) {
			v[0][j] = j;
		}

		for (int i = 1; i <= gjatsia1; i++) {

			for (int j = 1; j <= gjatsia2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					ndryshimi = 0;

				} else {
					ndryshimi = 1;
				}
				int pjesa1 = Math.min(v[i][j - 1] + 1, v[i - 1][j] + 1);
				v[i][j] = Math.min(pjesa1, v[i - 1][j - 1] + ndryshimi);

			}
		}
		int rezultati = v[gjatsia1][gjatsia2];
		return rezultati;

	}

}
