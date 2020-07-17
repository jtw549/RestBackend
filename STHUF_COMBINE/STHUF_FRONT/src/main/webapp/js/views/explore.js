define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        tpl         = require('text!../../templates/explore.html'),
 
        template = _.template(tpl);
 
	var ExploreView = Backbone.View.extend({
		el: $("#main-content .container"),
		
        render: function () {
        	//var signInView = new SignInView ();
	        //var cartListView = new CartList();
	        
            this.$el.html(template());
            return this;
        }
	});
	
	return ExploreView;
 
});