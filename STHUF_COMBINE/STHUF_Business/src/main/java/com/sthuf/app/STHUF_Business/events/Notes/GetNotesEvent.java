package com.sthuf.app.STHUF_Business.events.Notes;

import com.sthuf.app.STHUF_Business.events.ReadEvent;

public class GetNotesEvent extends ReadEvent{

	private NotesDetails notesDetails;
	
	public GetNotesEvent (NotesDetails notesDetails) {
		this.notesDetails = notesDetails;
	}

	public NotesDetails getNotesDetails() {
		return notesDetails;
	}
}
