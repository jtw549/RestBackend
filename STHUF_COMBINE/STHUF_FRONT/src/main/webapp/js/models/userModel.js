/*
 * this is the model to manage the user
 * 			 
 */

define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        
        Rest		= require('rest'),
        AppSettings = require('appSettings'),
        
        ItemModel		= require('models/itemModel'),
        CategoryModel	= require('models/categoryModel')        
     ;
 
    
	var UserModel = Backbone.Model.extend({
		
		defaults: {
			selectedId:0,
            firstName: "",
            lastName: ""
        },

        initialize: function(){
        	this.model = this;
        },
        
        rest: function (action, data, callback){
        	var me = this;
        	
        	//make call to registerUser endpoint
        	Rest.sendRequest('POST', data, AppSettings.api + AppSettings.endpoints[action], function(response){
	    		var data = $.parseJSON(response.responseText),
	    			SessionModel = require('models/sessionModel')
	    		;
	    		
	    		//switch statement for the different response messages
				switch (response.status) {
					case 201:
						
						if(action == "registerUser"){
							var item,
								category,
								session,
								dataObj = {}
							;
							
							dataObj = {
								userId: data.userId,
								token: ""
							};
							
							//set the session model
							session = new SessionModel();
							session.setSessionData(dataObj);
							
							//set the user session data
							me.setUser(data);
							//console.log(data.user);
							//set the selected user id
							me.setSelectedId(data.userId);
					    	
							//var item = new ItemModel();
							//item.setItemData(data.users.usersInventories);
							//console.log(data.user.items);
							
							//category = new CategoryModel();
							//category.setCategoryData(data.users.usersCategories);
							//console.log(data.user.categories);
						}
						else if(action == "updateUser"){
							
						}
						else if(action == "deleteUser"){
							
						}	
						
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
	
	return new UserModel;
	
});