package gui.Simon;

import gui.components.Action;
import gui.components.Clickable;

public interface ButtonInterfaceJiayan extends Clickable {

	void setColor();

	void setY();

	void setX();
	public void setAction(Action a);

	void highlight();

	void dim();
}
