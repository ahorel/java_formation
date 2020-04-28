

//Implémenter un algorithme de recherche depuis un tree node
//Cf https://www.geeksforgeeks.org/search-a-node-in-binary-tree/
//Utiliser la library tree node search cracking code interview
public class TreeNodeSearch {
	boolean isNodeExists(LinkedListNode node, int key) {
		while(node != null) {
			if(node.data == key)
			{
				return true;
			}
			node = node.next;
		}
		return false;
	}
}



 class Node2 {
	Node2 left,right;
	int data;
	int size;
	
	public Node2(int data) {
		this.data = data;
		this.left = right = null;
		int size = 1;
	}
	
	public void setChilds(int nextData, Node2 nextNode) {
		 
		this.data = nextData;
		
		if(nextData < this.data) {
			this.left = nextNode;
			setChilds(nextData, nextNode.left);
		}
		else if(nextData >= this.data) {
			this.right = nextNode;
			setChilds(nextData, nextNode.right);
		}
	}
}










class MainManualTreeNode{
	static class ManualTreeNode{
		ManualTreeNode left,right;
		int data;
		ManualTreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	public boolean isNodeExists(ManualTreeNode node, int key) {
		if(node == null) return false;
		if(node.data == key) return true;
		
		
			boolean res1 = isNodeExists(node.left,key);
			if(!res1) isNodeExists(node.right,key); 
			return res1;
		
	}
}

class GFG 
{ 
      
// Binary tree node  
static class Node  
{  
    int data;  
    Node left, right;  
    Node(int data)  
    {  
        this.data = data;  
        left = right = null;  
    }  
};  
  
// Function to traverse the tree in preorder  
// and check if the given node exists in it  
static boolean ifNodeExists( Node node, int key)  
{  
    if (node == null)  
        return false;  
  
    if (node.data == key)  
        return true;  
  
    // then recur on left sutree / 
    boolean res1 = ifNodeExists(node.left, key);  
    if(res1) return true; // node found, no need to look further 
  
    // node is not found in left, so recur on right subtree / 
    boolean res2 = ifNodeExists(node.right, key);  
  
    return res2;  
}  
  
// Driver Code  
public static void main(String args[]) 
{  
    Node root = new Node(0);  
    root.left = new Node(1);  
    root.left.left = new Node(3);  
    root.left.left.left = new Node(7);  
    root.left.right = new Node(4);  
    root.left.right.left = new Node(8);  
    root.left.right.right = new Node(9);  
    root.right = new Node(2);  
    root.right.left = new Node(5);  
    root.right.right = new Node(6);  
  
    int key = 4;  
  
    if (ifNodeExists(root, key))  
        System.out.println("YES");  
    else
        System.out.println("NO");  
} 
}  