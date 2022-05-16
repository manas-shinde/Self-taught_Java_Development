package menuitemclass;

import com.google.inject.Inject;

import action.*;
import menu.MenuItem;

public class DeleteMenuItem extends MenuItem {
	static String title = "DELETE";
	static int choice = 3;
	Action action;

	@Inject
	public DeleteMenuItem(DeleteAddressAction a) {
		super(choice, title, a);
		this.action = a;
	}
}
