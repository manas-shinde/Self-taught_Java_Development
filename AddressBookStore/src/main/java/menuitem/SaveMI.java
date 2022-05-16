package menuitem;

import com.google.inject.Inject;
import action.Action;
import action.SaveAction;
import menu.MenuItem;

public class SaveMI extends MenuItem {
	static String title = "SAVE ";
	static int choice = 5;
	Action action;

	@Inject
	public SaveMI(SaveAction a) {
		super(choice, title, a);
		this.action = a;
	}
}