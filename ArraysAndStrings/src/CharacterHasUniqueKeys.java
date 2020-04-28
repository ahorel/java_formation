
public class CharacterHasUniqueKeys {

	//Complexité O(n) d'espace où n est la taille de la string
	//COmplexité O(1) de temps si la taille du caractère est fixé
	
	//Complxité O(c) d'espace où c est la taille de la string
	//Complexité O(min(c,n)) en temps où c est la taille de la string 
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
	
	//Diviser la complexité par 8 en utilisant un vecteur de bit
	//Si on utilise que des lower cases de a à z
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
