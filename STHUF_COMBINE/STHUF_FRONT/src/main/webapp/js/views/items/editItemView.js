/*
 * this is the view to display the edit item info page
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
        Util		= require('util'),
        
        //templates
    	editItemTmpl = require('text!../../../templates/items/editItemView.html')
    ;
    	
	var EditInfoView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	    },
		
        render: function () {
        	var items,
        		itemId;
        	
        	items = $.parseJSON(this.model.get("data"));
        	itemId = this.model.get("selectedId");
        	
        	filteredItem = Util.filterItem(items, itemId);
        	
            template = Handlebars.compile(editItemTmpl);
            this.$el.append(template(filteredItem));
            
            $("#make").focus();
            
            return this;
        },
        
        events: {
        	'click .edit-info-form button.btn-primary' : 'editInfo'
	    },
        
        editInfo: function(event) {
	    	event.preventDefault();

        }
	});
	
	return EditInfoView;
 
});