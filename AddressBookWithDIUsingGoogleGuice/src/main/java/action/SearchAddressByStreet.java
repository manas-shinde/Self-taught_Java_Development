package action;

import com.google.inject.Inject;

import list.List;

public class SearchAddressByStreet implements Action {
	List listOfAddres;

	@Inject
	public SearchAddressByStreet(List listOfAddres) {
		this.listOfAddres = listOfAddres;
	}

	public void onAction() {
		listOfAddres.searchByStreet();
	}

}
