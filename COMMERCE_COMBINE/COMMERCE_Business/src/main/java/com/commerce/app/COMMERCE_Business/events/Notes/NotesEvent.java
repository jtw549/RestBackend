package com.commerce.app.COMMERCE_Business.events.Notes;


public class NotesEvent {
/*	"note": {
    "itemId": "",
    "title": "",
    "description": ""
}*/
	private NotesDetails notesDetails;
	
	public NotesEvent (NotesDetails notesDetails) {
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
	
	/*public NotesDeletedEvent (ArrayList<InventoryNotes> inventoryNotes) {
		NotesDetails notesDetails = new NotesDetails();
		notesDetails.toNotesDetails(inventoryNotes,notesDetails);
		this.notesDetails = notesDetails;
	}*/
}
