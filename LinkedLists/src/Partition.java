/*
 * Créer une partition d'une linkedList, tous les noeuds dont la valeur est inférieur à la partition sont placés en tête de liste
 * Tous les noeuds dont la valeur est supérieure à la partition sont placés en fin de liste
 * La position de la partition n'a pas d'importance
 * 
 * Attention : le déplacement d'élements dans une Array est très couteux
 * Avec les linked list : on crée deux linked list, une pour les elements < partition et une pour les elements > ou = à la partition
 * On itere dans la linked list initiale et on ajoute des elements dans la liste pour les elements avant et les elements apres
 * Quand on a finit de parcourire la liste initial, on merge les deux listes 
 */
public class Partition {
	LinkedListNode partition(LinkedListNode node, int partitionValue) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterEnd = null;
		
		//Partition List
		while(node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if(node.data<partitionValue) {
				//Insert node into end of before list
				if(beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				}
				else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}
			else {
				//Insert node into end of after list
				if(afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				}
				else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
			if(beforeStart == null) {
				return afterStart;
			}
			//Merge before list and after list 
				beforeEnd.next = afterStart;
				return beforeStart;
			
		}
	
	LinkedListNode partition_resume(LinkedListNode node, int x) {
		LinkedListNode tail = node;
		LinkedListNode head = node;
		
		while(node!=null) {
			LinkedListNode next = node.next;
			if(node.data < x) {
				//Insert node at head
				node.next = node;
				node = head;
			} else {
				//Insert node at tail
				tail.next = node;
				tail = node;
			}
			tail.next = null;
			
		}

		//The head has changed so we return it to the user
		return head;
	}
}

