/*
 * this is the view to display the item note in list view format
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        
        Util		= require('util'),
        Handlebars	= require('handlebars'),
        
        //models
        ItemModel = require('models/itemModel'),
        
        addNoteView = require('views/notes/addNoteView'),
    
        //include the home content template
        noteListViewTmpl      = require('text!../../../templates/notes/noteListView.html'),
        item
    ;
    	
	var NoteListView = Backbone.View.extend({
	
		initialize: function() {
	        //_.bindAll(this, 'render', 'registerUser');
	    	var items,
	    		itemId
    		;
	    	
	    	itemId = ItemModel.model.get("selectedId");
	    	items = $.parseJSON(ItemModel.model.get("data"));
	    	
	    	item = Util.filterItem(items, itemId);
	    },
		
        render: function () {
        	var template;
        	
        	template = Handlebars.compile(noteListViewTmpl);
        	this.$el.html(template(item));
        	
        	//initiate the popover for each tab
        	Util.initItemDetailViewPopover();
        	
        	//initiate popover links for Notes
        	this.initNotesPopoverLinks();
        	
            return this;
        },
        
        events: {
        	
	    },
	    
	    initNotesPopoverLinks: function(){
	    	var me = this;
	    	
	    	$("[data-toggle='popover']").on('shown.bs.popover', function () {
		 		
		 		//initate popover links
		 		$(".modal-view").on('click', function(e){
		 			e.preventDefault();
		 			
		 			var view,
		    		buttonAction;
		    	
		    		view = $(event.currentTarget).attr("data-modal-view");
		 			
		 			switch (view) {
						
						case 'addNote':
							buttonAction = new addNoteView({el:"#inventoryModal .modal-content", model:me.model});
							buttonAction.render().$el;
							
				 			Util.displayModal(buttonAction);
							break;
							
						case 'deleteNote':
							Util.deleteItemMetaView();
							break;
							
						default:
							console.log("error");	
					};
		 		});
	 		});
	    }
	    
	});
	
	return NoteListView;
 
});