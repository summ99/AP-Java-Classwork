package caveExplorer;

public class Inventory {
	private boolean hasMap;
	private String map;
	
	public Inventory()
	{
		hasMap = true;
		updateMap();
	}
	
	private void updateMap() {
		// TODO Auto-generated method stub
		
	}

	public String getDescription() {
		if(hasMap)
		{
			return map;
		}
		else
		{
			return("there is nothing in your inventory");
		}
	}
	public void setMap(boolean b)
	{
		hasMap = b;
	}
	
}
