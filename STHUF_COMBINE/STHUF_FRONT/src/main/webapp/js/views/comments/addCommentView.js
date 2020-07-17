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
        
        ItemModel = require('models/itemModel'),
        UserModel = require('models/userModel'),
        
    	addCommentTmpl = require('text!../../../templates/comments/addCommentView.html')
    ;
    	
	var AddCommentView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	        //this.render();	        
	    },
		
        render: function () {
            template = Handlebars.compile(addCommentTmpl);
            this.$el.html(template);
            return this;
        },
        
        events: {
        	'click .add-comment-form button.btn-primary' : 'addComment'
	    },
        
        addComment: function(event) {
	    	event.preventDefault();
	    	var itemId,
	    		item,
	    		user,
	    		userId,
	    		data,
	    		noteTitle,
	    		userComment
	    		;
	    	
	    	//get the input value
	    	userComment = $("#commentDetails").val();
	    	
	    	//get the selected itemId
	    	item = new ItemModel();
	    	itemId = item.getSelectedId();
	    	
	    	user = new UserModel();
	    	userId = user.getSelectedId();
	    	
	    	//build the object
	    	data = {
    			"comment": {
    		        "itemId": itemId,
    		        "userId": userId,
    		        "userComment": userComment
    		    }
	    	}
	    	
	    	//make api call
	    	item.rest("addComment", "comment", data, function(response){
	    		var reponseData = $.parseJSON(response);
	    		
	    		//success
	    		if(reponseData.status == "success"){
	    			console.log(reponseData);	
	    			console.log(item.getItemData());
	    		}
	    		else{
	    			console.log("add comment failed");
	    		}
	    	});
	    	
        }
	});
	
	return AddCommentView;
 
});