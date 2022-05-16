package menuitemclass;

import com.google.inject.Inject;
import action.*;
import menu.Menu;
import menu.MenuItem;

public class DisplayMenuItem extends MenuItem {
	static String title = "DISPLAy";
	static int choice = 2;
	Action action;

	@Inject
	public DisplayMenuItem(DisplayAddressAction a) {
		super(choice, title, a);
		this.action = a;
	}
}
