package array;

public class ArraysMain {

	public static void main(String[] args) {
		//construct 3 int arrays
		//these do the same thing; primitive type arrays fill with zeros,false
		int[] zeros1 = {0,0,0};
		int[] zeros2 = new int[3];
		//these are different
		String[] strings = {"","",""};
		String[] strings2 = new String[3];
		//
		boolean [] booleans = new boolean[3];
		//iterate thru array
		//when to use for loop
		//-when the index of the data is important to reference
		//-when u need to customize how u iterate
		//-example:increase by 2, go backwards, etc.
		for(int i =0; i<booleans.length; i++)
		{
			System.out.println(i+") "+booleans[i]);
		}
		//when to use foreach loop("for each boolean in booleans")
		//-always goes in order
		//-does not keep track of index but is easier to type
		for (boolean b:booleans){
			System.out.println("" +b);
			
		}
	}

}
