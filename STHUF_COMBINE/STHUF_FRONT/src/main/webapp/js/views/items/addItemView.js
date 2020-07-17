/*
 * this is the view to display the add item page
 * 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
        Handlebars	= require('handlebars'),
        
    	addItemTmpl         = require('text!../../../templates/items/addItemView.html'),
    	addItemTemplate = _.template(addItemTmpl)
    ;
    	
	var AddItemView = Backbone.View.extend({
		
		categoryModel: "",
		
	    initialize: function() {
	        _.bindAll(this, 'render');
	        //this.render();
	        
	    },
		
        render: function () {
            this.$el.html(addItemTemplate);
            return this;
        },
        
        events: {
	        'change #addItemForm .item-upload-pic' : 'changePreviewImage',
	        'click #addItemForm button' : 'addItem'
	    },
	    
        changePreviewImage: function (event) {
	    	
	    	var file = event.target.files[0];
 
			var readImg = new FileReader();
   
			readImg.readAsDataURL(file);
   
			readImg.onload = function(e) {
				$('#addItemForm .img-src').html('<img src="' + e.target.result + '" />').fadeIn();
			}
	    	
        },
        
        addItem: function (event) {
	    	
        }
        
	});
	
	return AddItemView;

 
});