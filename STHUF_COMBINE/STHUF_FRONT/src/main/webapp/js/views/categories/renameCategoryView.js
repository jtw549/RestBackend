/*
 * this is the view to display the rename category view
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
    	renameCategoryTmpl         = require('text!../../../templates/categories/renameCategoryView.html'),
    	renameCategoryTemplate = _.template(renameCategoryTmpl)
    ;
    	
	var RenameCategoryView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	        //this.render();
	    },
		
        render: function () {
            this.$el.html(renameCategoryTemplate);
            return this;
        },
        
        events: {
	        
	    }
        
	});
	
	return RenameCategoryView;
 
});