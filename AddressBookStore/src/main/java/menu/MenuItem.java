package menu;

import com.google.inject.Inject;

import action.Action;
import action.AddAction;
import action.DeleteAction;
import action.DisplayAction;
import action.FindAction;
import action.SaveAction;
import addressstore.*;
import list.List;

public class MenuItem<T> {
	String title;
	int choice;
	T action;
	List ll;

	public MenuItem() {

	}

	/**
	 * @param choice
	 * @param title
	 * @param action
	 */
	public MenuItem(int choice, String title, T action) {
		super();
		this.title = title;
		this.choice = choice;
		this.action = action;
	}

	public void display() {
//		System.out.print("  |   ");
		System.out.println(this.choice + "." + this.title);
	}

	@Inject
	public void addList(List ll) {
		this.ll = ll;
	}

	public void selectAct() {
		addList(ll);
		if (action instanceof MemoryListAddressStore) {
			action = (T) new MemoryListAddressStore(ll);
		} else if (action instanceof FileBasedAddressStore) {
			action = (T) new FileBasedAddressStore(ll);
		} else if (action instanceof MysqlDatabaseAddressStore) {
			action = (T) new MysqlDatabaseAddressStore();
		} else if (action instanceof AddAction) {
			((AddAction) action).onAction();
		} else if (action instanceof DeleteAction) {
			((DeleteAction) action).onAction();
		} else if (action instanceof DisplayAction) {
			((DisplayAction) action).onAction();
		} else if (action instanceof FindAction) {
			((FindAction) action).onAction();
		}
		if (action instanceof SaveAction) {
			((SaveAction) action).onAction();
		}
	}

	public int getChoice() {
		return choice;
	}
}
