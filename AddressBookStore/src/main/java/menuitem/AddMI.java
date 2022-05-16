package menuitem;

import com.google.inject.Inject;
import action.Action;
import action.AddAction;
import menu.MenuItem;

public class AddMI extends MenuItem {
	static String title = "ADD ";
	static int choice = 1;
	Action action;

	@Inject
	public AddMI(AddAction a) {
		super(choice, title, a);
		this.action = a;
	}
}
