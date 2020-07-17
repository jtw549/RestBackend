/*
 * this is the view to display the item share view
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
        shareViewTmpl      = require('text!../../../templates/share/shareView.html'),
        item
    ;
    	
	var ShareView = Backbone.View.extend({
	
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
        	
        	template = Handlebars.compile(shareViewTmpl);
        	this.$el.html(template(item));
        	
        	//initiate the popover for each tab
        	Util.initItemDetailViewPopover();
        	
        	//initiate popover links for Notes
        	//this.initPhotosPopoverLinks();
        	
            return this;
        },
        
        events: {
	        //'submit .sign-up-form' : 'registerUser'
	    }
	    
	});
	
	return ShareView;
 
});