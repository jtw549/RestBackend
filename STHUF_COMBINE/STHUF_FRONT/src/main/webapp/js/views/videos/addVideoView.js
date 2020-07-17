/*
 * this is the view to display the add video page
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        
        Handlebars	= require('handlebars'),
        
        //templates
    	addVideoTmpl = require('text!../../../templates/videos/addVideoView.html'),
    	
    	//global variables
    	itemInstance;
    ;
    	
	var AddVideoView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	        
	        itemInstance = this.model;
	        
	    },
		
        render: function () {
            template = Handlebars.compile(addVideoTmpl);
            this.$el.html(template);
            return this;
        },
        
        events: {
        	'click .add-video-form button.btn-primary' : 'addVideo'
	    },
        
        addVideo: function(event) {
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
	    	itemInstance.rest("addVideo", "video", data, function(response){
	    		var reponseData = $.parseJSON(response);
	    		
	    		//success
	    		if(reponseData.status == "success"){
	    			console.log(reponseData);	
	    			//console.log(item.getItemData());
	    		}
	    		else{
	    			console.log("add video failed");
	    		}
	    	});
	    	
        }
	});
	
	return AddVideoView;
 
});