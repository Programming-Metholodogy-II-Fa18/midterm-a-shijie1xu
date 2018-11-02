package midterm1_problem1;

// in this problem I will use merge sort
public class sorting {
	
	public static void main(String[] args){
		int[] a = {15,9,60,44,12,1,4};
		int size = a.length;
		int[] result = merge_sort(a,size);
		System.out.println("Sorted array is:");
		for(int i = 0; i < size; i++){
			System.out.print(result[i] + " ");
		}
	}
	
	
	public static int[] merge_sort(int[] a, int size){
		int[] result = new int[size];
		
		merge_sort_recursive(a, result, 0, size-1);
		
		return result;
	}
	
	public static void merge_sort_recursive(int[] arr, int[] result, int start, int end){
		if(start == end){
			return;
		}
		int mid = (start+end)/2;
		int start1 = start;
		int end1 = mid;
		int start2 = mid+1;
		int end2 = end;
		int k = start;
		
		

		merge_sort_recursive(arr, result, start1, end1);
		merge_sort_recursive(arr, result, start2, end2);
		


		
		while(start1 <= end1 && start2 <= end2){
			if(arr[start1] < arr[start2]){
				result[k] = arr[start1];
				k++;
				start1++;
			}else{
				result[k] = arr[start2];
				k++;
				start2++;
			}
		}
		while(start1<= end1){
			result[k] = arr[start1];
			k++;
			start1++;
		}
		
		while(start2 <= end2){
			result[k] = arr[start2];
			k++;
			start2++;
		}
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = result[i];
		}
		
	}
}
