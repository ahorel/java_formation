// Relatif a Q4_RankNodeFromStream
public class RankNode {
		public RankNode left, right;
		public int data = 0;
		public int left_size = 0;
		
		public RankNode(int d) {
			data = d;
		}
		
		public void insert(int d) {
			if(d <= data) { // d <= data, on ins�re � gauche
				if (left != null) {
					left.insert(d);
				}
				else left = new RankNode(d);
				left_size++;
			}
			else { // d > data, on ins�re � droite
				if(right != null) {
					right.insert(d);
				}
				else right = new RankNode(d);					
			}
		}
		
		public int getRank(int d) {
			System.out.println("d =" + d + " left_size=" + left_size);
			if (d == data) { // La donn�e d == � la valeur du noeud, le rang est donc celui du compteur
				return left_size;
			}
			else if (d < data) { // La donn�e � ins�rer est < � la valeur du noeud, le rang ne change pas par rapport � celui de gauche 
				if(left == null) return -1;
				else return left.getRank(d);
			}
			else { // La donn�e d � ins�rer est > valeur du noeud, le rang de droite est incr�ment� de 1 par rapport au rang du noeud de gauche
				int right_rank = right == null ? -1 : right.getRank(d);
				if(right_rank == -1) return -1;
				else return left_size + 1 + right_rank;
			}
		}		
	}	