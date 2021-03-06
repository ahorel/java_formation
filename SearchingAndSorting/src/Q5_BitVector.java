import java.util.Arrays;

public class Q5_BitVector {
		int[] bitset;
		
		public Q5_BitVector(int size) {
			int a = (size >> 5) + 1;
			bitset = new int[(size >> 5) + 1 ]; // Divide by 32
												// d�cale les bits de size de 5 positions de la gauche vers la droite 
			System.out.println("[Constructeur BitVector] (size)=" + size + "size=" + Integer.toBinaryString(size) + "(size>>5) + 1= " + a + " (size >> 5)=" + Integer.toBinaryString((size >> 5)));
			//System.out.println("[Constructeur BitVector] bitset=" + Arrays.toString(bitset));
		}
		
		public void set(int pos) {
			int wordNumbers = (pos >> 5); // Divide by 32
										  // Les 5 bits de gauche sont � 1
			int bitNumbers = (pos & 0x1F); // Mod 32
			System.out.println("[set] wordNumbers=" + Integer.toBinaryString(wordNumbers) + " bitNumbers=" + Integer.toBinaryString(bitNumbers));

			System.out.println("[set] Avant set bitset[wordNumbers]=" + Integer.toBinaryString(bitset[wordNumbers]));

			bitset[wordNumbers] |= 1 << bitNumbers; // Le bit � l'index BitNumbers est tourn� � 
			//System.out.println("[set] bitset[wordNumbers]=" + Arrays.toString(bitset));
			System.out.println("[set] Apres set bitset[wordNumbers]=" + Integer.toBinaryString(bitset[wordNumbers]));
		}
		
		public boolean get(int pos) {
			int wordNumbers = (pos >> 5); // Divide by 32
			int bitNumber = (pos & 0x1F);
			
			System.out.println("[get]  pos=" + Integer.toBinaryString(pos) + " 	wordNumbers=" + Integer.toBinaryString(wordNumbers) + " bitNumber=" + Integer.toBinaryString(bitNumber));
			//System.out.println("[get] bitset=" + Arrays.toString(bitset) + " bitset[wordNumbers]=" + Integer.toBinaryString(bitset[wordNumbers]) + " (1 << bitNumber)=" + Integer.toBinaryString((1 << bitNumber)));
			System.out.println("[get]  bitset[wordNumbers]=" + Integer.toBinaryString(bitset[wordNumbers]) + " (1 << bitNumber)=" + Integer.toBinaryString((1 << bitNumber)));
			
			return (bitset[wordNumbers] & (1 << bitNumber)) != 0;

		}
	}