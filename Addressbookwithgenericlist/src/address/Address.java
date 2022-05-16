package address;

public class Address {
	String street, state, city;
	int zipcode;

	public Address() {
	}

	public Address(String street, String state, String city, int zipcode) {// Parameterized constructor
		super();
		this.street = street;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String toString() {
		return "-------------------------------\nStreet Name :" + this.street + "\n " + "City : " + this.city + "\n "
				+ "State : " + this.state + "\n " + "Zipcode : " + this.zipcode + "\n";
	}
//	 TODO:getters

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZipcode() {
		return zipcode;
	}

}
