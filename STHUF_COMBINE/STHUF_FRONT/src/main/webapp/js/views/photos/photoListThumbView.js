/*
 * this is the view to display the item photos in thumbview format
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
        
        //views
        addPhotoView = require('views/photos/addPhotoView'),
    
        //include the home content template
        photoListThumbViewTmpl      = require('text!../../../templates/photos/photoListThumbView.html'),
        item
    ;
    	
	var PhotoListThumbView = Backbone.View.extend({
		
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
        	
        	template = Handlebars.compile(photoListThumbViewTmpl);
        	this.$el.html(template(item));
        	
        	//initiate popover links for Notes
        	this.initPhotosPopoverLinks();
        	
            return this;
        },
        
        events: {
	        'click .delete-photos': 'deletePhotos'
	    },
        
        initPhotosPopoverLinks: function(){
        	var me = this;
	    	
        	//initiate the popover for each tab
        	Util.initItemDetailViewPopover();
        	
	    	$("[data-toggle='popover']").on('shown.bs.popover', function () {
		 		
		 		//initate popover links
		 		$(".modal-view").on('click', function(e){
		 			e.preventDefault();
		 			
		 			var view,
		    		buttonAction;
		    	
		    		view = $(event.currentTarget).attr("data-modal-view");
		 			
		 			switch (view) {
						
						case 'addPhoto':
							buttonAction = new addPhotoView({el:"#inventoryModal .modal-content", model:me.model});
							buttonAction.render().$el;
							
				 			Util.displayModal(buttonAction);
							break;
							
						case 'deletePhoto':
							Util.deleteItemMetaView();
							break;
							
						default:
							console.log("error");	
					};
		 		});
	 		});
	    },
	    
	    deletePhotos: function(e){
	    	e.preventDefault();
	    }
	    
	});
	
	return PhotoListThumbView;
 
});