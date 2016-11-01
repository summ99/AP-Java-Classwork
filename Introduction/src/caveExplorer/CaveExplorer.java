package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom caves[][];
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	
	public static void main(String[] args) {
		caves = new CaveRoom[5][5];
		for(int row =0; row<caves.length; row++)
		{
			for(int col =0; col<caves[row].length; col++)
			{
				caves[row][col] = new CaveRoom("This is " +row + "," + col);
			}
		}
		currentRoom = caves[0][1];
		currentRoom.enter();
		
	}

}
