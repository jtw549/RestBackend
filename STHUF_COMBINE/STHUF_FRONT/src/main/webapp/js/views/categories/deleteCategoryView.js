/*
 * this is the view to display the delete category view
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
        
    	deleteCategoryTmpl         = require('text!../../../templates/categories/deleteCategoryView.html'),
    	categoryInstance
    ;
    	
	var DeleteCategoryView = Backbone.View.extend({
		
	    initialize: function() {
	        _.bindAll(this, 'render');

	        categoryInstance = CategoryModel;
	    },
		
        render: function () {
        	var template;
        	
            template = Handlebars.compile(deleteCategoryTmpl);
            this.$el.html(template());
            
            return this;
        },
        
        events: {
        	'click #modalSubmit' : 'deleteCategory'
	    },
	    
	    deleteCatSuccess: function() {
	    	console.log('Delete Cat Success!!');

	    	//hide modal
	    	$("#inventoryModal").modal('hide');
	    },
	    
	    deleteCategory: function(event) {
	    	event.preventDefault();
	    	
	    	var categoryToDeleteId = categoryInstance.model.get("selectedId");
	    		catToDelete = $("#categories-column .active").text(),
	    		deleteCatData,
	    		apiResponse,
	    		me = this;
	    	console.log("catToDelete: " + catToDelete);
	    	
	    	if (catToDelete) {
	    		deleteCatData = {
	    			"userId": SessionModel.model.get("userId"),
	    			"categoryId": categoryToDeleteId
	    		};
	    		
	    		categoryInstance.rest("deleteCategory", deleteCatData, function(response){
	    			/*TODO: refresh the category list. use selectedId to highlight the last category that was added.
	    			*/
	    			apiResponse = $.parseJSON(response.responseText);
	    			
	    			switch (response.status) {
						case 200:
			    			// var categories = JSON.stringify(categoryInstance.getCategoryData());
							var categories = JSON.stringify(categoryInstance.categoryData);
			    			
			    			//update the categories instance. will trigger model change:data event
			    			categoryInstance.model.set({
			    				data:categories
			    			});
			    			
			    			me.deleteCatSuccess();
			    			
			    			break;
		    		
						case 'failed':
							console.log("failed");
							
							break;
							
						default:
							console.log("error");	
					};
	    		});
	    	}
	    }
        
	});
	
	return DeleteCategoryView;
 
});