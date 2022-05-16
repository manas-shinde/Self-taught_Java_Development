package menuitemclass;

import com.google.inject.Inject;

import action.*;
import menu.MenuItem;

public class SearchByStreetMenuItem extends MenuItem {
	static String title = "SEARCH BY STREET";
	static int choice = 1;
	Action action;

	@Inject
	public SearchByStreetMenuItem(SearchAddressByStreet a) {
		super(choice, title, a);
		this.action = a;
	}
}