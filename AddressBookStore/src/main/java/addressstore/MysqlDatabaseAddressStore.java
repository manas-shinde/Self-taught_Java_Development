package addressstore;

import java.sql.*;
import java.util.ArrayList;
import address.Address;
import addressio.ConsoleAddressIO;

public class MysqlDatabaseAddressStore implements AddressStore {
	Connection con;
	ConsoleAddressIO caio;
	Address address;
	ArrayList<Address> listOfAddress;

	public MysqlDatabaseAddressStore() {
		this.listOfAddress = new ArrayList<Address>();
		caio = new ConsoleAddressIO();
		makeAConnection();
	}

	public void addAddress() {
		try {
			address = caio.getAddressFromConsole();
			String INSERT_ADDRESS_SQL = "INSERT INTO Address1 VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_ADDRESS_SQL);

			preparedStatement.setString(1, address.getStreetName());
			preparedStatement.setString(2, address.getStateName());
			preparedStatement.setString(3, address.getCityName());
			preparedStatement.setInt(4, address.getZipcode());
			int updateCounts = preparedStatement.executeUpdate();

			caio.displayMessage("Data Inserted" + updateCounts);
		} catch (Exception e) {
			caio.displayMessage("Cant insert data \nError occur!!!");
		}
	}

	public void deleteAddress() {
		caio.displayMessage("Enter the Street Name of Address U wish to delete:");
		String Street = caio.getStreetName();

		String DELETE_QUERY = "DELETE FROM Address WHERE streetName = ?;";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(DELETE_QUERY);
			preparedStatement.setString(1, Street);

			int rowAffected = preparedStatement.executeUpdate();
			con.commit();

			caio.displayMessage("Address deleted Successfully! [ Row Count: " + rowAffected + " ]");

		} catch (SQLException e) {
			caio.displayMessage("Got an exception!");
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayAddress() {
		try {
			String QUERY = "SELECT * FROM Address;";

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(QUERY);

			// Step - 3: Printing data
			System.out.println("Street Name \t State Name \t City Name \t Zip-Code");
			while (rs.next()) {
				// Display values
				caio.displayMessage(rs.getString("StreetName") + "\t\t" + rs.getString("stateName") + "\t\t"
						+ rs.getString("cityName") + "\t\t" + rs.getInt("zipcode") + "\t\t");
				System.out.println();
			}
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findAddress() {
		String streetName = caio.getStreetName();
		PreparedStatement p = null;
		ResultSet rs = null;
		
		// Try block to check exceptions
		try {

			// Step 4: Write a statement
			String sql = "select * from Address where " + "streetName = '" + streetName + "';";

			// Step 5: Execute the query
			p = con.prepareStatement(sql);
			rs = p.executeQuery();

			// Step 6: Process the results
			caio.displayMessage("Street Name \t State Name \t City Name \t Zip-Code");

			// Condition check using next() method
			// Holds true till there is single element remaining
			// in the object
			if (rs.next()) {

				String street = rs.getString("StreetName");
				String state = rs.getString("stateName");
				String city = rs.getString("cityName");
				int zipcode = rs.getInt("zipcode");

				// Print and display name, emailID and password
				caio.displayMessage(street + "\t\t" + state + "\t\t" + city + "\t\t" + zipcode);
			}
		}

		// Catch block to handle exceptions
		catch (SQLException e) {

			// Print the exception
			System.out.println(e);
		}
	}

	public void saveAddress() {
		/*
		 * To add entire list into database
		 * 
		 * 
		 * String INSERT_ADDRESS_SQL = "INSERT INTO Address" +
		 * "  (streetName,statename,cityName,zipcode) VALUES " + " (?, ?, ?, ?);";
		 * 
		 * try { PreparedStatement preparedStatement =
		 * con.prepareStatement(INSERT_ADDRESS_SQL); con.setAutoCommit(false);
		 * Iterator<Address> iterator = listOfAddress.iterator(); while
		 * (iterator.hasNext()) { Address address = (Address) iterator.next();
		 * preparedStatement.setString(1, address.getStreetName());
		 * preparedStatement.setString(2, address.getStateName());
		 * preparedStatement.setString(3, address.getCityName());
		 * preparedStatement.setInt(4, address.getZipcode());
		 * 
		 * preparedStatement.addBatch(); } int[] updateCounts =
		 * preparedStatement.executeBatch();
		 * System.out.println(Arrays.toString(updateCounts)); con.commit();
		 * con.setAutoCommit(true);
		 * System.out.println("Data is MakeaConnection mk = new MakeaConnection();Address to the Database!!\n--------------"); }
		 * catch (SQLException e) { e.printStackTrace(); }
		 */
		caio.displayMessage("All  saved inside databases already !!");
	}

	public void makeAConnection() {
		try {
//			STEP -1:
			final String DRIVER = "com.mysql.cj.jdbc.Driver";
			final String URL = "jdbc:mysql://localhost:6603/addressbook";
			final String USERNAME = "root";
			final String PASSWORD = "abcd1234";

//			STEP -2:
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			caio.displayMessage("Connection Successfully Established!!!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
