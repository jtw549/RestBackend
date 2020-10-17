package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Notes.NotesEvent;

public interface NotesService {

	public NotesEvent addNotes(NotesEvent addNotesEvent);
	public NotesEvent deleteNotes(NotesEvent deleteNotesEvent);
	public NotesEvent getNotes(NotesEvent getNotesEvent);
	public NotesEvent updateNotes(NotesEvent updateNotesEvent);
}
