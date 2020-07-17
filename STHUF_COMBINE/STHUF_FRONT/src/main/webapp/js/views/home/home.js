define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        
        Util		= require('util'),
        
        loginHeaderView 	= require('views/header/loginHeaderView'),
        homeContentView		= require('views/home/homeContentView')
        
        ;
 
	var HomeView = Backbone.View.extend({
		
		initialize:function(){
			//array of child views
			this.childViews = [];
	    },
	    
        render: function () {
        	
        	//add the login header sub view
            //this.loginHeader = new loginHeaderView({el:"#header"});
        	this.loginHeader = new loginHeaderView();
            this.loginHeader.render().$el.appendTo("#header");
            
            //add the home content sub view
            //this.homeContent = new homeContentView({el:"#main-content .container"});
            this.homeContent = new homeContentView();
            this.homeContent.render().$el.appendTo("#main-content .container");
            
            //add subviews to childViews array
            this.childViews.push(this.loginHeader);
            this.childViews.push(this.homeContent);
            
            return this;
        },
        
        closeSubViews: function(){
            // handle other unbinding needs, here
            _.each(this.childViews, function(childView){
            	//if (childView.close){
	            //  childView.close();
	            //}
            	Util.closeView(childView);
            	
	        });
        }
	});
	
	return HomeView;
 
});