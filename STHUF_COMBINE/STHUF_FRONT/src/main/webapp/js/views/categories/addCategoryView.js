/*
 * this is the view to display the add category page
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
        //models
        CategoryModel = require('models/categoryModel'),
        SessionModel = require('models/sessionModel'),
        
    	addCategoryTmpl         = require('text!../../../templates/categories/addCategoryView.html'),
    	categoryInstance
    ;
    	
	var AddCategoryView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	        
	        categoryInstance = CategoryModel;
	    },
		
        render: function () {
        	var template;
        	
            template = Handlebars.compile(addCategoryTmpl);
            this.$el.html(template());
            return this;
        },
        
        events: {
        	'click #modalSubmit' : 'addCategory'
	    },
	    
	    addCatSuccess: function() {
	    	console.log('Add Cat Success!!');

	    	//hide modal
	    	$("#inventoryModal").modal('hide');
	    	$('#categoryNameTxt').val('')
	    },
	    
	    addCategory: function(event) {
	    	event.preventDefault();
	    	var newCatName = $('#categoryNameTxt').val(),
	    		addCatData,
	    		me = this,
	    		apiResponse;
	    	
	    	if (newCatName) {
	    		addCatData = {
	    			"userId": SessionModel.model.get("userId"),
	    			"categoryName": newCatName,
	    		};
	    		
	    		categoryInstance.rest("addCategory", addCatData, function(response){
	    			/*TODO: refresh the category list. use selectedId to highlight the last category that was added.
	    			*/
	    			apiResponse = $.parseJSON(response.responseText);
	    			
	    			switch (response.status) {
						case 201:
			    			//var categories = JSON.stringify(categoryInstance.getCategoryData());
							var categories = JSON.stringify(categoryInstance.categoryData);
			    			
			    			//update the categories instance. will trigger model change:data event
							categoryInstance.model.set({
			    				data:categories
			    			});
			    			
			    			me.addCatSuccess();
			    			
			    			break;
		    		
						case 'failed':
							console.log("failed");
							
							break;
							
						default:
							console.log("error");	
					};
	    		});
	    		
	    	} else {
	    		//display error message
	    	}
	    }
	});
	
	return AddCategoryView;
 
});