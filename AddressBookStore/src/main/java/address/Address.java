package address;

import java.io.Serializable;

public class Address implements Serializable {
	private String streetName, stateName, cityName;
	private int zipcode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String streetName, String stateName, String cityName, int zipcode) {
		super();
		this.streetName = streetName;
		this.stateName = stateName;
		this.cityName = cityName;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "-----------------\nstreet Name :" + streetName + "\n state Name :" + stateName + "\n city Name :"
				+ cityName + "\n zip code :" + zipcode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
