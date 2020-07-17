/*
 * this is the model to manage the user items
 * 			 
 */

define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Rest		= require('rest'),
        AppSettings = require('appSettings')
    ;
 
	var ItemModel = Backbone.Model.extend({
	
        defaults:{
	        selectedId:0,
	        data:[]
        },
        
        initialize: function(){
        	this.model = this;
        },
        
        itemData:[],
        
        rest: function (action, type, data, callback){
        	var me = this;
        	
        	//make api call 
        	Rest.sendRequest('POST', data, AppSettings.api + AppSettings.endpoints[action], function(response){
	    		var data = $.parseJSON(response);
	    		
	    		//switch statement for the different response messages
				switch (data.status) {
					case 'success':
						
						if(type == "item"){
							//me.defaults.data = data;
							
						}
						else if(type == "note"){
							
							/*_.each(me.getItemData(), function(item) {
			    				if(item.id == me.getSelectedId){
			    					item.notes = data;
			    					//itemData.setItemData(data);
			    				}
			    		    });*/
						}
						else if(type == "comment"){
							/*_.each(me.getItemData(), function(item) {
			    				if(item.id == me.getSelectedId){
			    					myItem.comments = data;
			    					//itemData.setItemData(data);
			    				}
		    		   		});*/
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
	
	return new ItemModel; 
});