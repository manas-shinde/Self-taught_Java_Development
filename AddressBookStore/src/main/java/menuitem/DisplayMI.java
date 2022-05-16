package menuitem;

import com.google.inject.Inject;
import action.*;
import menu.MenuItem;

public class DisplayMI extends MenuItem {
	static String title = "DISPLAY ";
	static int choice = 2;
	Action action;

	@Inject
	public DisplayMI(DisplayAction a) {
		super(choice, title, a);
		this.action = a;
	}
}