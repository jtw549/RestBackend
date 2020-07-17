/*
 * this is the view to display the items in thumbnails on the inventory page
 * 
 */

define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
        Util		= require('util'),
        
        ItemModel 	= require('models/itemModel'),
        
        //include the item thumbnail template
        itemListThumbTmpl  = require('text!../../../templates/items/itemListThumbView.html')
        ;
    
	var ItemListThumbView = Backbone.View.extend({
		
		customEvt: null,
		
		categoryModel: null,
		
		initialize:function(options){
    	
			this.customEvt = options.customEvt;
	        this.customEvt.on("category:selected", this.setCategoryModel, this);
	    },
		
        render: function () {
        
        	var items,
    		template;
    	
        	//items = $.parseJSON(this.model.get("data"));
        	items = $.parseJSON(ItemModel.model.get("data"));
        	
        	template = Handlebars.compile(itemListThumbTmpl);
        	
        	//filter data if category id does not equal null or 0
        	if (this.categoryModel != null && this.categoryModel.get("selectedId") != 0){
        		//get selected category id
        		categoryId = this.categoryModel.get("selectedId");
        		
        		//filter items
        		items = Util.filterItemsByCategory(items, categoryId);
        	}
	    	
	    	this.$el.html(template(items));
        
            Util.changeHeight();
            
            return this;
        },
        
        events: {
	       // 'click #inventory-column .list-group-item a' : 'getItem'
	    },
	    
	    setCategoryModel: function(categories){
	    	this.categoryModel = categories;
	    	this.render();
	    },
        
        
	});
	
	return ItemListThumbView;

});