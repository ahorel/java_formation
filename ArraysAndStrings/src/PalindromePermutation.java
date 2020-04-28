/*
 * A partir d'une string ecrire une fonction permettant de dire si c'est une permutation de palindrome
 * Note : Un palindrome est un mot qui peut se lire en avant et en arrière
 * Besoin : avoir le meme nombre de caractère, la moitie pourra etre lu en avant et l'autre en arriere.
 * Seul le caractère au milieu pourra etre lu une seule fois
 * ex : tactcaopapa est un palindrome car 2t 4a 2p 2c et 1o
 * 
 * Pour les mots de caractères pairs : tous les caractères doivent etre pairs
 * Pour les mots de caractères impairs : ne doivent avoir qu'un seul caractère impair
 * 
 * Donc pour qu'une string soit une permutation d'un palindrome, elle ne peut avoir qu'un seul caractère qui est impair
 */

public class PalindromePermutation {
	//Solution 1
	boolean isPermutationOfPalindrome_solution1(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	//Check that no more one caractere has an odd count
	boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if(foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	//Map each caractere to a number a->0, b->1, c->2 ...
	//Non letter characters map to -1
	int getCharNumber(Character c) {
		int val = Character.getNumericValue(c);
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		if(val < z && val > a) {
			return val - a;
		}
		return -1;
	}
	
	//Count how many times each character appears
	int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x]++;
			}
		}
		return table;
	}
	
	//Solution 2
	boolean isPermutationOfPalindrome_solution2(String phrase) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if(x != -1) {
				table[x]++;
				if(table[x]%2 ==1) {
					countOdd++;
				}
				else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}
	
	//Solution 3
	/*
	 * pas besoin de compter le nombre de caractères, on a juste besoin de savoir si le décompte est pair ou impair.
	 * De cette manière, on peut utiliser un entier comme un Bit Vector. 
	 * Quand on voit une lettre, on la map à un entier entre 0 et 26. Ensuite on redirige le bit sur cette valeur.
	 * A la fin de l’itération, on verifie qu’au plus un bit dans l’entier est à 1
	 * On peut facilement vérifier qu’aucun bit dans l’entier n’est à 1 : comparer l’entier à 0

	 * Autre manière : Pour vérifier dans un entier qu’un bit est mis à 1 : 
	 * Pour un entier de type 00010000 si on soustrait 1 à cet entier = 00001111.
	 * Si ensuite on le AND avec l’entier original, on obtient 0 (00010000 & 00001111 = 0)
	 */
	
	boolean isPermutationOfPalindrome(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	//Create the bit vector pour la string. Pour chaque lettre avec une valeur i, la basculer sur le ième bit
	int createBitVector(String phrase) {
		int bitVector = 0;
		for(char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector,x);
		}
		return bitVector;
	}
	
	static //Toggle the ith bit in the Bit Vector
		//ex : bitVector = 1010, index = 1
	int toggle(int bitVector, int index) {
		//Avoir un bit vector avec le ième bit mis à 1 :
		String binaireBitVector = Integer.toBinaryString(bitVector);
		String binaireBitIndex = Integer.toBinaryString(index);
		System.out.println("bitVector=" + bitVector + " binaire BitVector=" + binaireBitVector +  " index=" + index + " binaire BitIndex=" + binaireBitIndex);
		int mask = 1 << index;
		//Ex mask = 10 (mis à 1 du 2eme bit)
		String binaireMask = Integer.toBinaryString(mask);
		String binaireBitVectorMask = Integer.toBinaryString((bitVector& mask));

		System.out.println("mask : le ieme bit est mis à 1 binaire mask=" + binaireMask);
		System.out.println("Condition (bitVector & mask)=" + (bitVector & mask) + " binaire (bitVector & mask)=" + binaireBitVectorMask);
		//Ex (bitVector & mask) = 10
		if ((bitVector & mask) == 0) {
			//Ajout d'un flag 
			bitVector |= mask;
			binaireBitVector = Integer.toBinaryString(bitVector);
			System.out.println("bitVector |= mask :" + bitVector + " binaire bitVector=" + binaireBitVector);
		}
		else {
			//Ajout d'un flag
			bitVector &= ~mask;
			binaireBitVector = Integer.toBinaryString(bitVector);
			System.out.println("bitVector &= mask :" + bitVector + " binaire bitVector=" + binaireBitVector);
		}
		return bitVector;
	}
	
	//Check that exactly one bit is set by substracting 1 depuis l'entier et ANDing it with the original integer
	boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}
	
	public static void main(String[] args) {
		toggle(10,1);
	}
}
