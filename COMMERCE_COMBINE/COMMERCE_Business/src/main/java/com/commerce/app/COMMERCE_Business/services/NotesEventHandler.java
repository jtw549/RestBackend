package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Notes.NotesEvent;
import com.commerce.app.COMMERCE_Domain.domain.InventoryNotes;
import com.commerce.app.COMMERCE_Domain.repository.NotesRepository;

@Service("notesService")
@ComponentScan("com.commerce.app.COMMERCE_Domain.repository")
public class NotesEventHandler implements NotesService{
	
	private static Logger LOG = LoggerFactory.getLogger(NotesEventHandler.class);
	
	@Autowired
	private NotesRepository notesRepository;
	
	
	@Override
	public NotesEvent addNotes(NotesEvent addNotesEvent) {
		InventoryNotes inventoryNotes = addNotesEvent.getNotesDetails().fromNotesDetails();
		ArrayList<InventoryNotes> iNotes = notesRepository.addNotes(inventoryNotes);
		return new NotesEvent(iNotes);
	}
	
	@Override
	public NotesEvent deleteNotes(NotesEvent deleteNotesEvent) {
		InventoryNotes inventoryNotes = deleteNotesEvent.getNotesDetails().fromNotesDetails();
		ArrayList<InventoryNotes> iNotes = notesRepository.deleteNotes(inventoryNotes);
		return new NotesEvent(iNotes);
	}
	
	@Override
	public NotesEvent getNotes(NotesEvent getNotesEvent) {
		InventoryNotes inventoryNotes = getNotesEvent.getNotesDetails().fromNotesDetails();
		ArrayList<InventoryNotes> iNotes = notesRepository.getNotes(inventoryNotes);
		return new NotesEvent(iNotes);
	}
	
	@Override
	public NotesEvent updateNotes(NotesEvent updateNotesEvent) {
		InventoryNotes inventoryNotes = updateNotesEvent.getNotesDetails().fromNotesDetails();
		ArrayList<InventoryNotes> iNotes = notesRepository.updateNotes(inventoryNotes);
		return new NotesEvent(iNotes);
	}
}
