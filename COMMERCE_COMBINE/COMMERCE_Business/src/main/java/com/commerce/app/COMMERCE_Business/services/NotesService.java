package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Notes.*;

public interface NotesService {

	public NotesAddedEvent addNotes(AddNotesEvent addNotesEvent);
	public NotesDeletedEvent deleteNotes(DeleteNotesEvent deleteNotesEvent);
	public NotesGottenEvent getNotes(GetNotesEvent getNotesEvent);
	public NotesUpdatedEvent updateNotes(UpdateNotesEvent updateNotesEvent);
}
