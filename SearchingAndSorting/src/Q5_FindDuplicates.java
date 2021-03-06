import java.util.Arrays;
import java.util.BitSet;

/*
 * Ref : https://stackoverflow.com/questions/9141830/explain-the-use-of-a-bit-vector-for-determining-if-all-characters-are-unique
 * https://flylib.com/books/en/2.300.1/bit_vectors.html
 * Question : 
 * Avec un tableau de tous les nombres de 1 � N, o� N <= 32 0000.
 * Le tableau peut avoir des dupliqu�s et on ne sait pas quelle est la valeur du nombre N
 * Avec seulement 4 KiloBytes de m�moire disponibles, comment peut on �crire tous les dupliqu�s dans le tableau ?
 */
/*
 * On a 4 kilobytes de m�moire donc on peut adresser 4 * 1000 * 2^10 bits 
 */

/*
 * En utilisant un vecteur de 32 000 bits, ou chaque bits repr�sente un entier.
 * En utilisant ce vecteur de bits, on peut it�rer � travers le tableau, en flaguant chaque element v en settant v � 1
 * Quand on passe au devant d'un element dupliqu�, on l'�crit 
 */

public class Q5_FindDuplicates {
	public static  void checkDuplicates(int[] array) {
		System.out.println("[Q5_FindDuplicates] checkDuplicates array=" + Arrays.toString(array));
		
		Q5_BitVector bv = new Q5_BitVector(32000);
		
		for (int i = 0; i < array.length; i ++) {
			int num = array[i];
			int num0 = num - 1; // BitSet starts at 1, array starts at 0
			System.out.println("[Q5_FindDuplicates] checkDuplicates num0=" + num0);

			if(bv.get(num0)) {
				System.out.println("[Q5_FindDuplicates] num0=" + num0);
			}
			else {
				bv.set(num0);
			}
		}
	}
}

