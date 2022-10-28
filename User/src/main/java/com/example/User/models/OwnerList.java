package com.example.User.models;

import java.util.List;

public class OwnerList {

	private List<OwnerInformation> allOwner;

	public List<OwnerInformation> getAllAdmin() {
		return allOwner;
	}

	public void setAllAdmin(List<OwnerInformation> allOwner) {
		this.allOwner = allOwner;
	}

}
