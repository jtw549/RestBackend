/*
 * this file contains the response for adding a note
 * 			 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone')
    ;
    
    var addNote = {
	    "status": "success",
	    "message": "",
	    "notes": {
	        "privacy": "",
	        "data": [
	            {
	                "noteId": "AFER3A3FFA3A3WAW",
	                "title": "test",
	                "description": "testing",
	                "dateAdded": ""
	            }
	        ]
	    }
    };
     
   
    return addNote;

});