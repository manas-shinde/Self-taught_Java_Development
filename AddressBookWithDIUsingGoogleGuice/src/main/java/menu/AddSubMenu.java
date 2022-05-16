package menu;

import java.util.ArrayList;
import com.google.inject.Inject;
import menuitemclass.*;

public class AddSubMenu extends Menu {
	ArrayList<MenuItem> subMenu = new ArrayList<MenuItem>();

	@Inject
	public AddSubMenu(InsertMenuItem mi, AppendMenuItem ap) {

		super(-1, "ADD SUB MENU ");
		subMenu.add(ap);
		subMenu.add(mi);

	}

	public ArrayList<MenuItem> getSubMenu() {
		return subMenu;
	}
}
