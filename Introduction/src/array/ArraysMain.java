package array;

public class ArraysMain {

	public static void main(String[] args) {
		//this is how u time how quickly a computer processes
		long startTime = System.currentTimeMillis();
		String [] someStrings = new String[100];
		populateArray(someStrings);
		changeString(someStrings[99]);
		printArray(someStrings);
		long endTime = System.currentTimeMillis();
		System.out.println("Completed method in " + (endTime-startTime)+ " miliseconds");
		
	}
	private static void changeString(String s) {
		//pass by value = 
		s = "this string has been changed";
		
	}
	private static void printArray(String[] someStrings) {
	
		for(String s:someStrings)
		{
			System.out.println(s);
		}
	}
	private static void populateArray(String[] someStrings) {
		
		for(int index=0; index < someStrings.length; index++)
				{
					someStrings[index]="value"+(index+1);
				}
	}
	public static void arrayIntroMethod()
	{
		//construct 3 int arrays
				//these do the same thing; primitive type arrays fill with zeros,false
				int[] zeros1 = {0,0,0};
				int[] zeros2 = new int[3];
				//these are different
				String[] strings = {"","",""};
				String[] strings2 = new String[3];
				//instantiating the array with values
				for(int index=0; index < strings2.length; index++)
				{
					strings2[index]="value"+(index+1);
				}
				for(String s:strings2)
				{
					System.out.println(s);
				}
				//
				boolean [] booleans = new boolean[3];
				//iterate thru array
				//when to use FOR loop
				//-when the index of the data is important to reference
				//-when u need to customize how u iterate
				//-example:increase by 2, go backwards, etc.
				for(int i =0; i<booleans.length; i++)
				{
					System.out.println(i+") "+booleans[i]);
				}
				//when to use FOREACH loop("for each boolean in booleans")
				//-always goes in order
				//-does not keep track of index but is easier to type
				//puts a handle on the array
				for (boolean b:booleans)
				{
					System.out.println("" +b);
				}
	}

}
