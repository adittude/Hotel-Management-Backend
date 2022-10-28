package com.Inventory.Models;

import java.util.List;

public class InventoryList {

	private List<Inventory> allInventory;

	public List<Inventory> getAllInventory() {return allInventory;
	}

	public void setAllInventory
			(List<Inventory> allInventory) {
		this.allInventory = allInventory;
	}

}
