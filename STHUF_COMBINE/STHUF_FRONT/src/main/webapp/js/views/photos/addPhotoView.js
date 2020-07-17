/*
 * this is the view to display the add photo page
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
        //templates
    	addPhotoTmpl = require('text!../../../templates/photos/addPhotoView.html'),
    	
    	//global variables
    	itemInstance;
    ;
    	
	var AddPhotoView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	        
	        itemInstance = this.model;
	        
	    },
		
        render: function () {
            template = Handlebars.compile(addPhotoTmpl);
            this.$el.html(template);
            return this;
        },
        
        events: {
        	'click .add-photo-form button.btn-primary' : 'addPhoto'
	    },
        
        addPhoto: function(event) {
	    	event.preventDefault();
	    	var itemId,
	    		item,
	    		data,
	    		noteTitle,
	    		noteDescription
	    		;
	    	
	    	itemId = itemInstance.get("selectedId");
	    	
	    	//create data object
	    	//noteTitle = $("#noteTitle").val();
	    	//noteDescription = $("#noteDetails").val();
	    	
	    	//build the object
	    	data = {
				"itemId": itemId
	    	}
	    	
	    	//make api call
	    	itemInstance.rest("addPhoto", "photo", data, function(response){
	    		var reponseData = $.parseJSON(response);
	    		
	    		//success
	    		if(reponseData.status == "success"){
	    			console.log(reponseData);	
	    			//console.log(item.getItemData());
	    		}
	    		else{
	    			console.log("add note failed");
	    		}
	    	});
	    	
        }
	});
	
	return AddPhotoView;
 
});