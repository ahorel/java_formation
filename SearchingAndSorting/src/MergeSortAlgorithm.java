import java.util.Arrays;

public class MergeSortAlgorithm {
	private static int[] array;
	static void mergesort(int[] array) {
		System.out.println("mergesort debut");
		int[] helper = new int[array.length];
		System.out.println("mergesort helper=" + Arrays.toString(helper));
		mergesort(array, helper, 0, array.length - 1);
	}

	static void mergesort(int[] array, int[] helper, int low, int high) {
		System.out.println("mergesort avec tableau helper, array=" + Arrays.toString(array) + 
				" helper=" + Arrays.toString(helper) + 
				" low=" + low + " high=" + high);

		if (low < high) {
			int middle = (low + high) / 2;
			System.out.println("mergesort middle=" + middle);
			mergesort(array, helper, low, middle); // sort left half 
			mergesort(array, helper, middle + 1, high); // sort right half
			merge(array, helper, low, middle, high); // merge them
		}
	}
	
	static void merge(int[] array, int[] helper, int low, int middle, int high) {
		System.out.println(" merge avec array=" + Arrays.toString(array) + 
				" helper=" + Arrays.toString(helper) + 
				" low=" + low + " middle=" + middle + " high=" + high);
		
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		System.out.println("Copie de array dans helper =" + Arrays.toString(helper));
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		/* Iterate through helper array, compare the left and right half, copying back
		 * the smaller element from the two halves into the original array */
		
		while (helperLeft <= middle && helperRight <= high) {
			if(helper[helperLeft] <= helper[helperRight]) { //if the left element is smaller than right one
				array[current] = helper[helperLeft];
				helperLeft++;
			}
			else { //if the right element is smaller than left one 
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		/* Copy the left rest of the left side  of the array into the target array */
		int remaining = middle - helperLeft;
		for (int i = 0; i < remaining; i ++) {
			array[current + i] = helper[helperLeft + i];
		}
		System.out.println("FIN MERGE array=" + Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		array = new int[] {1, 4, 5, 2, 8, 9};
		mergesort(array);
		System.out.println("FIN FINALE MERGE array=" + Arrays.toString(array));
	}
}

//Seuls les elements restant de la motiie de gauche sont copi�s dans le tableau cible car les elements du tableau de droite sont toujours l�
// Exemple : pour un tableau de type [1, 4, 5 || 2, 8, 9] ou || indique le point de partition.
// Les tableaux helper et target termineront avec [8,9].
// Apres avoir copi� les elements [1, 4 , 5 et 2] dans le tableau cible, le [8, 9] sera toujours en place dans les deux tableaux.
