package menuitemclass;

import menu.MenuItem;

import com.google.inject.Inject;

import action.*;

public class SearchMenuItem extends MenuItem {
	static String title = "SEARCH";
	static int choice = 4;
	Action a;

	@Inject
	public SearchMenuItem(SearchAddressAction action) {
		super(choice, title, action);
		this.a = action;
	}
}
