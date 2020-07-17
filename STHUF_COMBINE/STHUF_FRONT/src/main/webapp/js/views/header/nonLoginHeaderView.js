/*
 * this is the view to display the header when the user is logged in
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Util		= require('util'),
        Rest		= require('rest'),
        Handlebars	= require('handlebars'),
    
        //include the item collection template
    	nonLoginHeaderViewTmpl  = require('text!../../../templates/header/nonLoginHeaderView.html'),
    	nonLoginHeaderViewTemplate = _.template(nonLoginHeaderViewTmpl)
    ;
    	
	var NonLoginHeaderView = Backbone.View.extend({
	
		//el: $("#main-content .container"),
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	    },
		
        render: function () {
            this.$el.html(nonLoginHeaderViewTemplate);
            return this;
        }
        
        
	});
	
	return NonLoginHeaderView;
 
});