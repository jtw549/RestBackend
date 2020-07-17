/*
 * this file contains the global utility functions
 * 			 
 */
define(function (require) {
 
    //"use strict";
 
    var $           = require('jquery'),
        _           = require('underscore'),
        Backbone    = require('backbone'),
   
        currentView	= "",
        currentSubView	= ""
    ;
    
	   
    var Util = {
    		
    	//creates the fixed height for the different modules
		changeHeight: function(){
			var windowHeight = $(window).height();
			$(".flexible").css('height', windowHeight - 155 + 'px');
			$(".flexible-lmt").css('min-height', windowHeight - 191 + 'px');
			$(".column-content").css('height', windowHeight - 222 + 'px');
			$(".tab-pane").css('min-height', windowHeight - 219 + 'px');
		},
    
	    resizeWindow: function (){
			$(window).resize(function(){
				Util.changeHeight();
			});
		},
		
		changeView: function(view) {
			if(currentView != "" && view != currentView){
				this.closeView(currentView);
				
				//close subviews
				currentView.closeSubViews();
				//currentView.undelegateEvents();
			}	
			currentView = view;
			currentView.render();
		},
		
		changeSubView: function(view){
			if(currentSubView != "" && view != currentSubView){
				this.closeView(currentSubView);
			}	
			currentSubView = view;
		},
		
		closeView: function(view){
			view.remove();
			view.unbind();
		},
		
		filterItem: function(data, itemId){
	    	var filteredObject = [];
	    	
			_.each(data, function(item) {
				//console.log(item.categories.data);
				if(item.id == itemId){
					filteredObject.push(item);
				}
		    });
			
			return filteredObject;
	    },
	    
	    filterItemsByCategory: function(data, categoryId){
	    	var filteredObject = [],
	    	    items;
	    	
	    	items = data;
			_.each(items, function(item) {
				//console.log(item.categories);
				if(item.categories.data){
					_.each(item.categories.data, function(category) {
						if(category.id == categoryId){
				        	filteredObject.push(item);
				        }
					});
				}
		    });
			
			return filteredObject;
	    },
	    
	    displayModal: function(modalView){
            
            //display modal
	    	$("#inventoryModal").modal('show');
	    	
	    	//undelegate events upon closing modal
	    	$('#inventoryModal').on('hide.bs.modal', function (e) {
	    		modalView.undelegateEvents();
    		});
	    },
	    
	    initItemDetailViewPopover: function(){
	    	var parent = this;
	    	
	    	//initiate the popover for each item tab (info, photos, videos, etc.)
	    	$("[data-toggle='popover']").popover({
		 		html: true,
 				content: function(){
 					var me;
 					me = $(this);
 					popContent = $('#' + me.attr("data-popover-content")).html();
 					
 					return popContent;
 				},
 				trigger: 'click',
 				placement: 'bottom',
 				container: '#main-content .container',
 				template: '<div class="popover item-meta-popover"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content"></div></div>'
		 	});
	    	
		 	//once popover is displayed, set the hide event
		 	$("[data-toggle='popover']").on('shown.bs.popover', function () {
		 		var me = $(this);
		 		$('body').on('click', function (e) {
		 		    $('[data-toggle="popover"]').each(function () {
		 		        //the 'is' for buttons that trigger popups
		 		        //the 'has' for icons within a button that triggers a popup
		 		        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
		 		            $(this).popover('hide');
		 		        }
		 		    });
		 		});	
		 		
		 		
	 		});
	    },
	    
	    deleteItemMetaView: function(){
	    	//remove the checkmark
	    	$(".delete-check").removeClass("glyphicon glyphicon-ok");
	    	
	    	//close the popover
			$("[data-toggle='popover']").popover('hide');
			
	    	//show the delete boxes
	    	$(".delete-selection").show("fast", function(){
	    		var me = $(this);
				
	    		//show the cancel and save buttons
	    		$(".delete-footer").removeClass("hide");
				
	    		//cancel button click handler
				$(".delete-cancel").on('click', function(e){
					//hide the delete boxes
					me.hide();
					
					//remove the delete boxes click handler
					me.unbind("click");
					
					//hide the cancel and save buttons
			    	$(e.currentTarget).parent().addClass("hide");
				});
				
				//delete box click handler
				me.on('click', function(e){
			    	e.preventDefault();
			    	
			    	//toggle checkbox
			    	$(".delete-check", e.currentTarget).toggleClass("glyphicon glyphicon-ok");
			    });
				
	    	});
			
	    }
    };
     
    return Util;

});