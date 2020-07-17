/*
 * this is the view to display the item receipts in thumbview format
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
    
        //include the home content template
        receiptListThumbViewTmpl      = require('text!../../../templates/receipts/receiptListThumbView.html'),
        item
    ;
    	
	var ReceiptListThumbView = Backbone.View.extend({
	
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
        	
        	template = Handlebars.compile(receiptListThumbViewTmpl);
        	this.$el.html(template(item));
        	
        	//initiate the popover for each tab
        	Util.initItemDetailViewPopover();
        	
        	//initiate popover links for Notes
        	this.initReceiptsPopoverLinks();
        	
            return this;
        },
        
        initReceiptsPopoverLinks: function(){
        	var me = this;
	    	
	    	$("[data-toggle='popover']").on('shown.bs.popover', function () {
		 		
		 		//initate popover links
		 		$(".modal-view").on('click', function(e){
		 			e.preventDefault();
		 			
		 			var view,
		    		buttonAction;
		    	
		    		view = $(event.currentTarget).attr("data-modal-view");
		 			
		 			switch (view) {
						
						case 'addReceipt':
							buttonAction = new addPhotoView({el:"#inventoryModal .modal-content", model:me.model});
							buttonAction.render().$el;
							
				 			Util.displayModal(buttonAction);
							break;
							
						case 'deleteReceipt':
							Util.deleteItemMetaView();
							break;
							
						default:
							console.log("error");	
					};
		 		});
	 		});
	    },
        
        events: {
	        //'submit .sign-up-form' : 'registerUser'
	    }
	    
	});
	
	return ReceiptListThumbView;
 
});