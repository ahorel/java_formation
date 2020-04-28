
public class TreeNode {
	public int data;
	public TreeNode left, right, parent;
	private int size = 0;
	private static int iteration,iterationLeft,iterationRight = 0;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.insertInOrder(10);
		root.insertInOrder(4);
		root.insertInOrder(6);
		root.insertInOrder(2);
		root.insertInOrder(1);
		printTreeNode(root);
	}
	
	public TreeNode (int d) {
		data = d;
		size = 1;
	}
	
	public static void printTreeNode(TreeNode t) {
		
		if(t != null) {
			System.out.println("Niveau=" + iteration + " data =" + t.data);
		}
		if(t.left != null) {
			iterationLeft++;
			System.out.println("Niveau=" + iterationLeft + " left.data =" + t.left.data);
			printTreeNode(t.left);
		}
		if(t.right != null) {
			iterationRight++;
			System.out.println("Niveau=" + iterationRight + " right.data =" + t.right.data);
			printTreeNode(t.right);
		}
		iteration++;

	}
	
	public void printTreeLeftNode(TreeNode t) {
		System.out.println(t.left.data);
	}
	
	public void insertInOrder(int d) {
		if (d < data) {
			if(left == null) {
				setLeftChild(new TreeNode(d));
			}
			else {
				left.insertInOrder(d);
			}
		}
		else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			}
			else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	
	public int size() {return size;}
	
	public TreeNode find(int d) {
		if (d == data) {
			return this;
		}
		else if (d<= data) {
			return left != null ? left.find(d) : null;
		}
		else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	public void setLeftChild(TreeNode left) {
		this.left = left;
		if(parent == null) {
			this.parent = left;
		}
	}
	
	public void setRightChild(TreeNode right) {
		this.right = right;
		if(parent == null) {
			this.parent = right;
		}
	}
}