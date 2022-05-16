package menu;

import list.List;

public class Menu extends MenuItem{

	public <T> void display(List<T> list) {
		list.displayItems();

	}
}
