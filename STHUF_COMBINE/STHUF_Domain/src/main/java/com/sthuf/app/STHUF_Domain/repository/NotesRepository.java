package com.sthuf.app.STHUF_Domain.repository;

import java.util.ArrayList;

import com.sthuf.app.STHUF_Domain.domain.InventoryNotes;

public interface NotesRepository{

	
	public ArrayList<InventoryNotes> addNotes(InventoryNotes inventoryNotes);
	public ArrayList<InventoryNotes> deleteNotes(InventoryNotes inventoryNotes);
	public ArrayList<InventoryNotes> getNotes(InventoryNotes inventoryNotes);
	public ArrayList<InventoryNotes> updateNotes(InventoryNotes inventoryNotes);
}
