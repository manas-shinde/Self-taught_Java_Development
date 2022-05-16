package menu;

import action.Action;

public class MenuItem {
	String title;
	int option;
	Action action;
	
	public MenuItem() {//Default 
		
	}
	public MenuItem(String title, int option,Action action) {
		this.title = title;
		this.option = option;
		this.action = action;
	}

	public String toString() {
		return "" + this.option + " : " + this.title;
	}

	public void display() {
		System.out.println(option +" : " + title);
	}
}