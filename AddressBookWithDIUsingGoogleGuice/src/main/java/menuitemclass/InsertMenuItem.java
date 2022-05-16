package menuitemclass;

import com.google.inject.Inject;
import action.*;
import menu.MenuItem;

public class InsertMenuItem extends MenuItem {
	static String title = "INSERT";
	static int choice = 2;
	Action action;

	@Inject
	public InsertMenuItem(InsertAddress a) {
		super(choice, title, a);
		this.action = a;
	}
}
