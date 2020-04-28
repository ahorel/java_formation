/*
 * Avec deux sorted arrays A et B où A un buffer suffisamment grand pour stocker B à la fin.
 * Ecrire une méthode permettant de faire un merge entre B et A à partir d'A dans un ordre trié
 */

/*
 * Puisque A a suffisamment d'espace à la fin, on compare les éléments de A et de B et on les insère dans l'ordre
 * Jusqu'à ce qu'on ait terminé de crawler tous les elements de A et de B
 * Le seul problème est qu'il ne faut pas insérer les éléments au début de A sinon il faudra faire un shift pour libérer de l'espace pour les suivants
 * C'est mieux d'insérer les éléments à la fin où il y a de l'espace disponible
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
