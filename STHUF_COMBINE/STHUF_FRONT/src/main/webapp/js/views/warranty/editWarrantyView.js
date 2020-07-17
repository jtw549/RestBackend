/*
 * this is the view to display the edit warranty page
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
    	editItemWarrantyTmpl = require('text!../../../templates/warranty/editWarrantyView.html')
    ;
    	
	var EditWarrantyView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	    },
		
        render: function () {
        	var items,
        		itemId;
        	
        	items = $.parseJSON(this.model.get("data"));
        	itemId = this.model.get("selectedId");
        	
        	filteredItem = Util.filterItem(items, itemId);
        	
            template = Handlebars.compile(editItemWarrantyTmpl);
            this.$el.append(template(filteredItem));
            
            $("#issuer").focus();
            
            return this;
        },
        
        events: {
        	'click .edit-info-form button.btn-primary' : 'editWarranty'
	    },
        
	    editWarranty: function(event) {
	    	event.preventDefault();

        }
	});
	
	return EditWarrantyView;
 
});