package caveExplorer;

public class CaveRoom {
	//'final' means never changed
	//constants are public and all caps
	//example Math.Pi;
	public static final int NORTH = 0;
	public static final int EAST =1;
	public static final int SOUTH =2;
	public static final int WEST =3;
	
	private String description;
	private String directions;
	private String contents;
	private String defaultContents;
	
	private CaveRoom[] borderingRooms;
	private Door[] door;
	
	public CaveRoom(String description) {
		
	}
	
	public void enter() {
		// TODO Auto-generated method stub
		//sets up cave for when it is entered
		
	}

}
