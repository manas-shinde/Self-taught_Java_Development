package menu;

import action.Action;

public class MenuItem {
	String title;
	int option;
	public Action action;

	public MenuItem() {

	}

	/**
	 * 
	 * @param title
	 * @param option
	 * @param action
	 */

	public MenuItem(String title, int option, Action action) {
		this.title = title;
		this.option = option;
		this.action = action;
	}

	@Override
	public String toString() {
		return "" + this.option + " : " + this.title;
	}
	/**
	 * selectAct method
	 */
	public void selectAct() {
		this.action.onAction();
	}

	/**
	 * display method
	 */
	public void display() {
		System.out.println(option + " : " + title);
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}


}