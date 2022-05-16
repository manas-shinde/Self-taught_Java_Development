package list;

import java.io.Serializable;

import address.Address;

public class List<T> implements Serializable{

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
			int i = 0;
			while (current != null) {
				if (current.data instanceof Address) {
					System.out.println("----------------------------");
					System.out.println("INDEX NO : " + i);
					System.out.println(current.data);
					current = current.next;
					i++;
				} else {
					System.out.println(current.data);
					current = current.next;
					i++;
				}

			}

		}

	}

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

	public int totalItem() {
		int n = 0;
		current = first;
		while (current != null) {
			current = current.next;
			n++;
		}
		return n;
	}

	public T getData(int index) {
		current = first;
		for (int i = 1; i <= index - 1; i++) {
			current = current.next;
		}
		return current.data;
	}

	public void insertItem(T data, int index) {
		Node<T> nNode = new Node<T>(data, null, null);
		current = first;

		if (index == 0) {
			if (current.next != null) {
				nNode.next = current;
				current.prev = nNode;

				first = current = nNode;
			} else {
				first = current = nNode;
			}
		} else {
			if (index == 1) {
				if (current.next != null) {
					nNode.next = current.next;
					current.next.prev = nNode;

					nNode.prev = current;
					current.next = nNode;
				} else {
					current.next = nNode;
					nNode.prev = current;
				}
			}
			for (int i = 0; i != index - 1; i++) {
				current = current.next;
			}
			if (current.next == null) {// if this condition validates true that means current node is pointing at a
				// last node
				current.next = nNode;
				nNode.prev = current;
				last = nNode;
			} else {// for in-between index
				nNode.next = current.next.next;
				current.next.prev = nNode;

				current.next = nNode;
				nNode.prev = current;
			}
		}

	}

	public void deleteSpecificItem(T data) {
		current = first;

		while (current.getData() != data) {
			current = current.next;
		}

		if (current.next == null) {// current is pointing at last node(address)
			last = current.prev;
			last.next = null;

			current.prev = null;
			current.data = null;
		} else if (current.prev == null) {// current is pointing at first node(address)
			first = current.next;
			current.next = null;
			first.prev = null;
			current.data = null;
		} else {
			current.prev.next = current.next;
			current.next.prev = current.prev;

			current.data = null;
			current.prev = null;
			current.next = null;
		}

	}

}