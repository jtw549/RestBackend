/*
 * this file is to initiate the application
 * 			 
 */
define(function(require){

	var $			= require('jquery'),
		_ 			= require('underscore'),
		Backbone	= require('backbone'),
		Bootstrap	= require('bootstrap'),
		AppRouter 	= require('router'),
		SessionModel	= require('models/sessionModel'),
		AppSettings	= require('appSettings'),
		SthufTest
	;

    var initialize = function(){
    	
		//init sinon
		if(AppSettings.initTest){
			SthufTest = require('localTest/fakeServerMain');
			SthufTest.initTestServer();
		}
		
		// global router variable 
		AppSettings.router = new AppRouter();
	    
	    //initiate history
	    Backbone.history.start();
    	    
	}

	return {
		initialize: initialize
	};

});