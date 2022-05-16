package menuitemclass;

import com.google.inject.Inject;
import action.*;
import menu.MenuItem;

public class SearchByCity extends MenuItem {
	static String title = "SEARCH BY CITY";
	static int choice = 3;
	Action action;

	@Inject
	public SearchByCity(SearchAddressByCity a) {
		super(choice, title, a);
		this.action = a;
	}
}
