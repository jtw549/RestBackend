/*
 * this is the model to manage the user categories
 * 			 
 */

define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Rest		= require('rest'),
        AppSettings = require('appSettings');
     ;
 
	var CategoryModel = Backbone.Model.extend({
		
		defaults:{
	        selectedId:0,
	        data:[]
        },
	        
        initialize: function(){
        	this.model = this;
        },
        
        categoryData:[],
        
        rest: function (action, data, callback){
        	var me = this;
        	
        	//make api call 
        	Rest.sendRequest('POST', data, AppSettings.api + AppSettings.endpoints[action], function(response){
	    		var data = $.parseJSON(response.responseText);
	    		
	    		//switch statement for the different response messages
				switch (response.status) {
					case 201:
						//cache the data
						//me.setCategoryData(data.categories.data);
						//me.defaults.data.push(data);
						me.categoryData.push(data);
						
						//TODO: set the selected Id based on the response property
						
						break;
					case 'failed':
						console.log("failed");
						
						break;
					default:
						console.log("error");	
				};
				
	    		callback(response);
	    		
		 	});
        }
        
	});
	
	return new CategoryModel;
	
});