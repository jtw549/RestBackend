package com.sthuf.app.STHUF_Domain.repository;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Domain.domain.Inventories;

public interface ItemsRepository{

	public Inventories addItem (Inventories inventories);
	public boolean deleteItem(Inventories inventories);
	public Inventories updateItem(Inventories inventories);
	public Inventories getItem(Inventories inventories);
	public ArrayList<Inventories> getItems(Inventories inventories);
	public ArrayList<Inventories> getItemsbyCategory(Inventories inventories);
	public Inventories bookmarkItem(Inventories inventories);
}
