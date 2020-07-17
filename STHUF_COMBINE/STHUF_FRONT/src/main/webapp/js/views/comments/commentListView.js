/*
 * this is the view to display the item comment in list view format
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
        
        addCommentView 	= require('views/comments/addCommentView'),
    
        //include the home content template
        commentListViewTmpl      = require('text!../../../templates/comments/commentListView.html'),
        item
    ;
    	
	var CommentListView = Backbone.View.extend({
        
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
        	
        	template = Handlebars.compile(commentListViewTmpl);
        	this.$el.html(template(item));
        	
        	//initiate the popover for each tab
        	Util.initItemDetailViewPopover();
        	
        	//initiate popover links for comments
        	this.initCommentsPopoverLinks();
        	
            return this;
        },
        
        events: {
	        //'submit .sign-up-form' : 'registerUser'
	    },
        
        initCommentsPopoverLinks: function(){
	    	
	    	$("[data-toggle='popover']").on('shown.bs.popover', function () {
		 		
		 		//initate popover links
		 		$(".modal-view").on('click', function(e){
		 			e.preventDefault();
		 			
		 			var view,
		    		buttonAction;
		    	
		    		view = $(event.currentTarget).attr("data-modal-view");
		 			
		 			switch (view) {
						
						case 'addComment':
							buttonAction = new addCommentView({el:"#inventoryModal .modal-content"});
							buttonAction.render().$el;
							
				 			Util.displayModal(buttonAction);
							break;
						
						case 'deleteComment':
							Util.deleteItemMetaView();
							break;
							
						default:
							console.log("error");	
					};
		 			
					
		 		});
		 		
	 		});
	    },
        
        
	    
	});
	
	return CommentListView;
 
});