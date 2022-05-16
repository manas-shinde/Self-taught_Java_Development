package menu;

import action.Action;

public class MenuItem {
	String title;
	int choice;
	Action action;

	public MenuItem() {

	}

	public MenuItem(int choice, String title, Action action) {
		super();
		this.title = title;
		this.choice = choice;
		this.action = action;
	}

	public void display() {
		System.out.print("  |   ");
		System.out.println(this.choice + "." + this.title);
	}

	public void selectAct() {
		this.action.onAction();
	}

	public int getChoice() {

		return choice;
	}
}
