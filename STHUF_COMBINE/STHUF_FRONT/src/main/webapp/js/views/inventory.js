/*
 * this is the view to display the inventory page
 * sub views: 
 * 		1.nonLoginHeaderView
 * 		2.categoryListView
 * 		3.itemListView
 * 		4.itemThumbView	 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Util		= require('util'),
        
        //Item		= require('models/itemModel'),
        UserModel = require('models/userModel'),
        SessionModel = require('models/sessionModel'),

        nonLoginHeaderView 	=	require('views/header/nonLoginHeaderView'),
        categoryListView	= require('views/categories/categoryListView'),
        itemListView	= require('views/items/itemListView'),
        itemListThumbView	= require('views/items/itemListThumbView'),
        
        //include the inventory parent page template
        inventoryTemplate         = require('text!../../templates/inventory.html'),
        inventoryPageTemplate = _.template(inventoryTemplate),
        
        customEvt,
        userId
        
    ;	
 
	var InventoryView = Backbone.View.extend({
		
		customEvt: null,
		
		initialize:function(){
			var userSession,
			loginUser,
    		user,
    		nonLoginUserId,
    		customEvt;
    	
	    	//get login user id
			//userSession = new SessionModel();
	    	//loginUser = userSession.getSessionData();
			//loginUser = SessionModel.getSessionData();
			loginUser = SessionModel.model.get("userId");
	    	
	    	//get the non login user - the id of the user the login user is visiting
	    	//user = new UserModel();
	    	//userId = user.getSelectedId();
			userID = UserModel.model.get("userId");
			
	    	
	    	if(loginUser.userId != userId){
	    		//get non login user items
	    	}
	    	
	    	//init custom events
	    	this.customEvt = _.extend({}, Backbone.Events);
	    	
	    	//array of child views
			this.childViews = [];
	    	
	    },
		
        render: function () {
        	
        	this.getSubViews();
            
            return this;
        },
        
        getSubViews: function(){
        	
        	//add the inventory page template
            this.$el.append(inventoryPageTemplate());
            
        	//add the non-login header sub view
            /*this.nonLoginHeader = new nonLoginHeaderView({el:"#header"});
            this.nonLoginHeader.render().$el;

            //add the categories list sub view
            this.categoryList = new categoryListView({el:"#theCategories", customEvt: this.customEvt});
            this.categoryList.render().$el;
            
            //add the item list sub view
            this.itemList = new itemListView({el:"#theItems", customEvt: this.customEvt});
            this.itemList.render().$el;*/
            
            this.nonLoginHeader = new nonLoginHeaderView();
            this.nonLoginHeader.render().$el.appendTo("#header");
            
            this.categoryList = new categoryListView({customEvt: this.customEvt});
            this.categoryList.render().$el.appendTo("#theCategories");
            
            this.itemList = new itemListView({customEvt: this.customEvt});
            this.itemList.render().$el.appendTo("#theItems");
            
            Util.changeHeight();
            
            //add subviews to childViews array
            this.childViews.push(this.categoryList);
            this.childViews.push(this.itemList);
            
            //add the item thumb sub view
            //this.itemListThumbs = new itemListThumbView({el:"#content", customEvt: this.customEvt});
            //this.itemListThumbs.render().$el;
            
            //this.itemDetail = new itemDetailView({el:"#content", customEvt: this.customEvt});
            //this.itemDetail.render().$el;
        },
        
        getItems: function(){
        	var data,
    			user,
    			me = this;
	    	
	    	//create data object
	    	/*data = {
    			"items": {
    		        "userId": "SA0IE44T4UPTVAWB5YE"
    		    }
	    	};*/
        	
		    data = "userId=SA0IE44T4UPTVAWB5YE";
	    	
	    	//authenticate user using session model
	    	items = new ItemModel();
	    	items.getItems(data, function(response){
	    		//console.log(response);
	    		var data = $.parseJSON(response);
	    		
	    		//user is not authenticated
	    		if(data.status == "success"){
	    			me.getSubViews();
	    			console.log("success");
	    		}
	    		else{
	    			console.log("failedAuthenticated");
	    		}
	    	});
        },
        
        closeSubViews: function(){
            // close each subview
            _.each(this.childViews, function(childView){
            	Util.closeView(childView);
	        });
        }
	});
	
	return InventoryView;

 
});