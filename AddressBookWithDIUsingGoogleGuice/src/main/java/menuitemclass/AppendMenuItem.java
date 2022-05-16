package menuitemclass;

import com.google.inject.Inject;

import action.*;
import menu.MenuItem;

public class AppendMenuItem extends MenuItem {
	static String title = "APPEND";
	static int choice = 1;
	Action action;

	@Inject
	public AppendMenuItem(AppendAddressAction a) {
		super(choice, title, a);
		this.action = a;
	}
}
