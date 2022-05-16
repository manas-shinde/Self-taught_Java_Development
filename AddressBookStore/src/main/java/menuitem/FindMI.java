package menuitem;

import com.google.inject.Inject;
import action.*;
import menu.MenuItem;

public class FindMI extends MenuItem {
	static String title = "FIND ";
	static int choice = 4;
	Action action;

	@Inject
	public FindMI(FindAction a) {
		super(choice, title, a);
		this.action = a;
	}
}