/*
 * this is the view to display the header when the user is logged in
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        
        Session		= require('models/sessionModel'),
        
        //include the login header template
    	loginHeaderViewTmpl  = require('text!../../../templates/header/loginHeaderView.html')
    ;
    	
	var LoginHeaderView = Backbone.View.extend({
	
		//el: $("#main-content .container"),
		
	    initialize: function() {
	        //_.bindAll(this, 'render', 'login');
	    },
		
        render: function () {
        	var template;
        	
        	template = Handlebars.compile(loginHeaderViewTmpl);
        	this.$el.html(template());
	 		
            return this;
        },
        
        events: {
	        'click #navbarLogin .navbar-login-form .btn-primary' : 'login'
	    },
	    
	    login: function(event) {
	    	event.preventDefault();
	    	
	    	var AppSettings = require('appSettings'),
	    		data,
	    		user,
	    		email,
	    		pwd;
	    	
	    	//validate form submission
	    	
	    	//create data object
	    	email = $("#email").val();
	    	pwd = $("#password").val();
	    	
	    	//prepare data object
	    	data = {
    	        "email": email,
    	        "metaPsd": pwd
	    	};
	    	
	    	//authenticate user using session model
	    	//user = new Session();
	    	Session.rest("login", data, function(response){
	    		//console.log(response); 
	    		var data = $.parseJSON(response.responseText),
	    			userId;
	    		
	    		//user is not authenticated
	    		switch (response.status) {
					case 200:
			    			//console.log(authUser.status);
			    			userId = data.users.userId;
			    			
			    			//redirect to inventory page
			    			AppSettings.router.navigate("#/inventory/" + userId, {trigger: true});
		    			
		    			break;
		    			
					default:
			    		console.log("failedAuthenticated");
	    		};
	    	});
	    	
	    }
        
	});
	
	return LoginHeaderView;
 
});