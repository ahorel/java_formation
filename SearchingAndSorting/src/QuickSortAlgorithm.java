import java.util.*;
public class QuickSortAlgorithm {

	static void quickSort(int[] arr, int left, int right) {
		System.out.println("quickSort début arr=" + Arrays.toString(arr) + " left=" + left + " right=" + right);
		int index = partition(arr, left, right);
		if(left < index - 1) { //partition left half
			int ind = index - 1;
			System.out.println("partition left half arr=" + Arrays.toString(arr) + " left=" + left + " index - 1=" + ind);
			quickSort(arr, left, index - 1);
		}
		if (right > index) { // partition right half
			System.out.println("partition right half arr=" + Arrays.toString(arr) + " index=" + index + " right=" + right);

			quickSort(arr, index, right);
		}
	}
	
	static int partition (int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		System.out.println("partition pivot=" + pivot);
		while (left <= right) {
			//Find element on left that should be on right
			while (arr[left] > pivot) {
				left++;
			}
			
			while (arr[right] < pivot) {
				//Find elements on right that should be on left
				right--;
			}
			//Swap elements and move left and right indices
			if(left <= right){
				System.out.println("arr=" + Arrays.toString(arr) + " left=" + left + " right=" + right);
				swap(	arr,left,right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,4,2,8,5,9};
		quickSort(arr,0, arr.length - 1);
	}

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
