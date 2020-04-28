
public class CheckPermutation {
	//I.
	// Deux strings de diff�rentes tailles ne peuvent pas �tre des permutations
	// Permutation ne prenant pas en compte la casse"
	String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	boolean permute(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	//II.
	//On it�re sur chacune des deux strings , 
	//On comppte combien de fois chaque caract�re apparait dans chaque string 
	//et on compare les deux tableaux 
	 static boolean permute_countNumberCaracters(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[128]; //assumption
		char[] s_array = s.toCharArray();
		
		//Conversion automatique des char sous formes d'entiers dans le tableau letters
		for(char c : s_array) {
			System.out.println("char c=" + c);
			letters[c]++;
			System.out.println("letters[c]=" + letters[c]);
		}
		
		//Parcours de la chaine de caract�re t et conversion sous forme d'entiers
		//L'index trouv� via ce parcours est ensuite utilis� pour d�cr�menter la valeur li�e � cet index dans le tableau initial
		//Si la valeur est inf�rieure � 0, le tableau 2 n'est pas une permutation du tableau 1
		
		for(int i = 0; i < t.length();i++) {
			int c = (int) t.charAt(i);
			System.out.println(" c=" + c);
			letters[c]--;
			System.out.println(" letters[c]=" + letters[c]);
			if(letters[c] <0)
			{
				return false;
			}
		}
		return true;
		
	}
	 
	 public static void main(String[] args) {
		 permute_countNumberCaracters("abcd","dcbe");
	 }
}
