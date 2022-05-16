package action;

import java.util.Scanner;
import com.google.inject.Inject;
import address.Address;
import list.List;

public class AppendAddressAction implements Action {
	List listOfAddress;
	Scanner sc = new Scanner(System.in);

	@Override
	protected void finalize() throws Throwable {

		sc.close();
	}

	@Inject
	public AppendAddressAction(List listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public void onAction() {

		System.out.println("-----------Enter Address Details----------- ");
		System.out.println("Enter Street Name :");
		String tempStreet = sc.next();

		System.out.println("Enter City Name :");
		String tempCity = sc.next();

		System.out.println("Enter State Name :");
		String tempState = sc.next();

		System.out.println("Enter Zip Code :");
		int tempZipcode = sc.nextInt();

		Address address = new Address(tempStreet, tempState, tempCity, tempZipcode);

		listOfAddress.addAddress(address);
		System.out.println("------------------Address is added to list------------------");
	}

}
