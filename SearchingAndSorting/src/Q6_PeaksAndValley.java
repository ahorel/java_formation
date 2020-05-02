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
}
