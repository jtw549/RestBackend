package com.sthuf.app.STHUF_Business.events.Notes;

import com.sthuf.app.STHUF_Business.events.DeleteEvent;

public class DeleteNotesEvent extends DeleteEvent{
	 /*"note": [
	          {
	              "noteId": ""   
	          },
	          ...
	      ]*/
	private NotesDetails notesDetails;
	
	public DeleteNotesEvent (NotesDetails notesDetails) {
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
}
