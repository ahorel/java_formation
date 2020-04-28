/*
 * Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a given string 
 * Example : input ball in array {"at","","","ball","point","","",""} Output : 4
 * 
 * S'il n'y avait pas de empty strings, on pourrait utiliser la recherche binaire 
 * Avec des empty strings, on puet implémenter une simple modification de la recherche binaire 
 * Lors de la comparaison par rapport a mid, si mid est vide, on le bouge a cote de l'element non vide le plus pres 
 */
public class Q3_SpareSearch {
	int search(String[] strings, String str, int first, int last) {
		if(last < first) {return -1;}
		int mid = ( first + last ) / 2;

		//If mid is  empty, find the closest empty strings
		if((strings[mid]).isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if(left < first && right > last) {
					return -1;
				}
				else if (right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				}
				else if (left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}	
			//Search it recursively to find the string in array
			if(str.equals(strings[mid])) {
				return mid;
			}
			else if (strings[mid].compareTo(str) < 0) { // Search right
				return search(strings, str, mid + 1, last);
			}
			else { // Search left
				return search(strings, str, first, mid - 1);
			}
		}
		
		int search(String[] strings, String str) {
			if(str=="" || str.isEmpty() || strings == null) {
				return -1;
			}
			else {
				return search(strings, str, 0, strings.length - 1);
			}
		}
}

/*
 * Complexité O(n) dans le pire des cas
 * Impossible d'avoir un meilleur algorigthme en terme de complexité. Si le tableau ne possède que des elements vides, sauf pour 
 * un element, alors il sera nécessaire de regarder chaque element du tableau.
 * 
 * Débattre avec l'interviewer sur la manière de gérer le string empty, doit on le considérer comme une erreur ou on doit recherche la localisation de cette mpty 
 * string qui est une O(n) itération
 */
