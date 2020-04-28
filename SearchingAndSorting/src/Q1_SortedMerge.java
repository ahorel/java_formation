/*
 * Avec deux sorted arrays A et B o� A un buffer suffisamment grand pour stocker B � la fin.
 * Ecrire une m�thode permettant de faire un merge entre B et A � partir d'A dans un ordre tri�
 */

/*
 * Puisque A a suffisamment d'espace � la fin, on compare les �l�ments de A et de B et on les ins�re dans l'ordre
 * Jusqu'� ce qu'on ait termin� de crawler tous les elements de A et de B
 * Le seul probl�me est qu'il ne faut pas ins�rer les �l�ments au d�but de A sinon il faudra faire un shift pour lib�rer de l'espace pour les suivants
 * C'est mieux d'ins�rer les �l�ments � la fin o� il y a de l'espace disponible
 */
public class Q1_SortedMerge {
	
	void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1; // Index of last element in array A
		int indexB = lastB - 1; // Index of last element in array B
		int indexMerged = lastB + lastA - 1;
		
		/* Merge A et B starting from the last element in each*/
		while(indexB >= 0) {
			//end of A is > than the index last element of B
			if(indexA >= 0 && a[indexA] > a[indexB]) {
				a[indexMerged] = a[indexA]; // Copy elements
				indexA--;
			}
			else{
				a[indexMerged] = b[indexB]; // Copy elements
				indexB--;
			}
			indexMerged--;
		}
	}
}
