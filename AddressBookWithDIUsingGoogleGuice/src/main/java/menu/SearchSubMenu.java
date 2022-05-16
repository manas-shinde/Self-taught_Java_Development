package menu;

import java.util.ArrayList;
import com.google.inject.Inject;

import menuitemclass.SearchByCity;
import menuitemclass.SearchByState;
import menuitemclass.SearchByStreetMenuItem;
import menuitemclass.SearchByZipcode;

public class SearchSubMenu extends Menu {
	ArrayList<MenuItem> subMenu = new ArrayList<MenuItem>();

	@Inject
	public SearchSubMenu(SearchByStreetMenuItem street, SearchByState state, SearchByCity city,
			SearchByZipcode zipcode) {

		super(-1, "SEARCH SUB MENU ");
		subMenu.add(street);
		subMenu.add(state);
		subMenu.add(city);
		subMenu.add(zipcode);

	}

	public ArrayList<MenuItem> getSubMenu() {
		return subMenu;
	}
}