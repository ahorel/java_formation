import java.util.Arrays;

/*
 * 
 
Enonc� : 
  
Dans un tableau d'entier, r�cup�rer un element qui est plus grand �gal � l'entier adjacent
et une valley qui est plus petite ou �gal � l'entier adjacent.
Par exemple : Dans le tableau [5,8,6,2,3,4,6], [8,6] sont des pics et [5,2] sont des vall�es
Dans un tableau d'entier, trier le tableau en une s�quence alternante de pics et de vall�es 
  [INPUT] [5,3,1,2,3]
  [OUTPUT] [5,1,3,2,3]

Solution non optimale

1-	Trier le tableau dans un tri ascendant ou descendant
2-	Arranger ensuite le tableau dans une s�quence altern�e de pics et vall�es

1-	Apr�s l��tape 1, un tableau tri� appara�tra de la mani�re suivante : 
0 1 4 7 8 9
2-	Pour l��tape 2 : 
a.	0 est ok
b.	1 est � la mauvaise place, on le swap avec le 0 ou le 4, on les wap avec le 0 
1 0 4 7 8 9
c.	.4 est ok 
d.	7 est � la mauvaise place, on le swap soit avec le 4 ou le 8, on choisit le 4
1 0 7 4 8 9
e.	9 est � la mauvaise place, on le swap avec le 8
1 0 7 4 9 8

Le tableau initial ne poss�dant pas de configuration particuli�re, on peut donc utiliser cette approche sur tout type de tri de tableau

D�tail de l�algorithme : 

1-	Trier le tableau dans un ordre ascendant
2-	It�rer sur les �l�ments, en parant de l�index 1 avec un pas de 2
3-	Sur chaque �l�ments, effectuer un swap � partir de la configuration small => medium => large, obtenu avec le tri ascendant, pour obtenir la configuration medium => small => large
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
