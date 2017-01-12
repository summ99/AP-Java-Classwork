package caveExplorer;

public class Inventory {
	private boolean hasMap;
	private String map;
	
	public Inventory()
	{
		hasMap = false;
		updateMap();
	}
	
	public void updateMap() {
		map = " " ;
		for(int i =0; i<CaveExplorer.caves[0].length-1; i++)
		{
			map+="____";//4 uS
			
		}
		map +="___\n";//3
		for(CaveRoom[] row:CaveExplorer.caves)
		{
			//3 rows of text
			for(int i=0;i<3;i++)
			{
				String text = "";
				for(CaveRoom cr:row)
				{
					//text = "|";
					if(cr.getDoor(CaveRoom.WEST)!= null&&cr.getDoor(CaveRoom.WEST).isOpen())
					{
						text += " ";
					}
					else
					{
						text +="|";
					}
					if(i==0)
					{
						text += "   ";//3 spaces
					}
					else if(i==1){
						text += " " + cr.getContents()+" ";
					}
					else if(i==2)
					{
						if(cr.getDoor(CaveRoom.SOUTH)!=null&&cr.getDoor(CaveRoom.SOUTH).isOpen())
						{
							text += "   ";
						}
						else
						{
							text += "___";
						}
					}
				}//last room in row
				text += "|";
				map += text + "\n";
			}//last of the new text lines
		}//last row
		
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
