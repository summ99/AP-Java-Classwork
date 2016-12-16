package array;

import java.util.Arrays;

public class Print2dArrayWarmUp {
	private static boolean[][] arr2d;
	//TestReview
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arr2d = new boolean[5][5];
		printGrid(arr2d);
	    buttonClick(3,3);
	    printGrid(arr2d);
	    buttonClick(3,3);
	    printGrid(arr2d);
	}
	public static void switchRow(boolean [] row, int x)
	{
		if(x>=0 && x<row.length)
		{
			for(int i =-1; i<2; i++)
			{
				if(x+i>=0 && x+i<row.length)
				{
					row[x+i] = !row[x+i];
				}
			}
		}
	}
	
	 private static void switchColumn(boolean[][] arr2d2, int r, int c) {
		  	switchIfValid(arr2d,r-1,c);
	      	switchIfValid(arr2d,r+1,c);
	    
	  }
	  
	  public static void switchIfValid(boolean[][]grid, int r, int c){
	    if(r>=0 && r < grid.length && c >= 0 && c < grid[r].length){
	     grid[r][c] = !grid[r][c]; 
	    }
	  }
	 public static void buttonClick(int r, int c){
		   if(r>=0 && r < arr2d.length) switchRow(arr2d[r],c);//not on rubric;
		    switchColumn(arr2d,r,c);//one point
		    //check if any lights are on
		    //iterate thru 2darray 
		    for(int row = 0; row < arr2d.length; row++){
		      for(int col = 0 ; col < arr2d[row].length; col++){
		       if(arr2d[row][col]) return; 
		      }
		    }
		    System.out.println("You won!");
		  }
	public static void printGrid(boolean [][] arr){
		    for(boolean[] row: arr2d){
		      for(boolean b: row){
		      	if(b)System.out.print("O");
		        else System.out.print("X");
		      }
		      System.out.print("\n");
		    }
		    System.out.println("- - - - - - - - - - ");
		  }
}
