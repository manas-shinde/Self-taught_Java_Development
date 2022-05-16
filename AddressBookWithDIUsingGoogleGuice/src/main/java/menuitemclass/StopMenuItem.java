package menuitemclass;

import action.Action;
import menu.MenuItem;

public class StopMenuItem extends MenuItem {
	static String title = "STOP";
	static int choice = 0;
	Action a;

	public StopMenuItem() {
		super(choice, title, null);
	}
}
