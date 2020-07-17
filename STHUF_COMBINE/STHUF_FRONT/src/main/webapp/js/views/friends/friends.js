define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        tpl         = require('text!../../../templates/friends/friends.html'),
 
        template = _.template(tpl);
 
	var FriendsView = Backbone.View.extend({
		el: $("#main-content .container"),
		
		initialize:function(){
			this.render();
	    },
	    
        render: function () {
            this.$el.html(template());
            return this;
        }
	});
	
	return FriendsView;

 
});