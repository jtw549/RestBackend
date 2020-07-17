/*
 * this is the view to display the selected item details
 * sub views: 
 * 		1.nonLoginHeaderView
 * 		2.categoryListView
 * 		3.itemListView
 * 		4.itemDetailView	 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        
        Util		= require('util'),
        Item		= require('models/itemModel'),

        itemDetailView	= require('views/items/itemDetailView'),
        itemListThumbView	= require('views/items/itemListThumbView');
        
        //nonLoginHeaderView 	=	require('views/header/nonLoginHeaderView'),
        //categoryListView	= require('views/categories/categoryListView'),
        //itemListView	= require('views/items/itemListView'),
        //itemDetailView	= require('views/items/itemDetailView');
       
        //include the inventory parent page template
        //inventoryTemplate         = require('text!../../templates/inventory.html'),
        //inventoryPageTemplate = _.template(inventoryTemplate),
        
        //categoryId		= "",
        //inventoryId		= "";	
 
	var ItemView = Backbone.View.extend({
	
		//el: $("#main-content .container"),
		
		initialize:function(){
			
	    },
		
        render: function () {
        	var item = new Item(),
        		itemId;
        	
        	itemId = item.getSelectedId();
        	
        	
        	//add the inventory page template
        	
            //this.$el.html(inventoryPageTemplate());
            
            //add the non-login header sub view
            //this.nonLoginHeader = new nonLoginHeaderView({el:"#header"});
            //this.nonLoginHeader.render().$el;
            
            //add the categories list sub view
            //this.categoryList = new categoryListView({el:"#theCategories"});
            //this.categoryList.render().$el;
            
            
            //add the item list sub view
            //this.itemList = new itemListView({el:"#theItems"});
            //this.itemList.render().$el;
            
            //add the item thumb sub view
        	
        	if(itemId != 0){
	            this.itemDetail = new itemDetailView({el:"#content"});
	            //this.itemDetail.render().$el;
	            Util.changeSubView(this.itemDetail);
        	}
        	else{
        		//show item thumb view (all items)
		 		this.itemListThumbs = new itemListThumbView({el:"#content"});
		 		this.itemListThumbs.render().$el;
        	}
        	
            return this;
        }
        
	});
	
	return ItemView;

 
});