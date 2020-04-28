
public class CharacterHasUniqueKeys {

	//Complexit� O(n) d'espace o� n est la taille de la string
	//COmplexit� O(1) de temps si la taille du caract�re est fix�
	
	//Complxit� O(c) d'espace o� c est la taille de la string
	//Complexit� O(min(c,n)) en temps o� c est la taille de la string 
	public boolean isUniqueChars(String str) {
		if (str.length() > 128) return false;
		boolean[] char_set = new boolean[128];
		for ( int i =0; i < str.length();i++)
		{
			int val = str.charAt(i);
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	//Diviser la complexit� par 8 en utilisant un vecteur de bit
	//Si on utilise que des lower cases de a � z
	public boolean isUniqueChars_BitVector(String str) {
		int checker = 0;
		
		for ( int i =0; i < str.length();i++)
		{
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
}
