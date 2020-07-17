/*
 * this is the view to display the item videos in thumbview format
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
        
        addVideoView = require('views/videos/addVideoView'),
        
        //include the home content template
        videoListThumbViewTmpl      = require('text!../../../templates/videos/videoListThumbView.html'),
        item
    ;
    	
	var VideoListThumbView = Backbone.View.extend({
	
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
        	
        	template = Handlebars.compile(videoListThumbViewTmpl);
        	this.$el.html(template(item));
        	
        	//initiate the popover for each tab
        	Util.initItemDetailViewPopover();
        	
        	//initiate popover links for videos
        	this.initVideosPopoverLinks();
        	
            return this;
        },
        
        events: {
	        'click .delete-videos': 'deleteVideos'
	    },
	    
	    initVideosPopoverLinks: function(){
        	var me = this;
	    	
	    	$("[data-toggle='popover']").on('shown.bs.popover', function () {
		 		
		 		//initate popover links
		 		$(".modal-view").on('click', function(e){
		 			e.preventDefault();
		 			
		 			var view,
		    		buttonAction;
		    	
		    		view = $(event.currentTarget).attr("data-modal-view");
		 			
		 			switch (view) {
						
						case 'addVideo':
							buttonAction = new addVideoView({el:"#inventoryModal .modal-content", model:me.model});
							buttonAction.render().$el;
							
				 			Util.displayModal(buttonAction);
							break;
							
						case 'deleteVideos':
							Util.deleteItemMetaView();
							break;
							
						default:
							console.log("error");	
					};
					
		 		});
		 		
	 		});
	    },
	    
	    deleteVideos: function(e){
	    	e.preventDefault();
	    }
	    
	});
	
	return VideoListThumbView;
 
});