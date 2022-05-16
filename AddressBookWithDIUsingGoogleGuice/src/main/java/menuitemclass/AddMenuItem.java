package menuitemclass;

import com.google.inject.Inject;

import action.*;
import menu.Menu;
import menu.MenuItem;

public class AddMenuItem extends MenuItem {
	static String title = "ADD";
	static int choice = 1;
	Action action;

	@Inject
	public AddMenuItem(AddAddressAction a) {
		super(choice, title, a);
		this.action = a;
	}
}
