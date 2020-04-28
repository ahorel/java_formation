/*
 * Given a sorted array of n integers, that has been rotated in an unknown number of times, write code to find 
 * an element in the arra.
 * Note that the array has been rotated in an increasing order initially
 */
//ex : Input 15,16,17,18,25,1,3,5,7,10
//Output : 4 the index of 25

/*
 * Solution : utiliser la recherche binaire 
 * Dans une recherche binaire, on compare x avec le "midpoint" pour v�rifier que x appartient ou non � la partie de gauche ou la partie de droite
 * La complication ici est que le tableau a subi des rotations et donc il peut y avoir un point d'inflection
 * Avec l'exemple de ces deux tableaux : 
 * {10, 15, 20, 0, 5}
 * {50, 5, 20,30, 40}
 * Les deux tableaux ont un "midpoint" de 20 mais pour le tableau 1 l'�lement 5 se trouve � droite tandis que pour le tableau 2 l'�l�ment 5 se 
 * trouve � gauche . 
 * Par cons�quent, comparer x avec le midpoint est insuffisant
 * 
 *  Si on va plus loin, , On voit que la moiti� recherch�e du tableau doit �tre tri�e normalement dans un tri croissant. On peut donc voir dans la moiti� normalement
 *  tri�e pour d�terminer si on cherche dans la moiti� de gauche ou de droite 
 *  
 *  Par exemple, si nous cherchons 5 dans le tableau 1 et que nous recherchons � partir de l'�l�ment de gauche (10) et du midpoint 20, 
 *  on constate qu'il va falloir ordonner la partie de gauche (car 10 < 20)  et puisque 5 n'est pas dans la partie de gauche, il va falloir chercher
 *  dans la partie de droite.
 *  
 *  Dans le tableau 2 , on peut voir que puisque 50 > 20, la partie de droite doit �tre tri�e normalement.
 *  On se positionne au milieu (mid point) (20) et on prend l'�l�ment de droite (40) et on v�rifie si l'element recherch� n'est pas dans ce segment.
 *  L'�l�ment 5 n'y est pas, il faudra donc rechercher dans la partie de gauche.
 *  
 *  La condition epineuse est si l'�l�ment de gauche et le midpoint sont identiques comme dans le tableau 
 *  {2 ,2 ,2 ,3 ,4 ,2}
 *  Dans ce cas, on peut verifier que l'element tout � droite est diff�rent, 
 *  Si c'est le cas, dans ce cas on effectue la recherche dans la partie de droite
 *  Si ca n'est pas le cas, on effectue la recherche dans les deux moiti�s
 */
public class Q2_SearchRotatedArray {

	static int search(int[] a, int left, int right, int x) {
		int mid = (left + right)/2;
		if(left > right) {
			System.out.println("On passe la left="+ left + " right=" + right);
			return -1;
		}
		if(a[mid] == x) {
			return mid;
		}
		
		/* La moitie de gauche ou de droite doit etre normalement tri�e,
		 * Rechercher quelle moiti� est normalement tri�e
		 * Et ensuite, utiliser la partie normalement tri�e pour effectuer la recherche sur x
		 */
		if(a[left] < a[mid]) { // La moitie de gauche est normalement tri�e
			if(x >= a[left] && x < a[mid]) {
				return search(a,left, mid -1, x); // Recherche de gauche
			}
			else {
				return search(a, mid + 1, right, x); // Recherche de droite
			}
		}
		else if (a[mid] < a[left]) { // La moiti� de droite est normalement tri�e
			if(x > a[mid] && x <= a[right]) {
				return search(a, mid + 1, right, x); // Recherche de droite
			}
			else {
				return search(a, left, mid-1,x); // Recherche de gauche
			}
		}
		else if(a[left] == a[mid]) { // L'element de gauche est �gal au midpoint
			if(a[mid] != a[right]) { // L'element de droite est diff�rent du mid point
				return search(a, mid + 1, right, x); // Recherche � droite
			}
			else { // Autrement, on doit rechercher dans les deux moiti�s
				int result = search(a, left, mid - 1, x); // Recherche de gauche
				if(result == -1) {
					return search(a, mid + 1, right, x); // Recherche de droite;
				}
				else {
					return result;
				}
			}
		}
		System.out.println("on passe ici");
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {5,15,20,0,10};
		int res = search(a, 0, 4, 1);
		System.out.println(res);
	}
}

/*
 * Ce code aura une compl�xit� o(n*log(n)) si tous les elements sont uniques
 * Avec des dupliqu�s, ce code a une complexit� o(n)
*/