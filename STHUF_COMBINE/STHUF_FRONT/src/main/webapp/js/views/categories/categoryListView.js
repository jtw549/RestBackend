/*
 * this is the view to display the category section on the inventory page
 * 			 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Util		= require('util'),
        AppSettings = require('appSettings'),
        
        UserModel		= require('models/userModel'),
        CategoryModel = require('models/categoryModel'),
        ItemModel 	= require('models/itemModel'),
        
        addCategoryView	= require('views/categories/addCategoryView'),
        renameCategoryView	= require('views/categories/renameCategoryView'),
        deleteCategoryView	= require('views/categories/deleteCategoryView'),
        
        categoryListTmpl         = require('text!../../../templates/categories/categoryListView.html'),
	    itemListTmpl         = require('text!../../../templates/items/itemListView.html'),
	    itemListThumbViewTmpl         = require('text!../../../templates/items/itemListThumbView.html')
	    
	;
    
	var CategoryListView = Backbone.View.extend({
		
		customEvt: null,
		
		userId: null,
		
		tagName: "div",
		
	    initialize: function(options) {
	        _.bindAll(this, 'render', 'getItemsByCategory');
	        var Category,
	        	categories;
	        
	        //init the model
	        //Category = new CategoryModel();
	        //this.model = Category;
	        this.model = CategoryModel;
	        //get the categories
	        //categories = JSON.stringify(Category.getCategoryData());
	        categories = JSON.stringify(CategoryModel.categoryData);
        	
	        //set the categories for the instance
        	this.model.set({
				data:categories
			});
        	
        	//bind the item model and call render when the data changes
        	this.model.bind('change:data', this.render);
        	
        	//init custom events
        	this.customEvt = options.customEvt;
	    },
		
        render: function () {
        	var template;
        	
	    	template = Handlebars.compile(categoryListTmpl);
        	this.$el.html(template($.parseJSON(this.model.get("data"))));
        	
            Util.changeHeight();
            
        	return this;
        },
	    
	    events: {
	        'click #categories-column .list-group-item a' : 'getItemsByCategory',
	        'click #addCategory' : 'addCategory',
	        'click #renameCategory' : 'renameCategory',
	        'click #deleteCategory' : 'deleteCategory'
	    },

	    getItemsByCategory: function(event) {
	    	event.preventDefault();
	    	var categoryId,
	    		item,
	    		itemsObject = [],
	    		data,
	    		template,
	    		filterObject;
	    	
	    	//highlight selected item
		 	$("#categories-column .list-group-item").removeClass("active");
		 	$(event.currentTarget).parent().addClass("active");
		 	
		 	//get the selected category and set the category id
		 	categoryId = $(event.currentTarget).attr("data-catId");
		 	this.model.set({
		 		selectedId:categoryId
			});
		 	
		 	//trigger the category selected event
		 	this.customEvt.trigger("category:selected", this.model);
		 	
		 	//change the url
		 	AppSettings.router.navigate("#/inventory/category/" + categoryId, {trigger: false});
		 	
	    },
	    
	    addCategory: function(event) {
	    	event.preventDefault();

	    	var addCategory;
	    	
	    	//add template
	    	addCategory = new addCategoryView({el:"#inventoryModal .modal-content"});
            addCategory.render().$el;
	    	
	    	//display modal
            Util.displayModal(addCategory);
	    	
	    },
	    
	    renameCategory: function(event) {
	    	event.preventDefault();

	    	var renameCategory;
	    	
	    	//add template
	    	renameCategory = new renameCategoryView({el:"#inventoryModal .modal-content"});
	    	renameCategory.render().$el;
	    	
	    	//display modal
	    	Util.displayModal(renameCategory);
	    	
	    },
	    
	    deleteCategory: function(event) {
	    	event.preventDefault();

	    	var deleteCategory,
	    		catToDelete;
	    	
	    	//add template
	    	deleteCategory = new deleteCategoryView({el:"#inventoryModal .modal-content"});
	    	deleteCategory.render().$el;
	    	
	    	catToDelete = $("#categories-column .active .category-name").text();
	    	$("#categoryName").text(catToDelete);
	    	
	    	//display modal
	    	Util.displayModal(deleteCategory);
	    }
        
	});
	
	return CategoryListView;

 
});