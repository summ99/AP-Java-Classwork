package array;

public class ArrayMethods {

	public static void main(String[] args) {
		int [] array1 = {2,3,4,6,9,11,12,15};
		int [] array2 = {7,9,3,4,6,9,11,8,1};
		//int [] intArray  = {3,9,6,11,14,16};
		//int [] subArray = {1,98};
		longestSharedSequence(array1,array2);
		//printArr(subArray);
		//contains(intArray,subArray);
		
		
		//countUnderBound(array, 2,);
		//printArr(array);
		//swap(arr, 0,arr.length-1);
		
		//shuffle(arr);
		
		//if(checkHalfway(arr,12,0,arr.length));
		//{
		//	System.out.println("The number is less than the value in the middle of the array");
		//}

	}
	private static void printArr(int [] array)
	{
		for(int i:array)
		{
			System.out.println(i);
		}
	}
	/*private static void shuffle(int[] arr) {
		for(int i=0; i<arr.length;i++)
		{
			int rand =(int) (Math.random()*arr.length)+1;
			swap(arr,i,rand);
		}
		 
	}*/

	/*private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
		
	}*/
	public static int countUnderBound(double [] arr, double d)
	{
		//returns number of elements in arr less than d
		//for median, array.length/2 -1 and array.length/2;
		int numLessD =0;
		for(int i =0; i<arr.length; i++)
		{
			if(arr[i]<d)
			{
				numLessD++;
			}
		}
		System.out.println(numLessD);
		return numLessD;
	}
	public static void cycleOnce(int [] arr)
    {
        int itemSwapped = 0;
        int item2Swapped = arr.length-1;
        for(int i =0; i<arr.length; i++)
        {
            arr[itemSwapped] = arr[item2Swapped];
            item2Swapped++;
        }
    }
	/*private static boolean checkHalfway(int[] arr, int searchValue, int begin, int end) {
		// returns true if searchValue is less than element halfway between beginning and end
		
			return searchValue<(arr[begin+end+1]/2);
		
	}*/
	public static int [] getSubArray (int[] arr, int startIndex,int endIndex)
	{
		int [] subArray = new int [endIndex-startIndex +1];
		for(int i = 0; i<subArray.length; i++)
		{
			subArray[i]=arr[startIndex+i];
		}
		return subArray;
	}
	public static boolean contains(int [] arr,int[] subArr)
	{
		for(int i =0; i<arr.length;i++)
		{
			int j = 0;
				while(j<subArr.length)
				{
					if(subArr[j] == arr[i+j] && j==subArr.length-1)
					{
						System.out.println("true");
						return true;
					}
					else if(subArr[j]!=arr[i+j])
					{
						break;
					}
					j++;
				}
		}
		return false;
	}

	public static int longestSharedSequence(int[] array1, int[] array2){
        /**This method counts the longest unbroken, shared sequence in TWO arrays.
         * The sequence does NOT have to be a consecutive sequence
         * It does NOT matter where the sequence begins, the arrays might not be the same length
         * 
         * Examples:
         * longestSequence({9,6,3,4,3,8,9}, {9,6,3,4,3,6,7}) returns '5', since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long 
         * longestSequence({0,9,6,3,4,3,8,9}, {1,2,9,6,3,4,3,6,7}) returns '5', 
         *          since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long, it doesn't matter that the sequence begins at different indices 
         * longestSequence({9,6,1,4,3,6,7,9}, {9,6,5,8,3,6,7,0}) returns '3', since the sequence '3,6,7' is in both arrays and is 3 integers long
         * */ 
        int numsShared =0;
        for(int i =0; i<array1.length;i++)
		{
				if()
				{
					numsShared++;
				}	
        	
        System.out.println(numsShared);
        return numsShared;
    }
}
