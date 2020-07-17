/*
 * this is the view to display the item info including photos, videos, receipts, etc
 * 
 * requires the Item model
 */

define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
        Util		= require('util'),
        
        //models
        ItemModel 	= require('models/itemModel'),
        
        //views
        editItemView  = require('views/items/editItemView'),
        photoListThumbView  = require('views/photos/photoListThumbView'),
        videoListThumbView  = require('views/videos/videoListThumbView'),
        noteListView      	= require('views/notes/noteListView'),
        receiptListThumbView      	= require('views/receipts/receiptListThumbView'),
        warrantyView      	= require('views/warranty/warrantyView'),
        commentListView     = require('views/comments/commentListView'),
        shareView     = require('views/share/shareView'),
        sellView     = require('views/ecommerce/sellView'),
        
        //templates
        itemDetailViewTmpl  = require('text!../../../templates/items/itemDetailView.html');
 
	var ItemDetailView = Backbone.View.extend({
		
		customEvt: null,
		
		initialize:function(options){
			//init custom events
			this.customEvt = options.customEvt;
			
			//bind item selected event
	        this.customEvt.on("item:selected", this.render, this);
	    },
		
        render: function () {
        	var items,
        		itemId,
        		template;
        	
        	//get instance selected id
        	itemId = ItemModel.model.get("selectedId");
        	
        	//get instance items
        	items = $.parseJSON(ItemModel.model.get("data"));
        	
        	//display selected item
	 		filteredItem = Util.filterItem(items, itemId);
	 		template = Handlebars.compile(itemDetailViewTmpl);
	 		this.$el.html(template(filteredItem));
		 	
	 		//init tabs
		 	this.initItemDetailTabs();
		 	
		 	//init popover
		 	this.initDetailPopoverLinks();
		 	
		 	Util.changeHeight();
	    	
            return this;
        },
        
        events: {
	       
	    },
	    
	    initItemDetailTabs: function(){
	    	var me = this,
	    		tabView,
 				tabAction = "",
 				tabActionEl
 			;
	    	
	    	$('.nav-item-tabs a').click(function (tab) {
		 		tab.preventDefault();
		 		
		 		tabView = $(tab.currentTarget).attr("data-tab-view");
		 		
		 		//if(tabAction != ""){
					//currentView.remove();
		 		//	tabAction.undelegateEvents();
				//}	
				
		 		switch (tabView) {
		 			case 'itemInfo':
		 				me.render();
						break;
					case 'itemPhotos':
						tabAction = new photoListThumbView({model:me.model});
						tabActionEl = ".tab-pane .tab-pane-container .item-photos";
						break;
					case 'itemVideos':
						tabAction = new videoListThumbView({model:me.model});
						tabActionEl = ".tab-pane .tab-pane-container .item-videos";
						break;
					case 'itemNotes':
						tabAction = new noteListView({model:me.model});
						tabActionEl = ".tab-pane .tab-pane-container .item-notes";
						break;
					case 'itemReceipts':
						tabAction = new receiptListThumbView({model:me.model});
						tabActionEl = ".tab-pane .tab-pane-container .item-receipts";
						break;
					case 'itemWarranty':
						tabAction = new warrantyView({model:me.model});
						tabActionEl = ".tab-pane .tab-pane-container .item-warranty";
						break;
					case 'itemComments':
						tabAction = new commentListView({model:me.model});
						tabActionEl = ".tab-pane .tab-pane-container .item-comments";
						break;
					case 'itemShare':
						tabAction = new shareView({model:me.model});
						tabActionEl = ".tab-pane .tab-pane-container .item-share";
						break;
					case 'itemEcommerce':
						tabAction = new sellView({model:me.model});
						tabActionEl = ".tab-pane .tab-pane-container .item-ecommerce";
						break;
						
					default:
						console.log("error");	
				};
				
				//render selected data template
				if(tabAction != ""){
					Util.changeSubView(tabAction);
					tabAction.render().$el.appendTo(tabActionEl);
				}
				
				//tabAction.render().$el;
				
				//show selected tab content
	 			$(this).tab('show');
			 	
	 		});
	    },
	    
	    initDetailPopoverLinks: function(){
        	var me = this;
	    	
        	Util.initItemDetailViewPopover();
        	
	    	$("[data-toggle='popover']").on('shown.bs.popover', function () {
	    		
	    		var itemPopover = $(this);
		 		
		 		//initate popover links
		 		$(".modal-view").on('click', function(e){
		 			e.preventDefault();
		 			
		 			var view,
		 				buttonAction;
		    	
		    		view = $(event.currentTarget).attr("data-modal-view");
		 			
		 			switch (view) {
						case 'editInfo':
							$(".item-info .table-responsive").hide();
							editItem = new editItemView({el:".item-info", model:me.model});
							editItem.render().$el;
							
							break;
							
						default:
							console.log("error");	
					};
					
					itemPopover.popover("hide");
		 		});
		 		
	 		});
	    }
        
        
	});
	
	return ItemDetailView;

});