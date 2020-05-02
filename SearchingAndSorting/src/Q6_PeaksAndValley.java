import java.util.Arrays;

/*
 * 
 
Enoncé : 
  
Dans un tableau d'entier, récupérer un element qui est plus grand égal à l'entier adjacent
et une valley qui est plus petite ou égal à l'entier adjacent.
Par exemple : Dans le tableau [5,8,6,2,3,4,6], [8,6] sont des pics et [5,2] sont des vallées
Dans un tableau d'entier, trier le tableau en une séquence alternante de pics et de vallées 
  [INPUT] [5,3,1,2,3]
  [OUTPUT] [5,1,3,2,3]

Solution non optimale

1-	Trier le tableau dans un tri ascendant ou descendant
2-	Arranger ensuite le tableau dans une séquence alternée de pics et vallées

1-	Après l’étape 1, un tableau trié apparaîtra de la manière suivante : 
0 1 4 7 8 9
2-	Pour l’étape 2 : 
a.	0 est ok
b.	1 est à la mauvaise place, on le swap avec le 0 ou le 4, on les wap avec le 0 
1 0 4 7 8 9
c.	.4 est ok 
d.	7 est à la mauvaise place, on le swap soit avec le 4 ou le 8, on choisit le 4
1 0 7 4 8 9
e.	9 est à la mauvaise place, on le swap avec le 8
1 0 7 4 9 8

Le tableau initial ne possédant pas de configuration particulière, on peut donc utiliser cette approche sur tout type de tri de tableau

Détail de l’algorithme : 

1-	Trier le tableau dans un ordre ascendant
2-	Itérer sur les éléments, en parant de l’index 1 avec un pas de 2
3-	Sur chaque éléments, effectuer un swap à partir de la configuration small => medium => large, obtenu avec le tri ascendant, pour obtenir la configuration medium => small => large
*
* Compléxité o(n(log(n)))
*/

public class Q6_PeaksAndValley {
	public void sortValleyPeak(int[] array) {
		Arrays.sort(array);
		
		for (int i = 1; i <= array.length;i+=2) {
			swap(array,i-1,i);
		}
	}
	public void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}


	//Solution Optimale 
	/*
	-	Il faut supprimer l’étape initiale de tri.
	-	Algorithme réalisé sur un tableau non trié : 
	9 1 0 4 8 7
	-	Pour chaque éléments, on regarde les éléments adjacents. Leur valeur n’a pas d’importance.
	0 1 2         -> 0 2 1
	0 2 1 // pic
	1 0 2         -> 1 2 0
	1 2 0 // pic
	2 1 0         -> 1 2 0
	2 0 1         -> 0 2 1
	Si l’élément central a besoin d’être un pic, alors deux de ces séquences fonctionnent.
	Peux t on fixer les autres séquences pour que l’élément central soit un pic ?
		En swappant l’élément central avec le plus grand des éléments adjacents
	
	Attention : Est il possible qu’un de ces swaps puisse casser une partie de la séquence déjà réalisée ? Non car si nous swappons middle avec left, alors left est alors une valley et midle sera alors plus petit que left, étant déjà une valley
	*/
	void sortValleyPeak_Optimale(int[] array) {
		for (int i = 1; 1 < array.length; i+=2) {
			int biggestIndex = maxIndex(array, i - 1, i, i + 1);
			if (i != biggestIndex) {
				swap(array,i,biggestIndex);
			}
		}
	}
	
	int maxIndex(int[] array, int a, int b, int c) {
		int len = array.length;
		int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
		int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
		int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;
		
		int max = Math.max(aValue, Math.max(bValue, cValue));
		if (aValue == max) return a;
		else if (bValue == max) return b;
		else return c;
	}
}