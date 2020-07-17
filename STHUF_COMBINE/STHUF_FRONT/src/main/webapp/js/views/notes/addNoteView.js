/*
 * this is the view to display the add note page
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
        //templates
    	addNoteTmpl = require('text!../../../templates/notes/addNoteView.html'),
    	
    	//global variables
    	itemInstance;
    ;
    	
	var AddNoteView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	        
	        itemInstance = this.model;
	        
	    },
		
        render: function () {
            template = Handlebars.compile(addNoteTmpl);
            this.$el.html(template);
            return this;
        },
        
        events: {
        	'click .add-note-form button.btn-primary' : 'addNote'
	    },
        
        addNote: function(event) {
	    	event.preventDefault();
	    	var itemId,
	    		item,
	    		data,
	    		noteTitle,
	    		noteDescription
	    		;
	    	
	    	itemId = itemInstance.get("selectedId");
	    	
	    	//create data object
	    	noteTitle = $("#noteTitle").val();
	    	noteDescription = $("#noteDetails").val();
	    	
	    	//build the object
	    	data = {
				"itemId": itemId,
				"title": noteTitle,
				"description": noteDescription
	    	}
	    	
	    	//make api call
	    	itemInstance.rest("addNote", "note", data, function(response){
	    		var reponseData = $.parseJSON(response);
	    		
	    		//success
	    		if(reponseData.status == "success"){
	    			console.log(reponseData);	
	    			console.log(item.getItemData());
	    		}
	    		else{
	    			console.log("add note failed");
	    		}
	    	});
	    	
        }
	});
	
	return AddNoteView;
 
});