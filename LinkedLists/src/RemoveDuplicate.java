import java.util.HashSet;
import java.util.LinkedList;

// Cr�er une linkedList qui remplace les duplicate 
// It�rer dans la linked list  et ajouter des elements dans une hash table 
//Si on trouve un element dupliqu�, on le retire et on continue d'it�rer
//On peut faire ca en une seule fois puisqu'on utilise une linked list

//Complexit� O(n)
public class RemoveDuplicate {

	void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while(n != null) {
			if(set.contains(n.data)) {
				previous.next = n.next;
			}
			else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	//Solution 2 : it�rer avec deux pointers 
	//Le 1er parcourt la linkedlist
	//Le 2eme : le runner verifie les noeuds sous jacents pour les dupliqu�s
	
	//Complexit� O(1) space mais 0(n�) time
	void deleteDups_solution2(LinkedListNode head) {
		LinkedListNode current = head;
		while(current != null) {
			//On supprime les noeuds futures qui ont la m�me valeur
			LinkedListNode runner = current;
			while(runner.next != null) {
				if(runner.next.data ==current.data) {
					runner.next = runner.next.next;
				}
			}
		}
	}

}
