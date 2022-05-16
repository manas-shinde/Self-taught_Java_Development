package menuitemclass;

import com.google.inject.Inject;
import action.*;
import menu.MenuItem;

public class SearchByZipcode extends MenuItem {
	static String title = "SEARCH BY STATE";
	static int choice = 2;
	Action action;

	@Inject
	public SearchByZipcode(SearchAddressByZipcode a) {
		super(choice, title, a);
		this.action = a;
	}
}
