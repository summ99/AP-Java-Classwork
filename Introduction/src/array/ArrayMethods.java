package array;

public class ArrayMethods {

	public static void main(String[] args) {
		int arr[] = {2,3,4,6,9,11,12,15};
		
		swap(arr, 0,arr.length-1);
		
		shuffle(arr);
		
		if(checkHalfway(arr,12,0,arr.length));
		{
			System.out.println("The number is less than the value in the middle of the array");
		}

	}

	private static void shuffle(int[] arr) {
		for(int i=0; i<arr.length;i++)
		{
			int rand =(int) (Math.random()*arr.length)+1;
			swap(arr,i,rand);
		}
		 
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
		
	}
	
	private static boolean checkHalfway(int[] arr, int searchValue, int begin, int end) {
		// returns true if searchValue is less than element halfway between beginning and end
		
			return searchValue<arr[begin+end+1]/2;
		
	}

}
