/*
 * this is the view to display the items by category
 * sub views: 
 * 		1.itemListView
 * 		2.itemListThumbView	 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        
        Util		= require('util'),

        itemListView	= require('views/items/itemListView'),
        itemListThumbView	= require('views/items/itemListThumbView');

	var ByCategoryView = Backbone.View.extend({
	
		//el: $("#main-content .container"),
		
		initialize:function(){
			
	    },
		
        render: function () {
        	//add the item list
        	//Util.changeSubView("#theItems");
            this.itemList = new itemListView({el:"#theItems"});
            //itemListView.render().$el;
            this.itemList.render().$el;
            
		 	//show item thumb view (all items)
            //Util.changeSubView("#content");
	 		this.itemListThumbs = new itemListThumbView({el:"#content"});
	 		this.itemListThumbs.render().$el;
	 		//Util.changeSubView(this.itemListThumbs);
	 		
	 		//change the height of the tab pane/content
	 		Util.changeHeight();
        	
            return this;
        }
        
	});
	
	return ByCategoryView;

});