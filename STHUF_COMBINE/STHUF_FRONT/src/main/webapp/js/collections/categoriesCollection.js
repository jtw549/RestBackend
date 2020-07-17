/*
 * this file is to manage a list of the user categories 
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        categoryModel 	= require('models/items/itemModel')
        ;
 
	var CategoriesCollection = Backbone.Collection.extend({
	
        model: categoryModel,
        
        initialize: function(){

	      //this.add([project0, project1, project2, project3, project4]);
	
	    }
        
	});
	
	return CategoriesCollection;
});