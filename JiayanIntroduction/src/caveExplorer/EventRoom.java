package caveExplorer;

public class EventRoom extends CaveRoom {

	private Event event;
	private boolean eventOccurred;
	
	public EventRoom(String description, Event event) {
		super(description);
		eventOccurred = false;
		this.event = event;
		
	}
	public void enter()
	{
		super.enter();
		if(!eventOccurred)
		{
			eventOccurred = false;
			event.play();
		}
	}
}
