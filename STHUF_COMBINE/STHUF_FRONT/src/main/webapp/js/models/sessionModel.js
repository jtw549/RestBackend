/*
 * this is the model to manage the user session
 * 			 
 */

define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        
        Rest		= require('rest'),
        AppSettings = require('appSettings'),
        
        UserModel	= require('models/userModel'),
        ItemModel		= require('models/itemModel'),
        CategoryModel	= require('models/categoryModel')
     ;
 
	var SessionModel = Backbone.Model.extend({
		
		defaults: {
			//userId of the login user
			userId: "",
			firstName: "",
	        lastName: "",
	        email: "",
	        bio: "",
	        privacy: "",
			//set the token id
			token: ""
        },

        initialize: function(){
        	this.model = this;
        },

        sessionData: {},
        
        rest: function(action, data, callback){
        	var me = this;
        	
        	//make call login endpoint 
        	Rest.sendRequest('POST', data, AppSettings.api + AppSettings.endpoints[action] , function(response){
	    		var data  = $.parseJSON(response.responseText);
	    		
	    		//switch statement for the different response messages
				switch (response.status) {
					case 200:
						if(action == "login"){
							
							var category,
								item,
								user;
							
							//set Session object
							//me.sessionData.userId = data.users.userId;
							me.model.set({
								userId: data.users.userId,
								firstName: data.users.firstName,
								lastName: data.users.lastName,
								privacy: data.users.privacy
							});
							
							//set User object and user id
							//user = new UserModel();
							//user.setSelectedId(data.users.userId);
							UserModel.model.set({
								selectedId: data.users.userId,
								firstName: data.users.firstName,
								lastName: data.users.lastName
							});
							
							
							//item = new ItemModel();
							//item.setItemData(data.users.usersInventories);
							//console.log(item.getItemData());
							ItemModel.itemData = data.users.usersInventories;
							
							//category = new CategoryModel();
							//category.setCategoryData(data.users.usersCategories);
							//console.log(category.getCategoryData());
							CategoryModel.categoryData = data.users.usersCategories;
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
	
	return new SessionModel;
	
});