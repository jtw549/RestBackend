package com.sthuf.app.STHUF_Business.services;

import com.sthuf.app.STHUF_Business.events.Notes.*;

public interface NotesService {

	public NotesAddedEvent addNotes(AddNotesEvent addNotesEvent);
	public NotesDeletedEvent deleteNotes(DeleteNotesEvent deleteNotesEvent);
	public NotesGottenEvent getNotes(GetNotesEvent getNotesEvent);
	public NotesUpdatedEvent updateNotes(UpdateNotesEvent updateNotesEvent);
}
