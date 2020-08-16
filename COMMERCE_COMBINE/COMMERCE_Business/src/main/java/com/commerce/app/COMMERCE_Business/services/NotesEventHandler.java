package com.commerce.app.COMMERCE_Business.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.commerce.app.COMMERCE_Business.events.Notes.*;
import com.commerce.app.COMMERCE_Domain.domain.InventoryNotes;
import com.commerce.app.COMMERCE_Domain.repository.NotesRepository;

@Service("notesService")
@ComponentScan("com.commerce.app.COMMERCE_Domain.repository")
public class NotesEventHandler implements NotesService{
	
	private static Logger LOG = LoggerFactory.getLogger(NotesEventHandler.class);
	
	@Autowired
	private NotesRepository notesRepository;
	
	
	@Override
	public NotesAddedEvent addNotes(AddNotesEvent addNotesEvent) {
		InventoryNotes inventoryNotes = addNotesEvent.getNotesDetails().fromNotesDetails();
		ArrayList<InventoryNotes> iNotes = notesRepository.addNotes(inventoryNotes);
		return new NotesAddedEvent(iNotes);
	}
	
	@Override
	public NotesDeletedEvent deleteNotes(DeleteNotesEvent deleteNotesEvent) {
		InventoryNotes inventoryNotes = deleteNotesEvent.getNotesDetails().fromNotesDetails();
		ArrayList<InventoryNotes> iNotes = notesRepository.deleteNotes(inventoryNotes);
		return new NotesDeletedEvent(iNotes);
	}
	
	@Override
	public NotesGottenEvent getNotes(GetNotesEvent getNotesEvent) {
		InventoryNotes inventoryNotes = getNotesEvent.getNotesDetails().fromNotesDetails();
		ArrayList<InventoryNotes> iNotes = notesRepository.getNotes(inventoryNotes);
		return new NotesGottenEvent(iNotes);
	}
	
	@Override
	public NotesUpdatedEvent updateNotes(UpdateNotesEvent updateNotesEvent) {
		InventoryNotes inventoryNotes = updateNotesEvent.getNotesDetails().fromNotesDetails();
		ArrayList<InventoryNotes> iNotes = notesRepository.updateNotes(inventoryNotes);
		return new NotesUpdatedEvent(iNotes);
	}
}
