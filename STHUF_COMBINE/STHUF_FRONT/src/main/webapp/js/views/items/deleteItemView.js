/*
 * this is the view to display the delete item page
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
    	deleteItemTmpl         = require('text!../../../templates/items/deleteItemView.html'),
    	deleteItemTemplate = _.template(deleteItemTmpl)
    ;
    	
	var DeleteItemView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	        //this.render();
	    },
		
        render: function () {
            this.$el.html(deleteItemTemplate);
            return this;
        },
        
        events: {
        	'click #deleteItemForm button' : 'deleteItem'
	    },
	    
	    deleteItem: function (event) {	    	
	    	
        }
        
	});
	
	return DeleteItemView;

});