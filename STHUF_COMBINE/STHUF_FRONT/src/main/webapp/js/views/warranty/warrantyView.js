/*
 * this is the view to display the item warranty view
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
        editWarrantyView	= require('views/warranty/editWarrantyView'),
        
        //include the home content template
        warrantyViewTmpl      = require('text!../../../templates/warranty/warrantyView.html'),
        
        item
    ;
    	
	var warrantyView = Backbone.View.extend({
	
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
        	
        	template = Handlebars.compile(warrantyViewTmpl);
        	this.$el.html(template(item));
        	
        	//initiate the popover for each tab
        	//Util.initItemDetailViewPopover();
        	
        	//initiate popover links for Warranty
        	//this.initWarrantyPopoverLinks();
        	
            return this;
        },
        
        events: {
	        //'submit .sign-up-form' : 'registerUser'
	    },
	    
	    initWarrantyPopoverLinks: function(){
        	var me = this;
	    	
	    	$("[data-toggle='popover']").on('shown.bs.popover', function () {
		 		
	    		var warrantyPopover = $(this);
	    		
		 		//initate popover links
		 		$(".modal-view").on('click', function(e){
		 			e.preventDefault();
		 			
		 			var view,
		    		buttonAction;
		    	
		    		view = $(event.currentTarget).attr("data-modal-view");
		 			
		 			switch (view) {
						
						case 'editWarranty':
							$(".item-warranty .table-responsive").hide();
							editWarranty = new editWarrantyView({el:".item-warranty", model:me.model});
							editWarranty.render().$el;
							
							break;
							
						default:
							console.log("error");	
					};
					
					warrantyPopover.popover("hide");
					
		 		});
		 		
	 		});
	    },
	    
	});
	
	return warrantyView;
 
});