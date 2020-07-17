/*
 * this is the view to display the header when the user is logged in
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
        Util		= require('util'),
        
        User		= require('../../models/userModel'),
    
        //include the home content template
    	homeContentViewTmpl  = require('text!../../../templates/home/homeContentView.html')
    ;
    	
	var HomeContentView = Backbone.View.extend({
	
		//el: $("#main-content .container"),
		
	    initialize: function() {
	        _.bindAll(this, 'render', 'registerUser');
	    },
		
        render: function () {
        	var template;
        	
        	template = Handlebars.compile(homeContentViewTmpl);
        	this.$el.html(template());
        	
            return this;
        },
        
        events: {
	        'submit .sign-up-form' : 'registerUser'
	    },

	    registerUser: function(event) {
	    	event.preventDefault();
	    	
	    	var AppSettings = require('appSettings'),
	    		data,
	    		user,
	    		email,
	    		pwd,
	    		firstName,
	    		lastName;
	    	
	    	//validate form submission
	    	
	    	//create data object
	    	firstName = $("#firstName").val();
	    	lastName = $("#lastName").val();
	    	email = $("#registerEmail").val();
	    	pwd = $("#registerPassword").val();
	    	
	    	data = {
	    		"userId": 5000,	
		        "firstName": firstName,
		        "lastName": lastName,
		        "email": email,
		        "metaPsd": pwd
	    	};
	    	
	    	//register user using user model
	    	user = new User();
	    	user.rest("registerUser", data, function(response){
	    		//console.log(response);
	    		var responseData = $.parseJSON(response.responseText);
	    		
	    		//user is not authenticated
	    		switch (response.status) {
					case 201:
						//console.log(authUser.status);
		    			userId = responseData.userId;
		    			
		    			AppSettings.router.navigate("#/inventory/" + userId, {trigger: true});
	    			break;
	    			
					default:
			    		console.log("failedAuthenticated");
	    		};	
	    	});
	    	
	    }
	});
	
	return HomeContentView;
 
});