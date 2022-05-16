package list;

import java.io.Serializable;
import java.util.Scanner;

import address.Address;

public class List implements Serializable {
	Node current, first, last;
//	transient Scanner sc = new Scanner(System.in);

	public List() {
		// TODO Auto-generated constructor stub
	}

	public void addAddress(Address data) {
		Node nn = new Node(null, null, data);
		if (first == null) {
			current = first = last = nn;
		} else {
			last.next = nn;
			nn.prev = last;
			last = current = nn;
		}
	}

	public void deleteLastAddress() {
		if (first == null) {
			System.out.println("List is Empty!!!!!!");
		} else {
			current = first;
			while (current != null) {
				current = current.next;
			}
			current = last.prev;
			current.next = null;
			last.prev = null;
			last.data = null;
			last = current;
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

	public void insertAddress(Address address) {
		Scanner sc = new Scanner(System.in);
		Node nn = new Node(null, null, address);

		System.out.println("Enter Index : ");
		int index = sc.nextInt();
		current = first;
		for (int i = 0; i <= totalItem(); i++) {
			if (i == index) {
				if (current.prev == null) {
					nn.next = current;
					current.prev = nn;
					nn = first;
					System.out.println("Address is added to first position!!");
				} else {
					current.prev = nn;
					nn.next = current;
					nn.prev = current.prev;
					current.prev.next = nn;
					System.out.println("Address is added to " + index + " position!!");
				}
			}
			current = current.next;
		}
	}

	public Address searchByStreet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Street  Name to serach :");
		String streetName = sc.next();
		Boolean streetFound = false;
		current = first;
		Address address = null;

		while (current != null) {
			address = current.data;
			if (streetName.equals(address.getStreetName())) {
//				System.out.println(address);
				streetFound = true;
				return address;

			}
			current = current.next;
		}
		if (streetFound == false) {
			System.out.println("Address whose street name is " + streetName + " not Found !!!!");
		}
		return address;
	}

	public Address searchByState() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter State  Name to serach :");
		String stateName = sc.next();
		Boolean stateFound = false;
		current = first;
		Address address = null;

		while (current != null) {
			address = current.data;
			if (stateName.equals(address.getStateName())) {
//				System.out.println(address);
				stateFound = true;
				return address;
			}
			current = current.next;
		}
		if (stateFound == false) {
			System.out.println("Address whose street name is " + stateName + " not Found !!!!");
		}
		return address;
	}

	public Address searchByCity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  City Name to serach :");
		String cityName = sc.next();
		Boolean cityFound = false;
		current = first;
		Address address = null;

		while (current != null) {
			address = current.data;
			if (cityName.equals(address.getCityName())) {
//				System.out.println(address);
				cityFound = true;
				return address;
			}
			current = current.next;
		}
		if (cityFound == false) {
			System.out.println("Address whose street name is " + cityName + " not Found !!!!");
		}
		return address;
	}

	public Address searchByZipcode() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Zip-Code to serch :");
		String zipcode = sc.next();
		Boolean zipcodeFound = false;
		current = first;
		Address address = null;

		while (current != null) {
			address = current.data;
			if (zipcode.equals(address.getZipcode())) {
//				System.out.println(address);
				zipcodeFound = true;
				return address;
			}
			current = current.next;
		}
		if (zipcodeFound == false) {
			System.out.println("Address whose street name is " + zipcode + " not Found !!!!");
		}
		return address;
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

	class Node implements Serializable {
		Node next, prev;
		Address data;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(Node next, Node prev, Address data) {
			super();
			this.next = next;
			this.prev = prev;
			this.data = data;
		}

	}
}
