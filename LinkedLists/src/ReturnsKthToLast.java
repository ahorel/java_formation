
//Implémenter un algorithme qui retourne du Kieme au dernier element d'une linked list 

/*
 * Solution recursive : plus propre mais plus coûteuse en complexité temps/espace : O(n) où n est le nombre d'elements 
 * De la linked list
 * K est defini tel que si k = 1 : retourne le dernier element 
 * K=2 retourne du 2eme au dernier element et ainsi de suite
 */

/*
 * Solution 1
 * Si la taille de la liste est sue : il suffit de parcourir la liste de manière itérative et le Kieme au dernier elements est le (length - K)ième 
 * element 
 */

/*
 * Solution 2 : recursive
 * L'algorithme parcourt la linkedlist jusqu'à la fin. 
 * Arrivé à la fin, Un compteur est alors utilisé , mis à 0. Chaque appel parent ajoute 1 au compteur. Quand le compteur est égal à K, on sait qu'on
 * a paroucru la liste du dernier au kième element.
 */
	/* 
	 * Pour cette solution, on retourne un entier car on ne peut passer en valeur de retour un noeud et un compteur
	 */
public class ReturnsKthToLast_solution2_A {

	int printKthToLastElt(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		else {
			int index = printKthToLastElt(head.next, k) + 1;
			if (index == k) {
				System.out.println(k + "ieme au dernier element est " + head.data);
			}
			return index;
			
		}
	}
}
	/*
	 * Pour cette solution, on utilise une classe wrapper pour retourner le noeud et le compteur
	 */

class Index{
	public int value = 0;
}

public class ReturnsKthToLast_solution2_B {
	LinkedListNode printKthToLastElt(LinkedListNode head, int k) {
		Index idx = new Index();
		return printKthToLastElt(head,k,idx);
	}
	
	LinkedListNode printKthToLastElt(LinkedListNode head,int k, Index idx) {
		if (head == null) {
			return null;
		}
		else {
			LinkedListNode node = printKthToLastElt(head.next, k, idx);
			idx.value = idx.value + 1;
			if (idx.value == k) {
				System.out.println(k + "ieme au dernier element est " + head.data);
			}
			return node;
			
		}
	}
	
	/*
	 * Solution 3 : Utiliser deux pointeurs dans la liste.
	 * On bouge le pointeur p1 de K noeuds dans la liste
	 * On laisse le pointeur p2 au début de la liste
	 * Apres, on bouge p1 et p2 au meme rythme: p1 arrivera à la fin de la liste après LENTH - K noeuds et p2 se sera déplacé de LENTH - k noeuds
	 * ou k noeuds depuis la fin 
	 */
	
	//Complexité O(n) temps et O(1) space
	LinkedListNode printhKthToLastElt(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		for(int i = 0; i<k;i++) {
			p1 = p1.next;
		}
		//On bouge p1 et p2 au meme rythme, lorsque p1 sera à la fin de la liste, p2 sera au kieme element
		while(p1!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}