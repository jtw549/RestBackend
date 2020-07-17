/*
 * this file contains the response for adding a item
 * 			 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone')
    ;
    
    var addItem = {
	    "status": "success",
	    "message": "Item successfully added!",
	    "item": {
	        "id": "234234234",
	        "make": "asdf",
	        "name": "asdf",
	        "categories": [
	            {
	                "id": "234234"
	            }
	        ]
	    }
    };
     
   
    return addItem;

});