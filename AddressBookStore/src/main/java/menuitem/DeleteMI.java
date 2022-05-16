package menuitem;

import com.google.inject.Inject;
import action.*;
import menu.MenuItem;

public class DeleteMI extends MenuItem {
	static String title = "DELETE";
	static int choice = 3;
	Action action;

	@Inject
	public DeleteMI(DeleteAction a) {
		super(choice, title, a);
		this.action = a;
	}
}