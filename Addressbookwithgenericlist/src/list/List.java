package list;

import address.Address;

public class List<T> {

	Node<T> first, last, current;

	public List() {

	}

	public void addItem(T data) {
		Node<T> newNode = new Node<T>(data, null, null);

		if (first == null) {
			first = newNode;
			last = newNode;
			current = newNode;
		} else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
			current = newNode;
		}

	}

	public void displayItems() {

		if (first == null) {
			System.out.println("List is Empty!!!");
		} else {
			current = first;

			while (current != null) {

				System.out.println(current.data);
				current = current.next;

			}

		}

	}

//	public static boolean hasNext(List<MenuItem> list) {
//		boolean nextItemFound = false;
//		int i=0;
//		if(list.getData(i) instanceof MenuItem) {
//			i++;
//			return nextItemFound = true;
//			
//		}
//		i++;
//		return nextItemFound;
//		
//	}
	public void deleteItem(List<T> listOfAddress) {

		if (first == null) {
			System.out.println("list is empty !!");
		} else if (last.prev == null) {
			last.data = null;
			System.out.println("Now List is Empty!!!");
		} else {

			current = last.prev;

			current.next = null;
			last.prev = null;
			last.data = null;
			last = current;
		}
	}

	public T getData(int index) {
		current = first;
		for (int i = 0; i <= index - 1; i++) {
			current = current.next;
		}

		return current.data;

	}

	public void insertItem(T data, int index) {
		Node<T> nNode = new Node<T>(data, null, null);
		current = first;

		for (int i = 0; i != index - 1; i++) {
			current = current.next;
		}

		if (current.next == null) {// if this condition validates true that means current node is pointing at a
									// last node
			current.next = nNode;
			nNode.prev = current;
			last = nNode;
		} else if (current.prev == null) {// if this condition validates true means current node is pointing at first
											// node
			current = nNode.next;
			nNode.prev = current;

		} else {//for in-between index
			nNode.next = current.next.next;
			current.next.prev = nNode;

			current.next = nNode;
			nNode.prev = current;
		}
	}

	public void searchAddress(List<T> listOfAddress,int choice) {
		
		Address ad = new Address();
		
	}
}