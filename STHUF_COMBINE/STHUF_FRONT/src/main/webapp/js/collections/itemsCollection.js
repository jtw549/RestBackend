define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        ItemModel 	= require('models/items/itemModel')
        ;
 
	var ItemsCollection = Backbone.Collection.extend({
	
        model: ItemModel,
        
        initialize: function(){

	      //this.add([project0, project1, project2, project3, project4]);
	
	    }
        
	});
	
	return ItemsCollection;

 
});