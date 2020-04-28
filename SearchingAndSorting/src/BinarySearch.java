
public class BinarySearch {

	static int binarySearch(int[] array, int x)
	{
		int low = 0;
		int high = array.length -1;
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			if(array[mid] < x) {
				low = mid + 1;
			}
			else if (array[mid] > x) {
				high = mid - 1;
			}
			else {
				mid = x;
			}
			return mid;
		}
		return -1;
	}
	
	static int binarySearchRecursive(int[] array, int x, int low, int high) {
		System.out.println(" binarySearchRecursive debut");
		if (low > high) return -1; //Error

		int mid = (low + high) / 2;
		System.out.println(" binarySearchRecursive mid=" + mid);
		
		if(array[mid] < x) return binarySearchRecursive (array, x, mid + 1, high);
		else if(array[mid] > x) return binarySearchRecursive (array,x, low, mid - 1);
		else return mid;
	}
	
	public static void main (String[] args) {
		int[] array = {1,4,2,5,9};
		//binarySearchRecursive(array,2,1,4);
		binarySearch(array,4);
	}
	
}
