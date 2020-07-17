/*
 * this is the view to display the item collection list
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
        //libs
        Util		= require('util'),
        AppSettings = require('appSettings'),
        
        //models
        UserModel		= require('models/userModel'),
        CategoryModel		= require('models/categoryModel'),
        ItemModel 	= require('models/itemModel'),
        
        //views
        addItemView			= require('views/items/addItemView'),
        deleteItemView		= require('views/items/deleteItemView'),
        itemListThumbView	= require('views/items/itemListThumbView'),
        itemDetailView		= require('views/items/itemDetailView'),
        
        //templates
    	itemListTmpl         	= require('text!../../../templates/items/itemListView.html'),
    	itemListThumbViewTmpl   = require('text!../../../templates/items/itemListThumbView.html'),
    	itemDetailViewTmpl      = require('text!../../../templates/items/itemDetailView.html')
    	
    	;
    	
	var ItemListView = Backbone.View.extend({
		
		customEvt: null,
		
		categoryModel: null,
	    
		initialize: function(options) {
	        _.bindAll(this, 'render', 'getItem');	
	        var items,
	        	Item
	        ;
	        //create new item instance
	        //Item = new ItemModel();
	        //this.model = Item;
	        this.model = ItemModel;
	        
	        //get item data (cache) then update the model instance
	        //items = JSON.stringify(this.model.getItemData());
	        items = JSON.stringify(ItemModel.itemData);
	        
        	this.model.set({
				data:items
			});
        	
        	//init custom events
        	this.customEvt = options.customEvt;
        	
        	//init and render the item thumblist view
            this.itemListThumbs = new itemListThumbView({el:"#content", customEvt: this.customEvt});
            this.itemListThumbs.render().$el;
            
            //init but DO NOT render the item detail view
            this.itemDetail = new itemDetailView({el:"#content", customEvt: this.customEvt});
            
            //bind model instance on data change 
        	this.model.bind('change:data', this.render);
	        
        	//bind category:selected event to refresh view
	        this.customEvt.on("category:selected", this.setCategoryModel, this);
	    },
	    
	    setCategoryModel: function(categories){
	    	//set the category model (local)
	    	this.categoryModel = categories;
	    	this.render();
	    },

        render: function () {
        	var items,
        		template,
        		categoryId;
        	
        	//get the items
        	items = $.parseJSON(this.model.get("data"));
        	
        	//load the template
        	template = Handlebars.compile(itemListTmpl);
        	
        	//filter data if category id does not equal null or 0
        	if (this.categoryModel != null && this.categoryModel.get("selectedId") != 0){
        		//get selected category id
        		categoryId = this.categoryModel.get("selectedId");
        		
        		//filter items
        		items = Util.filterItemsByCategory(items, categoryId);
        	}
	    	
        	//update DOM
        	this.$el.html(template(items));
        	
            Util.changeHeight();
            
            return this;
        },
        
        events: {
	        'click #inventory-column .list-group-item a' : 'getItem',
	        'click .viewAddItem' : 'addItem',
	        'click .viewDeleteItem' : 'deleteItem'
	    },
	    
	    getItem: function(e) {
	    	e.preventDefault();
	    	var itemId,
	    		filterObject,
	    		category,
	    		categoryId,
	    		data,
	    		me
	    		;
	    	
	    	//get the selected item
		 	itemId = $(e.currentTarget).attr("data-id");
		 	console.log(itemId);  
		 	
		 	me = this;
		 	
		 	//highlight selected item
		 	$("#inventory-column .list-group-item").removeClass("active");
		 	$(e.currentTarget).parent().addClass("active");
		 	
		 	//update the selected item Id attribute
		 	this.model.set({
		 		selectedId:itemId
			});
		 	
		 	if(itemId == 0){
		 		//display thumbview
		 		this.itemListThumbs.render().$el;
		 	}
		 	else{
		 		//trigger the category selected event
			 	this.customEvt.trigger("item:selected", this.model);
		 	}
		 	
		 	//change the url
		 	AppSettings.router.navigate("#/inventory/item/" + itemId, {trigger: false});
	    },
	    
	    addItem: function(e){
	    	e.preventDefault();
	    	
	    	var addItem;
	    	
	    	addItem = new addItemView({el:"#inventoryModal .modal-content", categoryModel: this.categoryModel});
	    	addItem.render().$el;
			
 			Util.displayModal(addItem);
	    },
	    
	    deleteItem: function(e){
	    	e.preventDefault();
	    	
	    	var deleteItem;
	    	
	    	deleteItem = new deleteItemView({el:"#inventoryModal .modal-content"});
	    	deleteItem.render().$el;
			
 			Util.displayModal(deleteItem);
	    }
	});
	
	return ItemListView;

 
});