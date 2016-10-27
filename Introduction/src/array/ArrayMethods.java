package array;

public class ArrayMethods {

	public static void main(String[] args) {
		int [] array1 = {2,3,4,6,9,11,12,15};
		int [] array2 = {7,9,3,4,6,9,11,8,1};
		//int [] intArray  = {3,9,6,11,14,16};
		//int [] subArray = {1,98};
		testPrime();
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
	private static void testPrime(int numToTest) {
		// TODO Auto-generated method stub
		int lastToCheck = (int)(Math.sqrt(numToTest));
		boolean [] nums = new boolean [numToTest];
		for(int i =0; i<numToTest;i++)
		{
			nums[i]=true;
		}
		nums[0] = false;
		nums[1] = false;
		int incr = 2;
		boolean first = true;
		for(int test =2; test<= numToTest; test = test+incr)
		{
			
			if(first)
			{
				nums[test] = false;
			}
			else
			{
				first = false;
			}
		}
	
	for(int i =0; i<nums.length;i++)
	{
		if(nums[i]= true)
		{
			System.out.println(i + " is prime");
		}
	}
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
	public static int getIndex(int[] arrayToSearch, int key){
	    /**
	     * this method take an unsorted int array (arrayToSearch) and returns an 
	     * int corresponding to the index of a key, if it is in the array
	     * if the key is not in the array, this method returns -1
	     * */
	        for(int index=0; index<arrayToSearch.length; index++)
	        {
	            if(arrayToSearch[index] == key)
	            {
	                return index;
	            }
	        }  
	        return -1;
	    }
	/*public static int [] popArrRandomly(int [] arr)
	{
		int [] randArr = new int [arr.length-1];
		for(int r =0; r<randArr.length; r++)
		{
			int toAdd = arr[(int)Math.random()*arr.length];
			while (getIndex(randArr,toAdd)>-1)
			{
				toAdd = arr[(int)Math.random()*arr.length];
			}
		randArr[r] = toAdd;}
		return randArr;
		
	}*/
	
}
